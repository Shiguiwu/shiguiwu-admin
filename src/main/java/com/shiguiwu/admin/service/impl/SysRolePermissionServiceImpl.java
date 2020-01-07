package com.shiguiwu.admin.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.shiguiwu.admin.entity.SysRolePermission;
import com.shiguiwu.admin.mapper.SysRolePermissionMapper;
import com.shiguiwu.admin.service.SysRolePermissionService;
/**
 * 
 * @description: ${DESC}
 *
 * 
 * @author: stone
 *
 * @date: Created by 2020/1/5 21:32
 * @version: 1.0.0
 * 
 * @pakeage: com.shiguiwu.admin.service.impl
 *
 *
 */
@Service
public class SysRolePermissionServiceImpl implements SysRolePermissionService{

    @Resource
    private SysRolePermissionMapper sysRolePermissionMapper;

    @Override
    public int deleteByPrimaryKey(Integer roleid,Integer permissionid) {
        return sysRolePermissionMapper.deleteByPrimaryKey(roleid,permissionid);
    }

    @Override
    public int insert(SysRolePermission record) {
        return sysRolePermissionMapper.insert(record);
    }

    @Override
    public int insertSelective(SysRolePermission record) {
        return sysRolePermissionMapper.insertSelective(record);
    }

}
