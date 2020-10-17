package com.example.MyFirstWebApp.controllers;

import com.example.MyFirstWebApp.domain.Basket;
import com.example.MyFirstWebApp.domain.User;
import com.example.MyFirstWebApp.domain.UserRole;
import com.example.MyFirstWebApp.models_of_form.RegistrationForm;
import com.example.MyFirstWebApp.repository.UserRepository;
import com.example.MyFirstWebApp.repository.UserRoleRepository;
import com.example.MyFirstWebApp.services.RegistrationUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegistrationController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserRoleRepository userRoleRepository;

    @Autowired
    private RegistrationUserService registrationUserService;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @GetMapping("/registration")
    public String registrationPage(Model model)
    {
        model.addAttribute("title", "Registration");
        model.addAttribute("registrationForm", new RegistrationForm());
        return "registration";
    }

    @PostMapping("/registration")
    public String registerNewUser(@ModelAttribute RegistrationForm registrationForm, Model model)
    {
        model.addAttribute("title", "Registration");
        if (userRepository.findByLogin(registrationForm.getLogin()) != null || userRepository.findByEmail(registrationForm.getEmail()) != null)
        {
            model.addAttribute("message", "A user with this username or email already exists. Enter other data.");
            return "registration";
        }
        User newUser;
        if (registrationUserService.isCorrectUserData(registrationForm.getLogin(), registrationForm.getEmail(), registrationForm.getPassword(),
                registrationForm.getName(), registrationForm.getSurname(), registrationForm.getTel())) {
            newUser = new User();
            Basket userBasket = new Basket();
            BeanUtils.copyProperties(registrationForm, newUser);
            newUser.setActive(true);
            newUser.setUserRole(userRoleRepository.findByTypeOfUserRights(UserRole.TypeOfUserRights.USER));
            newUser.setBasket(userBasket);
        }
        else {
            return "registration";
        }
        userRepository.save(newUser);
        return "redirect:/entry";
    }
}