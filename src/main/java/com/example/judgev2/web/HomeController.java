package com.example.judgev2.web;

import com.example.judgev2.security.CurrentUser;
import com.example.judgev2.service.CommentService;
import com.example.judgev2.service.ExerciseService;
import com.example.judgev2.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    private final CurrentUser currentUser;
    private final ExerciseService exerciseService;
    private final CommentService commentService;
    private final UserService userService;

    public HomeController(CurrentUser currentUser, ExerciseService exerciseService, CommentService commentService, UserService userService) {
        this.currentUser = currentUser;
        this.exerciseService = exerciseService;
        this.commentService = commentService;
        this.userService = userService;
    }

    @GetMapping("/")
    public String home(Model model){
        if (currentUser.isAnonymous()){
            return "index";
        }

        model.addAttribute("exercise", exerciseService.findAllExerciseNames());
        model.addAttribute("student", commentService.getTopScoreStudents());
        model.addAttribute("avg", commentService.getAverageScore());
        model.addAttribute("usersCount", userService.usersCount());

        return "home";
    }
}
