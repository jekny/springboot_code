package com.hyw.springboot008.service;

import com.hyw.springboot008.entity.Vip;

import java.util.List;

/**
 * ClassName: VipService
 * Description:
 *
 * @Author jekny
 * @Create 2026/9/4 11:57
 * @Version 1.0
 */

public interface VipService {
    List<Vip> getall();

    Vip getId(String id);
}
