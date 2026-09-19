package com.example.kaoshi.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * ClassName: SysUser
 * Description:
 *
 * @Author jekny
 * @Create 2026/9/19 15:00
 * @Version 1.0
 */
@Data
@TableName("sys_user")
public class SysUser {
    @TableId(type = IdType.AUTO)
    private Integer id;

    private String username;

    private String password;

    private String realName;
}
