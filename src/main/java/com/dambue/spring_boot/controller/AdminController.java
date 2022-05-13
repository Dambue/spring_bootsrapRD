package com.dambue.spring_boot.controller;

import com.dambue.spring_boot.model.User;
import com.dambue.spring_boot.service.UserService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;


@Controller
@RequestMapping("/admin")
public class AdminController {

    private final UserService userService;
    private final UserDetailsService userDetailsService;

    public AdminController(UserService userService, UserDetailsService userDetailsService) {
        this.userService = userService;
        this.userDetailsService = userDetailsService;
    }

    @GetMapping("/users")
    public String getUsers(Model model, @AuthenticationPrincipal User user) {
        model.addAttribute("user", user);
        model.addAttribute("users", userService.getUsersWithRoles());
        return "admin";
    }

    @GetMapping("/user/{id}")
    public String getUserById(@PathVariable("id") Long id, Model model) {
        model.addAttribute("user", userService.getUserById(id));
        return "admin";
    }

    @GetMapping("/user/new")
    public String newUser(User user, Model model) {
        model.addAttribute("user", user);
        return "admin";
    }

    @PostMapping("/user/new")
    public String creat(@ModelAttribute User user,
                        @RequestParam Long[] roleList) {
        userService.save(user, roleList);
        return "redirect:/admin/users";
    }

    @GetMapping("/user/{id}/edit")
    public String edit(@PathVariable("id") Long id, Model model) {
        model.addAttribute("user", userService.getUserById(id));
        return "admin";
    }

    @PatchMapping("/user/{id}/edit")
    public String update(@ModelAttribute("user") User user,
                         @PathVariable("id") Long id,
                         @RequestParam Long[] roleList) {
        userService.update(id, user, roleList);
        return "redirect:/admin/users";
    }

    @DeleteMapping("/user/{id}")
    public String delete(@PathVariable("id") Long id) {
        userService.delete(id);
        return "redirect:/admin/users";
    }
}
