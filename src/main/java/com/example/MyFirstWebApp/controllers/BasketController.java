package com.example.MyFirstWebApp.controllers;

import com.example.MyFirstWebApp.domain.Good;
import com.example.MyFirstWebApp.domain.GoodInBasket;
import com.example.MyFirstWebApp.domain.User;
import com.example.MyFirstWebApp.repository.*;
import com.example.MyFirstWebApp.services.BasketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;

@Controller
public class BasketController {

    @Autowired
    private GoodRepository goodRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private GoodInBasketRepository goodInBasketRepository;

    @Autowired
    private BasketService basketService;

    @Autowired
    private PaymentTypeOrderRepository paymentTypeOrderRepository;

    @Autowired
    private DeliveryTypeOrderRepository deliveryTypeOrderRepository;

    @GetMapping("/cart")
    public String myCartPage(Authentication authentication, Model model)
    {
        model.addAttribute("title", "My cart");
        User currentUser = userRepository.findByLogin(authentication.getName());
        List<GoodInBasket> goodsInBasket = currentUser.getBasket().getGoodsInBasket();
        if (!goodsInBasket.isEmpty()) {

            model.addAttribute("deliveryTypes", deliveryTypeOrderRepository.findAll());
            model.addAttribute("paymentTypes", paymentTypeOrderRepository.findAll());
            model.addAttribute("goodsInBasket", goodsInBasket);
            model.addAttribute("commonPrice", "Common price:" + basketService.priceRefresh(goodsInBasket).setScale(3) + " USD");
        }
        return "cart";
    }

    @PostMapping("/add_to_cart")
    public String addGoodToCart(@RequestParam int id, @RequestParam int quantity, Authentication authentication, Model model)
    {
        Good foundGood = goodRepository.findById(id);
        User currentUser = userRepository.findByLogin(authentication.getName());
        GoodInBasket foundGoodInBasket = goodInBasketRepository.findByGood_Id(id);
        if (goodInBasketRepository.findByGood_Id(id) == null) {
            goodInBasketRepository.save(new GoodInBasket(foundGood, quantity, currentUser.getBasket()));
        }
        else {
            foundGoodInBasket.setNumberOfGoods(foundGoodInBasket.getNumberOfGoods() + quantity);
            goodInBasketRepository.save(foundGoodInBasket);
        }
        return "redirect:/cart";
    }

    @PostMapping("/remove")
    public String removeFromCart(@RequestParam GoodInBasket goodInBasket, Model model)
    {
        goodInBasket.getBasket().getGoodsInBasket().remove(goodInBasket);
        goodInBasketRepository.deleteById(goodInBasket.getId());
        return "redirect:/cart";
    }

    @GetMapping("/clear_cart")
    public String clearCart(Authentication authentication, Model model)
    {
        User currentUser = userRepository.findByLogin(authentication.getName());
        currentUser.getBasket().getGoodsInBasket().clear();
        goodInBasketRepository.deleteAll(currentUser.getBasket().getGoodsInBasket());
        return "redirect:/cart";
    }
}
