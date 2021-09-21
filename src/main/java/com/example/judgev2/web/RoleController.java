package com.example.judgev2.web;

import com.example.judgev2.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/roles")
public class RoleController {
    private final UserService userService;

    public RoleController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/add")
    public String addRoles(Model model) {
        model.addAttribute("names", userService.findAllUsernames());
        return "role-add";
    }

    @PostMapping("/add")
    public String addRolesConfirm(@RequestParam String username,
                                  @RequestParam String role) {
        userService.changeRole(username, role);
        return "redirect:/";
    }
}
