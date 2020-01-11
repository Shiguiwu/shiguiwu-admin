package com.shiguiwu.admin.service.impl;

import com.shiguiwu.admin.dto.RoleDto;
import com.shiguiwu.admin.entity.SysRolePermission;
import com.shiguiwu.admin.mapper.SysRolePermissionMapper;
import com.shiguiwu.admin.util.BeanUtil;
import com.sun.org.apache.regexp.internal.RE;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.shiguiwu.admin.entity.SysRole;
import com.shiguiwu.admin.mapper.SysRoleMapper;
import com.shiguiwu.admin.service.SysRoleService;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
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
public class SysRoleServiceImpl implements SysRoleService{

    @Resource
    private SysRoleMapper sysRoleMapper;

    @Resource
    private SysRolePermissionMapper sysRolePermissionMapper;

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

    @Override
    @Transactional
    public int addRole(RoleDto dto) {
        SysRole sysRole = new SysRole();
        BeanUtil.copyPropertiesIgnoreNull(dto, sysRole);
        int result = sysRoleMapper.insert(sysRole);
        List<SysRolePermission> permissionIds = Arrays.asList(dto.getPermissionIds().split(","))
                .parallelStream()
                .filter(e-> !"0".equals(e))
                .map(e ->new SysRolePermission(sysRole.getId(), Integer.parseInt(e)))
                .collect(Collectors.toList());
        sysRolePermissionMapper.batchAdd(permissionIds);
        return result;
    }

    @Override
    @Transactional
    public int editRole(RoleDto dto) {
        SysRole sysRole = new SysRole();
        BeanUtil.copyPropertiesIgnoreNull(dto, sysRole);
        sysRole.setUpdateTime(new Date());
        sysRole.setId(dto.getId());
        //删除原来的权限
        sysRolePermissionMapper.deleteByRoleId(sysRole.getId());

        //重新添加原来的
        List<SysRolePermission> permissionIds = Arrays.asList(dto.getPermissionIds().split(","))
                .parallelStream()
                .filter(e-> !"0".equals(e))
                .map(e ->new SysRolePermission(sysRole.getId(), Integer.parseInt(e)))
                .collect(Collectors.toList());
        sysRolePermissionMapper.batchAdd(permissionIds);
        //更新主表
        return sysRoleMapper.updateByPrimaryKeySelective(sysRole);
    }

    @Override
    public RoleDto queryRoleAndPermissionIds(Integer id) {
        return sysRoleMapper.queryRoleAndPermissionIdsById(id);
    }

    @Override
    @Transactional
    public int delete(Integer id) {

        //删除中间表，角色权限表
        sysRolePermissionMapper.deleteByRoleId(id);

        //删除主表
        return sysRoleMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int batDelete(String ids) {
        List<Integer> integers = Arrays.asList(ids.split(","))
                .parallelStream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        sysRolePermissionMapper.batchDelete(integers);
        return sysRoleMapper.batDelete(integers);
    }

}
