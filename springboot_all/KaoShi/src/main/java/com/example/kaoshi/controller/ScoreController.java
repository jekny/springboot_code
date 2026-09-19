package com.example.kaoshi.controller;

import com.example.kaoshi.entity.StudentScore;
import com.example.kaoshi.service.StudentScoreService;
import com.example.kaoshi.service.impl.StudentScoreServiceImpl;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
