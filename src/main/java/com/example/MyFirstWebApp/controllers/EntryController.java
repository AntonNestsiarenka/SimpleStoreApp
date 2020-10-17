package com.example.MyFirstWebApp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EntryController {

    @GetMapping("/entry")
    public String entryPage(Model model)
    {
        model.addAttribute("title", "Entry");
        return "entry";
    }
}
