package com.shiguiwu.admin.mapper;

import com.shiguiwu.admin.entity.SysRoleUser;
import org.apache.ibatis.annotations.Param;

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
public interface SysRoleUserMapper {
    int deleteByPrimaryKey(@Param("userid") Integer userid, @Param("roleid") Integer roleid);

    int insert(SysRoleUser record);

    int insertSelective(SysRoleUser record);
}