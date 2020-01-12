package com.shiguiwu.admin.config;

import com.shiguiwu.admin.dto.LoginUser;
import com.shiguiwu.admin.entity.SysPermission;
import com.shiguiwu.admin.entity.SysUser;
import com.shiguiwu.admin.mapper.SysPermissionMapper;
import com.shiguiwu.admin.mapper.SysRolePermissionMapper;
import com.shiguiwu.admin.service.SysPermissionService;
import com.shiguiwu.admin.service.SysUserService;
import com.shiguiwu.admin.util.BeanUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description: 用户
 * @author: stone
 * @date: Created by 2020/1/11 21:21
 * @version: 1.0.0
 * @pakeage: com.shiguiwu.admin.config
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private SysUserService userService;

    @Autowired
    private SysPermissionMapper permissionMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        SysUser sysUser = userService.getByUsername(username);

        if (null == sysUser) {
            throw new UsernameNotFoundException("用户名不存在");
        }
        List<SysPermission> list = permissionMapper.queryPermissionByUserId(sysUser.getId());

        LoginUser loginUser = new LoginUser();

        BeanUtil.copyPropertiesIgnoreNull(sysUser, loginUser);

        loginUser.setPermissions(list);

        return loginUser;
    }
}
