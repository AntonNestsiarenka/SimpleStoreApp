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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.sql.Timestamp;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/menu")
public class OrderController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BasketService basketService;

    @Autowired
    private StatusOrderRepository statusOrderRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private GoodsBasketsRepository goodsBasketsRepository;

    @Autowired
    private GoodsOrdersRepository goodsOrdersRepository;

    @GetMapping("/my_orders")
    public String myOrders(Authentication authentication, Model model)
    {
        User currentUser = userRepository.findByLogin(authentication.getName());
        List<Order> ordersOfUser = currentUser.getOrders();
        model.addAttribute("title", "My orders");
        if (!ordersOfUser.isEmpty()) {
            model.addAttribute("orders", ordersOfUser);
        }
        return "my_orders";
    }

    @PostMapping("/cart/order_now")
    public String doOrder(@RequestParam DeliveryTypeOrder deliveryType, @RequestParam PaymentTypeOrder paymentType, Authentication authentication, Model model)
    {
        User currentUser = userRepository.findByLogin(authentication.getName());
        Set<GoodsBaskets> goodsInUserBasket = currentUser.getBasket().getGoodsBaskets();
        Order order = new Order(new Timestamp(System.currentTimeMillis()), basketService.priceRefresh(goodsInUserBasket),
                statusOrderRepository.findByStatus(StatusOrder.Status.PROCESSING),
                deliveryType,
                paymentType,
                currentUser);
        orderRepository.save(order);
        for (GoodsBaskets goodInUserBasket : goodsInUserBasket)
        {
            goodsOrdersRepository.save(new GoodsOrders(new GoodOrderKey(goodInUserBasket.getGood().getId(), order.getId()), goodInUserBasket.getGood(), order, goodInUserBasket.getQuantity(), goodInUserBasket.getGood().getPrice()));
        }
        currentUser.getBasket().getGoodsBaskets().clear();
        goodsBasketsRepository.deleteAll(currentUser.getBasket().getGoodsBaskets());
        return "redirect:/menu/my_orders";
    }
}
