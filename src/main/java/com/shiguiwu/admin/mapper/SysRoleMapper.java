package com.shiguiwu.admin.mapper;

import com.shiguiwu.admin.dto.RoleDto;
import com.shiguiwu.admin.entity.SysRole;
import org.apache.ibatis.annotations.Param;

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
 * @pakeage: com.shiguiwu.admin.mapper
 *
 *
 */
public interface SysRoleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SysRole record);

    int insertSelective(SysRole record);

    SysRole selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysRole record);

    int updateByPrimaryKey(SysRole record);

    List<SysRole> queryAllRole();

    List<SysRole> findAll(RoleDto roleDto);

    RoleDto queryRoleAndPermissionIdsById(Integer id);

    int batDelete(@Param("list") List<Integer> integers);
}