package com.example.judgev2.web;

import com.example.judgev2.model.binding.CommentAddBindingModel;
import com.example.judgev2.model.binding.HomeworkAddBindingModel;
import com.example.judgev2.model.service.CommentServiceModel;
import com.example.judgev2.model.service.HomeworkServiceModel;
import com.example.judgev2.model.view.HomeworkViewModel;
import com.example.judgev2.service.CommentService;
import com.example.judgev2.service.ExerciseService;
import com.example.judgev2.service.HomeworkService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/homework")
public class HomeworkController {
    private final ExerciseService exerciseService;
    private final HomeworkService homeworkService;
    private final CommentService commentService;
    private final ModelMapper modelMapper;

    public HomeworkController(ExerciseService exerciseService, HomeworkService homeworkService, CommentService commentService, ModelMapper modelMapper) {
        this.exerciseService = exerciseService;
        this.homeworkService = homeworkService;
        this.commentService = commentService;
        this.modelMapper = modelMapper;
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String getAddHomework(Model model) {
        model.addAttribute("allExercises", exerciseService.findAllExerciseNames());
        if (!model.containsAttribute("homeworkAddBindingModel")) {
            model.addAttribute("homeworkAddBindingModel", new HomeworkAddBindingModel());
        }
        if (!model.containsAttribute("selected")) {
            model.addAttribute("selected", "");
        }
        if (!model.containsAttribute("expired")) {
            model.addAttribute("expired", false);
        }
        return "homework-add";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addHomework(@Valid HomeworkAddBindingModel homeworkAddBindingModel,
                              BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        // 1. CHECK FOR CORRECT INPUT @VALID
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("homeworkAddBindingModel", homeworkAddBindingModel);
            redirectAttributes.addFlashAttribute("selected", homeworkAddBindingModel.getExercise());
            redirectAttributes.addFlashAttribute(
                    "org.springframework.validation.BindingResult.homeworkAddBindingModel", bindingResult);
            return "redirect:add";
        }
        // 2. SHOW "You are late" FOR EXPIRED EXERCISES/HOMEWORKS
        if (exerciseService.isExpiredByName(homeworkAddBindingModel.getExercise())) {
            redirectAttributes.addFlashAttribute("expired", true);
            return "redirect:add";
        }
        // 3. ADD HOMEWORK IN DB
        homeworkService.addHomework(homeworkAddBindingModel.getExercise(), homeworkAddBindingModel.getGitAddress());

        return "redirect:/";
    }

    @GetMapping("/check")
    public String getCheckHomeworkPage(Model model) {
        HomeworkServiceModel leastCommented = homeworkService.findLeastCommented();
        HomeworkViewModel homeworkViewModel = modelMapper.map(leastCommented, HomeworkViewModel.class);
        model.addAttribute("homework", homeworkViewModel);
        if (!model.containsAttribute("commentAddBindingModel")) {
            model.addAttribute("commentAddBindingModel", new CommentAddBindingModel());
        }
        return "homework-check";
    }

    @PostMapping("/check")
    public String addScoreComment(@Valid CommentAddBindingModel commentAddBindingModel,
                                  BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("commentAddBindingModel", commentAddBindingModel);
            redirectAttributes.addFlashAttribute(
                    "org.springframework.validation.BindingResult.commentAddBindingModel", bindingResult);
            return "redirect:check";
        }
        // SAVE SCORE AND COMMENT IN DB
        CommentServiceModel commentServiceModel =
                modelMapper.map(commentAddBindingModel, CommentServiceModel.class);
        commentService.saveScoreAndComment(commentServiceModel, commentAddBindingModel.getHomeworkId());

        return "redirect:/";
    }
}
