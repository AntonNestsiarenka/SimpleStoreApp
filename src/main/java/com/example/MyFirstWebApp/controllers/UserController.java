package com.example.MyFirstWebApp.controllers;

import com.example.MyFirstWebApp.domain.User;
import com.example.MyFirstWebApp.domain.UserRole;
import com.example.MyFirstWebApp.dto.UserDto;
import com.example.MyFirstWebApp.repository.UserRepository;
import com.example.MyFirstWebApp.repository.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    UserRoleRepository userRoleRepository;

    @GetMapping("/menu")
    public String getMenu(Authentication authentication, Model model)
    {
        User currentUser = userRepository.findByLogin(authentication.getName());
        model.addAttribute("title", "User menu");
        switch (currentUser.getUserRole().getTypeOfUserRights())
        {
            case USER:
            {
                return "user_menu";
            }
            case ADMIN:
            {
                model.addAttribute("title", "Admin menu");
                return "admin_menu";
            }
            default:
                return "user_menu";
        }
    }

    @GetMapping("/menu/all_users")
    public String getAllUsers(Model model)
    {
        model.addAttribute("title", "All users");
        List<User> allUsers = userRepository.findAll();
        List<UserDto> allUsersDto = new ArrayList<>();
        for (User user : allUsers) {
            allUsersDto.add(new UserDto(user.getId(), user.getLogin(), user.getActive(), user.getUserRole()));
        }
        model.addAttribute("allUsersDto", allUsersDto);
        return "all_users";
    }

    @GetMapping("/menu/all_users/{id}")
    public String concreteUser(@PathVariable int id, Model model)
    {
        model.addAttribute("title", "Concrete user");
        User foundUser = userRepository.findById(id);
        UserDto userDto = new UserDto(foundUser.getId(), foundUser.getLogin(), foundUser.getActive(), foundUser.getUserRole());
        model.addAttribute("user", userDto);
        model.addAttribute("allRoles", userRoleRepository.findAll());
        return "concrete_user";
    }

    @PostMapping("/menu/all_users/{id}")
    public String moderateUser(@PathVariable int id, @RequestParam String isActive, @RequestParam UserRole userRole, Model model)
    {
        User foundUser = userRepository.findById(id);
        foundUser.setActive((!isActive.equals("Block")));
        foundUser.setUserRole(userRole);
        userRepository.save(foundUser);
        return "redirect:/menu/all_users";
    }
}
