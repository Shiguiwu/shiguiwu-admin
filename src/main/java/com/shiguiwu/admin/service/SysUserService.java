package com.shiguiwu.admin.service;

import com.shiguiwu.admin.dto.UserDto;
import com.shiguiwu.admin.entity.SysUser;

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
public interface SysUserService{


    int deleteByPrimaryKey(Integer id);

    int insert(SysUser record);

    int insertSelective(SysUser record);

    SysUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysUser record);

    int updateByPrimaryKey(SysUser record);

    List<SysUser> queryByPage(UserDto record);

    List<SysUser> findAll(UserDto record);

    int addUser(UserDto dto);

}
