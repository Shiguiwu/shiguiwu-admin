package com.shiguiwu.admin.service;

import com.shiguiwu.admin.entity.SysRoleUser;
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
public interface SysRoleUserService{


    int deleteByPrimaryKey(Integer userid,Integer roleid);

    int insert(SysRoleUser record);

    int insertSelective(SysRoleUser record);

}
