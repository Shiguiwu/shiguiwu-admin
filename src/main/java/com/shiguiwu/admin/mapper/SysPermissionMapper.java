package com.shiguiwu.admin.mapper;

import com.shiguiwu.admin.entity.SysPermission;
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
public interface SysPermissionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SysPermission record);

    int insertSelective(SysPermission record);

    SysPermission selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysPermission record);

    int updateByPrimaryKey(SysPermission record);

    List<SysPermission> findAll();

    Integer queryByParentId(@Param("id") Integer id);

    List<SysPermission> queryPermissionByUserId(@Param("userId") Long id);
}