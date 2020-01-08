package com.shiguiwu.admin.service.impl;

import com.shiguiwu.admin.dto.RoleDto;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.shiguiwu.admin.entity.SysRole;
import com.shiguiwu.admin.mapper.SysRoleMapper;
import com.shiguiwu.admin.service.SysRoleService;

import java.util.List;

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
public class SysRoleServiceImpl implements SysRoleService{

    @Resource
    private SysRoleMapper sysRoleMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return sysRoleMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(SysRole record) {
        return sysRoleMapper.insert(record);
    }

    @Override
    public int insertSelective(SysRole record) {
        return sysRoleMapper.insertSelective(record);
    }

    @Override
    public SysRole selectByPrimaryKey(Integer id) {
        return sysRoleMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(SysRole record) {
        return sysRoleMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(SysRole record) {
        return sysRoleMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<SysRole> getAllRole() {
        return sysRoleMapper.queryAllRole();
    }

    @Override
    public List<SysRole> findAll(RoleDto roleDto) {
        return sysRoleMapper.findAll(roleDto);
    }

}
