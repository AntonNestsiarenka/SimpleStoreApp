package com.example.MyFirstWebApp.controllers;

import com.example.MyFirstWebApp.domain.CategoryOfGood;
import com.example.MyFirstWebApp.domain.Good;
import com.example.MyFirstWebApp.repository.GoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.math.BigDecimal;
import java.util.List;

@Controller
@RequestMapping("/catalog")
public class CatalogController {

    @Autowired
    private GoodRepository goodRepository;

    @GetMapping("/mobile_phones")
    public String mobilePhonesPage(Model model)
    {
        model.addAttribute("title", "Mobile phones");
        model.addAttribute("category", "Catalog of mobile phones");
        List<Good> mobilePhones = goodRepository.findByCategoryOfGood_CategoryName(CategoryOfGood.Category.MOBILE_PHONES);
        if (!mobilePhones.isEmpty()) {
            model.addAttribute("goods", mobilePhones);
        }
        return "catalog";
    }

    @GetMapping("/tablets")
    public String tabletsPage(Model model)
    {
        model.addAttribute("title", "Tablets");
        model.addAttribute("category", "Catalog of tablets");
        List<Good> tablets = goodRepository.findByCategoryOfGood_CategoryName(CategoryOfGood.Category.TABLETS);
        if (!tablets.isEmpty()) {
            model.addAttribute("goods", tablets);
        }
        return "catalog";
    }

    @GetMapping("/tv_s")
    public String tvsPage(Model model)
    {
        model.addAttribute("title", "TV`s");
        model.addAttribute("category", "Catalog of tv`s");
        List<Good> tvs = goodRepository.findByCategoryOfGood_CategoryName(CategoryOfGood.Category.TV);
        if (!tvs.isEmpty()) {
            model.addAttribute("goods", tvs);
        }
        return "catalog";
    }

    @GetMapping("/gaming_consoles")
    public String gamingConsolesPage(Model model)
    {
        model.addAttribute("title", "Gaming consoles");
        model.addAttribute("category", "Catalog of gaming consoles");
        List<Good> gamingConsoles = goodRepository.findByCategoryOfGood_CategoryName(CategoryOfGood.Category.GAMING_CONSOLES);
        if (!gamingConsoles.isEmpty()) {
            model.addAttribute("goods", gamingConsoles);
        }
        return "catalog";
    }

    @GetMapping("/monitors")
    public String monitorsPage(Model model)
    {
        model.addAttribute("title", "Monitors");
        model.addAttribute("category", "Catalog of monitors");
        List<Good> monitors = goodRepository.findByCategoryOfGood_CategoryName(CategoryOfGood.Category.MONITORS);
        if (!monitors.isEmpty()) {
            model.addAttribute("goods", monitors);
        }
        return "catalog";
    }

    @GetMapping("/laptops")
    public String laptopsPage(Model model)
    {
        model.addAttribute("title", "Laptops");
        model.addAttribute("category", "Catalog of laptops");
        List<Good> laptops = goodRepository.findByCategoryOfGood_CategoryName(CategoryOfGood.Category.LAPTOPS);
        if (!laptops.isEmpty()) {
            model.addAttribute("goods", laptops);
        }
        return "catalog";
    }

    @GetMapping("/cameras")
    public String camerasPage(Model model)
    {
        model.addAttribute("title", "Cameras");
        model.addAttribute("category", "Catalog of cameras");
        List<Good> cameras = goodRepository.findByCategoryOfGood_CategoryName(CategoryOfGood.Category.CAMERAS);
        if (!cameras.isEmpty()) {
            model.addAttribute("goods", cameras);
        }
        return "catalog";
    }

    @GetMapping("/{category}/{id}")
    public String concreteGoodPage(@PathVariable int id, Model model)
    {
        Good foundGood = goodRepository.findById(id);
        model.addAttribute("title", foundGood.getName());
        model.addAttribute("good_id", foundGood.getId());
        model.addAttribute("goodName", foundGood.getName());
        model.addAttribute("goodDescription", foundGood.getDescription());
        model.addAttribute("available", "Available for order: " + foundGood.getNumberOfAvailable());
        model.addAttribute("price", "Price: " + foundGood.getPrice().setScale(3, BigDecimal.ROUND_CEILING) + " USD");
        return "concrete_good";
    }
}
