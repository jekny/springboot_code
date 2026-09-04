package com.hyw.springboot008.service;

import com.hyw.springboot008.entity.Vip;
import com.hyw.springboot008.mapper.VipMapper;
import jakarta.annotation.Resource;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * ClassName: VipServiceImpl
 * Description:
 *
 * @Author jekny
 * @Create 2026/9/4 11:59
 * @Version 1.0
 */
@Service
//@RequiredArgsConstructor
public class VipServiceImpl implements VipService{


//    private final VipMapper vipMapper;
    @Autowired
    VipMapper vipMapper;
    @Override
    public void getall() {
        System.out.println(vipMapper.listall());
    }
}
