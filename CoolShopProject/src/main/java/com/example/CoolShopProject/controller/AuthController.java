package com.example.CoolShopProject.controller;

import com.example.CoolShopProject.model.dto.accountDTO;
import com.example.CoolShopProject.model.enums.Gender;
import com.example.CoolShopProject.service.AccountService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class AuthController {

    private final AccountService accountService;

    public AuthController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/")
    public String root() {
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @GetMapping("/register")
    public String registerPage(Model model) {
        model.addAttribute("account", new accountDTO());
        model.addAttribute("genders", Gender.values());
        return "register";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute("account") accountDTO account,
                           Model model,
                           RedirectAttributes redirectAttributes) {
        try {
            accountService.register(account);
            redirectAttributes.addFlashAttribute("success", "Tạo tài khoản thành công. Vui lòng đăng nhập.");
            return "redirect:/login";
        } catch (IllegalArgumentException e) {
            model.addAttribute("error", e.getMessage());
            model.addAttribute("genders", Gender.values());
            return "register";
        }
    }

    @GetMapping("/home")
    public String home() {
        return "home";
    }
}
