package com.shiguiwu.admin.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shiguiwu.admin.dto.RoleDto;
import com.shiguiwu.admin.entity.SysRole;
import com.shiguiwu.admin.service.SysRoleService;
import com.shiguiwu.admin.util.Results;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @description: 角色控制器
 * @author: stone
 * @date: Created by 2020/1/8 10:37
 * @version: 1.0.0
 * @pakeage: com.shiguiwu.admin.controller
 */
@Slf4j
@RequestMapping("/role")
@Controller

public class RoleController {

    @Autowired
    private SysRoleService sysRoleService;


    @GetMapping("/getAllRole")
    @ResponseBody
    public Results<List<SysRole>> getAllRole() {

        return Results.success(sysRoleService.getAllRole());
    }

    @GetMapping("/list")
    @ResponseBody
    public Results<List<SysRole>> list(RoleDto roleDto) {

        PageHelper.startPage(roleDto.getPageNum(), roleDto.getPageSize());

        PageInfo<SysRole> pageInfo = new PageInfo<>(sysRoleService.findAll(roleDto));

        return Results.success((int) pageInfo.getTotal(),pageInfo.getList());
    }
}
