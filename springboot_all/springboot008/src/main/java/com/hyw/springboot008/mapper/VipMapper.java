package com.hyw.springboot008.mapper;

import com.hyw.springboot008.entity.Vip;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * ClassName: VipMapper
 * Description:
 *
 * @Author jekny
 * @Create 2026/9/4 11:56
 * @Version 1.0
 */
@Mapper
public interface VipMapper {
    List<Vip> listall();

    Vip getid(String id);
}
