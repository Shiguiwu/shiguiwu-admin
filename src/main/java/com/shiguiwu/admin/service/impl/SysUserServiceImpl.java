package com.shiguiwu.admin.service.impl;

import com.shiguiwu.admin.dto.UserDto;
import com.shiguiwu.admin.entity.SysRoleUser;
import com.shiguiwu.admin.mapper.SysRoleUserMapper;
import com.shiguiwu.admin.util.BeanUtil;
import com.shiguiwu.admin.util.DateUtils;
import org.apache.ibatis.javassist.runtime.DotClass;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.shiguiwu.admin.entity.SysUser;
import com.shiguiwu.admin.mapper.SysUserMapper;
import com.shiguiwu.admin.service.SysUserService;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.thymeleaf.expression.Ids;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

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
    public int deleteByPrimaryKey(Long id) {
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
    public SysUser selectByPrimaryKey(Long id) {
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
        sysUser.setStatus((byte) 1);

        int result = sysUserMapper.insert(sysUser);
        SysRoleUser roleUser = new SysRoleUser();
        roleUser.setRoleid(Integer.parseInt(dto.getRoleId()));
        roleUser.setUserid(sysUser.getId());
        sysRoleUserMapper.insert(roleUser);
        return result;
    }

    @Override
    public UserDto queryDto(Long id) {
        return sysUserMapper.queryDto(id);
    }

    @Override
    @Transactional
    public int updateUserInfo(UserDto dto) {

        SysUser sysUser = new SysUser();
        BeanUtil.copyPropertiesIgnoreNull(dto, sysUser);
        sysUser.setUpdateTime(new Date());
        sysUser.setId(dto.getId());
        //删除原有的角色
        sysRoleUserMapper.deleteByUserId(dto.getId());

        //重新插入角色
        SysRoleUser roleUser = new SysRoleUser();
        roleUser.setRoleid(Integer.parseInt(dto.getRoleId()));
        roleUser.setUserid(sysUser.getId());
        sysRoleUserMapper.insert(roleUser);
        return sysUserMapper.updateByPrimaryKeySelective(sysUser);
    }

    @Override
    public int deleteUser(Long id) {

        //删除中间表
        sysRoleUserMapper.deleteByUserId(id);

        //删除用户
        int result = sysUserMapper.deleteByPrimaryKey(id);

        return result;
    }

    @Override
    public int batDeleteUser(String ids) {
        List<Long> userids = Arrays.asList(ids.split(","))
                .parallelStream().map(Long::parseLong)
                .collect(Collectors.toList());
        sysRoleUserMapper.batDeleteUserRoleByUserid(userids);
        return sysUserMapper.batDeleteUserByUserid(userids);
    }

}
