package com.shiguiwu.admin.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shiguiwu.admin.dto.RoleDto;
import com.shiguiwu.admin.entity.SysRole;
import com.shiguiwu.admin.service.SysRoleService;
import com.shiguiwu.admin.util.Results;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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


    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("sysRole", new SysRole());
        return "/role/role-add";
    }


    @GetMapping("/edit")
    public String edit(Model model,@RequestParam Integer id) {
        model.addAttribute("sysRole", sysRoleService.queryRoleAndPermissionIds(id));
        return "/role/role-edit";
    }


    @PostMapping("/add")
    @ResponseBody
    public Results<String> add(@RequestBody RoleDto dto) {

        if (StringUtils.isBlank(dto.getPermissionIds())) {
            return Results.failure(500,"未添加权限！");
        }

        int result = sysRoleService.addRole(dto);

        if (result > 0) {
            return Results.success("添加角色成功！");
        }
        return Results.failure(500,"添加角色失败！");
    }


    @PutMapping("/edit")
    @ResponseBody
    public Results<String> edit(@RequestBody RoleDto dto) {

        if (StringUtils.isBlank(dto.getPermissionIds())) {
            return Results.failure(500,"未添加权限！");
        }

        int result = sysRoleService.editRole(dto);

        if (result > 0) {
            return Results.success("更新角色成功！");
        }
        return Results.failure(500,"更新角色失败！");
    }

    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public Results<String> delete(@PathVariable Integer id) {
        if (id == null) {
            return Results.failure(500, "id不能为空！");
        }
        int result = sysRoleService.delete(id);
        if (result > 0) {
            return Results.success("删除成功！");
        }

        return Results.failure(500, "删除失败！");
    }



    @DeleteMapping("/batDelete")
    @ResponseBody
    public Results<String> batDeleteUser(@RequestParam String ids) {
        if (StringUtils.isBlank(ids)) {
            return Results.failure(500, "至少选择一条记录！");
        }
        int result = sysRoleService.batDelete(ids);
        if (result > 0) {
            return Results.success("批量删除成功！");
        }
        return Results.failure(500, "批量删除失败！");
    }
}
