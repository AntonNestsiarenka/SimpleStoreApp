package com.example.MyFirstWebApp.controllers;

import com.example.MyFirstWebApp.domain.CategoryOfGood;
import com.example.MyFirstWebApp.domain.Good;
import com.example.MyFirstWebApp.domain.Manufacturer;
import com.example.MyFirstWebApp.models_of_form.AddGoodForm;
import com.example.MyFirstWebApp.repository.CategoryOfGoodRepository;
import com.example.MyFirstWebApp.repository.GoodRepository;
import com.example.MyFirstWebApp.repository.ManufacturerRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.math.BigDecimal;
import java.util.List;

@Controller
public class GoodController {

    @Autowired
    private CategoryOfGoodRepository categoryOfGoodRepository;

    @Autowired
    private ManufacturerRepository manufacturerRepository;

    @Autowired
    private GoodRepository goodRepository;

    @GetMapping("/add_good")
    public String addGood(Model model)
    {
        List<CategoryOfGood> categories = categoryOfGoodRepository.findAll();
        List<Manufacturer> manufacturers = manufacturerRepository.findAll();
        model.addAttribute("title", "Add good to catalog");
        model.addAttribute("categories", categories);
        model.addAttribute("manufacturers", manufacturers);
        model.addAttribute("addGoodForm", new AddGoodForm());
        return "add_good";
    }

    @PostMapping("/add_good")
    public String addGoodToCatalog(@ModelAttribute AddGoodForm addGoodForm, Model model)
    {
        Good newGood = new Good();
        BeanUtils.copyProperties(addGoodForm, newGood);
        goodRepository.save(newGood);
        return "redirect:/add_good";
    }

}
