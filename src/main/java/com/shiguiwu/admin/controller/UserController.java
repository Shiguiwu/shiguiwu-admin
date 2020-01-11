package com.shiguiwu.admin.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shiguiwu.admin.dto.UserDto;
import com.shiguiwu.admin.entity.SysUser;
import com.shiguiwu.admin.service.SysUserService;
import com.shiguiwu.admin.util.Results;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;

import java.text.SimpleDateFormat;
import java.util.Date;
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


    String pattern = "yyyy-MM-dd";

    @Autowired
    private SysUserService sysUserService;


    @RequestMapping("/list")
    @ResponseBody
    public Results<List<SysUser>> list(UserDto userDto) {


        PageHelper.startPage(userDto.getPageNum(), userDto.getPageSize());

        PageInfo<SysUser> pageInfo = new PageInfo<>(sysUserService.findAll(userDto));

        return Results.success((int) pageInfo.getTotal(),pageInfo.getList());
    }

    @PutMapping("/edit")
    @ResponseBody
    public Results<String> update(@RequestBody UserDto dto) {
        int result = sysUserService.updateUserInfo(dto);
        if (result > 0) {
            return Results.success("修改成功");
        }
        return Results.failure(500,"修改失败");
    }

    @GetMapping("/edit")
    public String edit(@RequestParam Long id,Model model) {
        UserDto sysUser = sysUserService.queryDto(id);
        model.addAttribute("sysUser",sysUser);

        return "/user/user-edit";
    }

    @PostMapping("/add")
    @ResponseBody
    public Results<String> add(@RequestBody UserDto user) {
        int result = sysUserService.addUser(user);
        if (result > 0) {
            return Results.success("添加成功");
        }
        return Results.failure(500,"添加失败");
    }

    @GetMapping("/add")
    public String addForm(Model model) {
        model.addAttribute("sysUser",new SysUser());
        return "/user/user-add";
    }

    //只需要加上下面这段即可，注意不能忘记注解
    @InitBinder
    public void initBinder(WebDataBinder binder, WebRequest request) {
        binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat(pattern), true));// CustomDateEditor为自定义日期编辑器
    }


    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public Results<String> deleteUser(@PathVariable Long id) {
        int result = sysUserService.deleteUser(id);
        if (result > 0) {
            return Results.success("删除成功！");
        }
        return Results.failure(500, "删除失败！");
    }

    @DeleteMapping("/batDelete")
    @ResponseBody
    public Results<String> batDeleteUser(@RequestParam String ids) {
        if (StringUtils.isBlank(ids)) {
            return Results.failure(500, "传值失败！");
        }
        int result = sysUserService.batDeleteUser(ids);
        if (result > 0) {
            return Results.success("批量删除成功！");
        }
        return Results.failure(500, "批量删除失败！");
    }
}
