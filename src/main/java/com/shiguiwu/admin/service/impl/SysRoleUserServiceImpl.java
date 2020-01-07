package com.shiguiwu.admin.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.shiguiwu.admin.entity.SysRoleUser;
import com.shiguiwu.admin.mapper.SysRoleUserMapper;
import com.shiguiwu.admin.service.SysRoleUserService;
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
public class SysRoleUserServiceImpl implements SysRoleUserService{

    @Resource
    private SysRoleUserMapper sysRoleUserMapper;

    @Override
    public int deleteByPrimaryKey(Integer userid,Integer roleid) {
        return sysRoleUserMapper.deleteByPrimaryKey(userid,roleid);
    }

    @Override
    public int insert(SysRoleUser record) {
        return sysRoleUserMapper.insert(record);
    }

    @Override
    public int insertSelective(SysRoleUser record) {
        return sysRoleUserMapper.insertSelective(record);
    }

}
