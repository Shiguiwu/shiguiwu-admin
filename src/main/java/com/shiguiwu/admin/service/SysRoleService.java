package com.shiguiwu.admin.service;

import com.shiguiwu.admin.dto.RoleDto;
import com.shiguiwu.admin.entity.SysRole;

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
 * @pakeage: com.shiguiwu.admin.service
 *
 *
 */
public interface SysRoleService {


    int deleteByPrimaryKey(Integer id);

    int insert(SysRole record);

    int insertSelective(SysRole record);

    SysRole selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysRole record);

    int updateByPrimaryKey(SysRole record);

    List<SysRole> getAllRole();

    List<SysRole> findAll(RoleDto roleDto);
}