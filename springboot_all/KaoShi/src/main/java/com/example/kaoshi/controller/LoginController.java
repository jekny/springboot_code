package com.example.kaoshi.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.kaoshi.entity.SysUser;
import com.example.kaoshi.service.SysUserService;
import com.example.kaoshi.service.impl.SysUserServiceImpl;
import com.example.kaoshi.utils.JwtUtil;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * ClassName: LoginController
 * Description:
 *
 * @Author jekny
 * @Create 2026/9/19 15:18
 * @Version 1.0
 */
//登录接口 //写完接口后要写一个登录请求的拦截器interceptor
@Controller
public class LoginController {

    @Autowired
    private SysUserServiceImpl sysUserService;

    @GetMapping("/toLogin")
    public String toLogin(){
        return "login";
    }

    @PostMapping("/login")
    public String doLogin(String username, String password, HttpServletResponse response, Model model){
        //校验数据库中的用户名和密码
        LambdaQueryWrapper<SysUser> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(SysUser::getUsername,username);
        SysUser dbUser = sysUserService.getOne(wrapper);
        if (dbUser == null || !dbUser.getPassword().equals(password)){
            model.addAttribute("msg","用户不存在或密码错误");
            return "login";
        }else {
//使用Jwt生成token
            String token = JwtUtil.createToken(dbUser.getId());
            Cookie cookie = new Cookie("token", token);
            cookie.setPath("/");
            cookie.setMaxAge(60*60);//1小时过期时间
            response.addCookie(cookie);
            return "redirect:/score/list";
            //这里不能直接返回index页面，没有数据，这里要xxxx查询所有成绩的接口
        }

    }

    @GetMapping("/")
    public String denglu(){
        return "redirect:/score/list";
    }


}
