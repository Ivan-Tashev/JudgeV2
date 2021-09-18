package com.example.judgev2.web;

import com.example.judgev2.model.binding.UserLoginBindingModel;
import com.example.judgev2.model.binding.UserRegisterBindingModel;
import com.example.judgev2.model.service.UserServiceModel;
import com.example.judgev2.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("/users")
public class UserController {
    private final UserService userService;
    private final ModelMapper modelMapper;

    public UserController(UserService userService, ModelMapper modelMapper) {
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/login")
    public String login(Model model) {
        if (!model.containsAttribute("userLoginBindingModel")) {
            model.addAttribute("userLoginBindingModel", new UserLoginBindingModel());
            model.addAttribute("notFound", false);
        }
        return "login";
    }

    @PostMapping("login")
    public String loginConfirm(@Valid
                               @ModelAttribute UserLoginBindingModel userLoginBindingModel, // model reading Data from <form>
                               BindingResult bindingResult, // holds Target model(UserLoginModel) and Errors
                               RedirectAttributes redirectAttributes, // to return Data into <form>
                               HttpSession httpSession) { // holds attribute with LoggedIn user all data (from DB)
        // 1. CHECK FOR ENTRY @VALIDATIONS
        if (bindingResult.hasErrors()) { // if have errors (like: username length...)
            redirectAttributes.addFlashAttribute("userLoginBindingModel", userLoginBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.userLoginBindingModel",
                    bindingResult);
            return "redirect:/users/login";
        }
        // save User in HttpSession or @Bean CurrentUser
        final UserServiceModel user = userService.findUserByUsernameAndPassword(userLoginBindingModel.getUsername(),
                userLoginBindingModel.getPassword());
        // 2. CHECK FOR CORRECT LOGIN (username=pass)
        if (user == null) { // if not found in DB
            redirectAttributes.addFlashAttribute("userLoginBindingModel", userLoginBindingModel);
            redirectAttributes.addFlashAttribute("notFound", true);
            return "redirect:login";
        }
        // Option A - HttpSession to be set with UserServiceModel data coming from UserLoginBindingModel
        httpSession.setAttribute("user", user);

        // Option B - @Bean CurrentUser to be set with UserServiceModel data coming from UserLoginBindingModel
        userService.login(user);

        return "redirect:/";
    }

    @GetMapping("/register")
    public String register(Model model) {
        if (!model.containsAttribute("userRegisterBindingModel")) { // check if exist
            model.addAttribute("userRegisterBindingModel", new UserRegisterBindingModel());
        }
        return "register";
    }

    @PostMapping("/register")
    public String registerConfirm(
            @Valid // @validate the Binding model UserRegisterBindingModel
            @ModelAttribute UserRegisterBindingModel userRegisterBindingModel, // all fields from request html form
            BindingResult bindingResult, // Spring fill all returns/errors here
            RedirectAttributes redirectAttributes  // redirect (status 301) saving attributes
    ) {
        if (bindingResult.hasErrors() || // validation errors check
                !userRegisterBindingModel.getPassword().equals(userRegisterBindingModel.getConfirmPassword())) {
            // POST redirect GET, return the Binding model back, with the error messages
            redirectAttributes.addFlashAttribute("userRegisterBindingModel", userRegisterBindingModel);
            redirectAttributes.addFlashAttribute(
                    "org.springframework.validation.BindingResult.userRegisterBindingModel", bindingResult);
            return "redirect:register";
        }
        UserServiceModel userServiceModel = modelMapper
                .map(userRegisterBindingModel, UserServiceModel.class);
        userService.registerUser(userServiceModel);

        return "redirect:login";
    }
}
