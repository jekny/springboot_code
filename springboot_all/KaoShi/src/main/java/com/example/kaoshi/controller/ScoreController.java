package com.example.kaoshi.controller;

import com.example.kaoshi.entity.StudentScore;
import com.example.kaoshi.service.StudentScoreService;
import com.example.kaoshi.service.impl.StudentScoreServiceImpl;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * ClassName: ScoreController
 * Description:
 *
 * @Author jekny
 * @Create 2026/9/19 15:46
 * @Version 1.0
 */
@Controller
@RequestMapping("/score")
public class ScoreController {
    @Autowired
    private StudentScoreServiceImpl studentScoreService;

    @GetMapping("/list")
    public String getAll(Model model){
        List<StudentScore> list = studentScoreService.list();
        model.addAttribute("scoreList",list);
        return "index";
    }

    @PostMapping("/add")
    public String addStu(StudentScore studentScore){//为什么这里参数不用写注解，前端是提交到后端的一条一条信息，后端是如何拿到数据的呢
        studentScoreService.save(studentScore);
        return "redirect:/score/list";
    }

    @GetMapping("/detail")
    public String detailstu(@RequestParam Long id,Model model){
        StudentScore studentScore = studentScoreService.getById(id);
        model.addAttribute("score",studentScore);
        return "score_detail";
    }

    @GetMapping("/delete")
    public String deletestu(@RequestParam Long id){
        studentScoreService.removeById(id);
        return "redirect:/score/list";

    }
}
