package com.example.MyFirstWebApp.controllers;

import com.example.MyFirstWebApp.domain.*;
import com.example.MyFirstWebApp.repository.*;
import com.example.MyFirstWebApp.services.BasketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.Set;

@Controller
public class BasketController {

    @Autowired
    private GoodRepository goodRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BasketService basketService;

    @Autowired
    private GoodsBasketsRepository goodsBasketsRepository;

    @Autowired
    private PaymentTypeOrderRepository paymentTypeOrderRepository;

    @Autowired
    private DeliveryTypeOrderRepository deliveryTypeOrderRepository;

    @GetMapping("/cart")
    public String myCartPage(Authentication authentication, Model model)
    {
        model.addAttribute("title", "My cart");
        User currentUser = userRepository.findByLogin(authentication.getName());
        Set<GoodsBaskets> goodsBaskets = currentUser.getBasket().getGoodsBaskets();
        if (!goodsBaskets.isEmpty()) {

            model.addAttribute("deliveryTypes", deliveryTypeOrderRepository.findAll());
            model.addAttribute("paymentTypes", paymentTypeOrderRepository.findAll());
            model.addAttribute("goodsInBasket", goodsBaskets);
            model.addAttribute("commonPrice", "Common price:" + basketService.priceRefresh(goodsBaskets).setScale(3, BigDecimal.ROUND_CEILING) + " USD");
        }
        return "cart";
    }

    @PostMapping("/add_to_cart")
    public String addGoodToCart(@RequestParam int id, @RequestParam int quantity, Authentication authentication, Model model)
    {
        Good foundGood = goodRepository.findById(id);
        User currentUser = userRepository.findByLogin(authentication.getName());
        Optional<GoodsBaskets> foundGoodsBaskets = goodsBasketsRepository.findById(new GoodBasketKey(id, currentUser.getBasket().getId()));
        if (foundGoodsBaskets.isPresent() && currentUser.getBasket().getGoodsBaskets().contains(foundGoodsBaskets.get())) {
            foundGoodsBaskets.get().setQuantity(foundGoodsBaskets.get().getQuantity() + quantity);
            goodsBasketsRepository.save(foundGoodsBaskets.get());
        }
        else {
            GoodsBaskets goodsBasketsNew = new GoodsBaskets(new GoodBasketKey(id, currentUser.getBasket().getId()), foundGood, currentUser.getBasket(), quantity);
            goodsBasketsRepository.save(goodsBasketsNew);
        }
        return "redirect:/cart";
    }

    @PostMapping("/remove")
    public String removeFromCart(@RequestParam GoodsBaskets goodsBaskets, Model model)
    {
        goodsBaskets.getBasket().getGoodsBaskets().remove(goodsBaskets);
        goodsBasketsRepository.deleteById(goodsBaskets.getId());
        return "redirect:/cart";
    }

    @GetMapping("/clear_cart")
    public String clearCart(Authentication authentication, Model model)
    {
        User currentUser = userRepository.findByLogin(authentication.getName());
        currentUser.getBasket().getGoodsBaskets().clear();
        goodsBasketsRepository.deleteAll(currentUser.getBasket().getGoodsBaskets());
        return "redirect:/cart";
    }
}
