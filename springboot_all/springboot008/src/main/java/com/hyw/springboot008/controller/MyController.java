package com.hyw.springboot008.controller;

import com.hyw.springboot008.entity.Vip;
import com.hyw.springboot008.service.VipServiceImpl;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * ClassName: MyController
 * Description:
 *
 * @Author jekny
 * @Create 2026/9/5 14:24
 * @Version 1.0
 */
@RestController
public class MyController {
    @Resource
    VipServiceImpl vipService;

    @PostMapping("/getid/{id}")
    public Vip getname(@PathVariable String id){
        return vipService.getId(id);
    }

    @PostMapping("/getall")
    public List<Vip> getall(){
        return vipService.getall();
    }
}
