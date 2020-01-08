package com.shiguiwu.admin.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shiguiwu.admin.dto.UserDto;
import com.shiguiwu.admin.entity.SysUser;
import com.shiguiwu.admin.service.SysUserService;
import com.shiguiwu.admin.util.Results;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
    public Results<List<SysUser>> list(UserDto userDto) {


        PageHelper.startPage(userDto.getPageNum(), userDto.getPageSize());

        PageInfo<SysUser> pageInfo = new PageInfo<>(sysUserService.findAll(userDto));

        return Results.success((int) pageInfo.getTotal(),pageInfo.getList());
    }

    @PutMapping("/update")
    @ResponseBody
    public Results<String> update(@RequestBody SysUser sysUser) {
        int result = sysUserService.updateByPrimaryKeySelective(sysUser);
        if (result > 0) {
            return Results.success("修改成功");
        }
        return Results.failure(-1,"修改失败");
    }

    @PostMapping("/add")
    @ResponseBody
    public Results<String> add(@RequestBody UserDto user) {
        int result = sysUserService.addUser(user);
        if (result > 0) {
            return Results.success("添加成功");
        }
        return Results.success("添加失败");
    }

    @GetMapping("/add")
    public String addForm(Model model) {
        model.addAttribute("sysUser",new SysUser());
        return "/user/user-add";
    }
}
