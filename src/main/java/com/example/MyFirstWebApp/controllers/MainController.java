package com.example.MyFirstWebApp.controllers;

import com.example.MyFirstWebApp.domain.Good;
import com.example.MyFirstWebApp.repository.GoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;

@Controller
public class MainController {

    @Autowired
    GoodRepository goodRepository;

    @GetMapping("/")
    public String mainPage(Model model)
    {
        model.addAttribute("title", "Main Page");
        List<Good> allGoods =goodRepository.findAll();
        model.addAttribute("allGoods", allGoods);
        return "main";
    }

    @GetMapping("/catalog")
    public String catalogMenuPage(Model model)
    {
        model.addAttribute("title", "Catalog of goods");
        return "catalog_menu";
    }

    @GetMapping("/about")
    public String aboutPage(Model model)
    {
        model.addAttribute("title", "About");
        return "about";
    }

    @GetMapping("/services")
    public String servicesPage(Model model)
    {
        model.addAttribute("title", "Services");
        return "services";
    }

    @GetMapping("/contacts")
    public String contactsPage(Model model)
    {
        model.addAttribute("title", "Contacts");
        return "contacts";
    }

    @GetMapping("/reviews")
    public String reviewsPage(Model model)
    {
        model.addAttribute("title", "reviews");
        return "reviews";
    }
}