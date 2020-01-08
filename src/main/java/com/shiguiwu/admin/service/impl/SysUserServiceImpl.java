package com.shiguiwu.admin.service.impl;

import com.shiguiwu.admin.dto.UserDto;
import com.shiguiwu.admin.entity.SysRoleUser;
import com.shiguiwu.admin.mapper.SysRoleUserMapper;
import com.shiguiwu.admin.util.BeanUtil;
import com.shiguiwu.admin.util.DateUtils;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.shiguiwu.admin.entity.SysUser;
import com.shiguiwu.admin.mapper.SysUserMapper;
import com.shiguiwu.admin.service.SysUserService;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDate;
import java.util.Date;
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
public class SysUserServiceImpl implements SysUserService{

    @Resource
    private SysUserMapper sysUserMapper;

    @Resource
    private SysRoleUserMapper sysRoleUserMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return sysUserMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(SysUser record) {
        return sysUserMapper.insert(record);
    }

    @Override
    public int insertSelective(SysUser record) {

        return sysUserMapper.insertSelective(record);
    }

    @Override
    public SysUser selectByPrimaryKey(Integer id) {
        return sysUserMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(SysUser record) {
        record.setUpdateTime(new Date());
        return sysUserMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(SysUser record) {
        return sysUserMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<SysUser> queryByPage(UserDto record) {
        return sysUserMapper.queryByPage(record);
    }

    @Override
    public List<SysUser> findAll(UserDto record) {
        return sysUserMapper.findAll(record);
    }

    @Override
    @Transactional
    public int addUser(UserDto dto) {
        SysUser sysUser = new SysUser();
        BeanUtil.copyPropertiesIgnoreNull(dto, sysUser);
        sysUser.setBirthday(DateUtils.parseStrToDate(dto.getBirthday(), "yyyy-MM-dd"));
        sysUser.setStatus((byte) 1);

        int result = sysUserMapper.insert(sysUser);
        SysRoleUser roleUser = new SysRoleUser();
        roleUser.setRoleid(Integer.parseInt(dto.getRoleId()));
        roleUser.setUserid(sysUser.getId());
        sysRoleUserMapper.insert(roleUser);
        return result;
    }

}
