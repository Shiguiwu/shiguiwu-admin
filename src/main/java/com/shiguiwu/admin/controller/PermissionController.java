package com.shiguiwu.admin.controller;

import com.alibaba.fastjson.JSONArray;
import com.shiguiwu.admin.entity.SysPermission;
import com.shiguiwu.admin.service.SysPermissionService;
import com.shiguiwu.admin.util.Results;
import lombok.extern.slf4j.Slf4j;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @description: 权限控制器
 * @author: stone
 * @date: Created by 2020/1/8 10:50
 * @version: 1.0.0
 * @pakeage: com.shiguiwu.admin.controller
 */
@RequestMapping("/permiss")
@Controller
@Slf4j
public class PermissionController {

    @Autowired
    private SysPermissionService sysPermissionService;

    @GetMapping("/list")
    @ResponseBody
    public Results<List<SysPermission>> list() {
        return null;
    }


    @GetMapping("/tree")
    @ResponseBody
    public Results<JSONArray> getPermissionTree() {
        JSONArray array = sysPermissionService.queryPermissTree();
        return Results.success(array);
    }


}
