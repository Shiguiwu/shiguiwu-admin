package com.shiguiwu.admin.controller;

import com.alibaba.fastjson.JSONArray;
import com.shiguiwu.admin.entity.SysPermission;
import com.shiguiwu.admin.service.SysPermissionService;
import com.shiguiwu.admin.util.Results;
import lombok.extern.slf4j.Slf4j;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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


    @GetMapping("/all")
    @ResponseBody
    public Results<List<SysPermission>> all() {
        List<SysPermission> list = sysPermissionService.findAll();
        return Results.success(0,list);
    }

    @GetMapping("/operate")
    public String addAOrEdit(Model model, @RequestParam(value = "id", required = false) Integer id) {
        SysPermission sysPermission = id == null ? new SysPermission() : sysPermissionService.selectByPrimaryKey(id);
        model.addAttribute("sysPermission", sysPermission);
        return "/permission/operate";
    }


    @PostMapping("/operate")
    @ResponseBody
    public Results<String> addAOrEdit(@RequestBody SysPermission sysPermission) {
        return sysPermissionService.addAOrEditPermission(sysPermission) > 0
                ? Results.success("操作成功！")
                : Results.failure(500, "操作失败！");
    }


    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public Results<String> delete(@PathVariable Integer id) {
        if (null == id) {
            return Results.failure(500, "id不能为空！");
        }
        return sysPermissionService.delete(id) > 0 ?Results.success("删除成功！"):Results.failure(500,"删除失败");
    }

    @GetMapping("/menu")
    @ResponseBody
    public Results<JSONArray> menu(@RequestParam Long userId) {
        JSONArray array = sysPermissionService.getMuenByUserId(userId);
        return Results.success(array);
    }


}
