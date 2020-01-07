package com.shiguiwu.admin.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shiguiwu.admin.entity.SysUser;
import com.shiguiwu.admin.service.SysUserService;
import com.shiguiwu.admin.util.DateUtils;
import com.shiguiwu.admin.util.JSONUtil;
import com.shiguiwu.admin.util.JsonResult;
import com.shiguiwu.admin.util.Results;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @description: 用户控制器类
 * @author: stone
 * @date: Created by 2020/1/6 22:45
 * @version: 1.0.0
 * @pakeage: com.shiguiwu.admin.controller
 */
@Controller
@RequestMapping("/user")
@Slf4j
public class UserController {


    @Autowired
    private SysUserService sysUserService;


    @RequestMapping("/list")
    @ResponseBody
    public Results<List<SysUser>> list() {

        Integer page = 1;
        Integer size = 10;

        PageHelper.startPage(page, size);


        List<SysUser> sysUsers = sysUserService.queryByPage(null);

        PageInfo<SysUser> pageInfo = new PageInfo<>(sysUsers);
        return Results.success((int) pageInfo.getTotal(),pageInfo.getList());
    }
}
