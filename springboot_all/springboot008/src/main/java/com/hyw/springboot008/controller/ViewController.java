package com.hyw.springboot008.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * ClassName: ViewController
 * Description:
 *
 * @Author jekny
 * @Create 2026/9/6 21:16
 * @Version 1.0
 */
@Controller
@RequestMapping(value = "/a")
public class ViewController {
    @GetMapping("/b")//@RequestParam注解是拿到请求路径?后面name=1中，name的值，这里的1赋到name参数上
    public String myview(@RequestParam("name") String name, Model model){
        model.addAttribute("name",name);
        System.out.println(name);
        return "hello";
    }
}
