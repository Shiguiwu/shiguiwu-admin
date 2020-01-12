package com.shiguiwu.admin.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.github.pagehelper.PageInfo;
import com.shiguiwu.admin.entity.SysRolePermission;
import com.shiguiwu.admin.mapper.SysRolePermissionMapper;
import com.shiguiwu.admin.util.TreeUtils;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.shiguiwu.admin.entity.SysPermission;
import com.shiguiwu.admin.mapper.SysPermissionMapper;
import com.shiguiwu.admin.service.SysPermissionService;
import org.springframework.transaction.annotation.Transactional;

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
public class SysPermissionServiceImpl implements SysPermissionService{

    @Resource
    private SysPermissionMapper sysPermissionMapper;

    @Resource
    private SysRolePermissionMapper sysRolePermissionMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return sysPermissionMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(SysPermission record) {
        return sysPermissionMapper.insert(record);
    }

    @Override
    public int insertSelective(SysPermission record) {
        return sysPermissionMapper.insertSelective(record);
    }

    @Override
    public SysPermission selectByPrimaryKey(Integer id) {
        return sysPermissionMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(SysPermission record) {
        return sysPermissionMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(SysPermission record) {
        return sysPermissionMapper.updateByPrimaryKey(record);
    }

    @Override
    public JSONArray queryPermissTree() {
        List<SysPermission> all = sysPermissionMapper.findAll();
        JSONArray array = new JSONArray();
        TreeUtils.permissionsTree(0, all, array);
        return array;
    }

    @Override
    public List<SysPermission> findAll() {
        return sysPermissionMapper.findAll();
    }

    @Override
    public int addAOrEditPermission(SysPermission sysPermission) {
        int result;
        if (null == sysPermission.getId()) {
            result = sysPermissionMapper.insertSelective(sysPermission);
        }
        else {
            result = sysPermissionMapper.updateByPrimaryKeySelective(sysPermission);
        }
        return result;
    }

    @Override
    @Transactional
    public int delete(Integer id) {
        int result;
        //下级权限有的话，不允许删除的
        Integer integer = sysPermissionMapper.queryByParentId(id);
        if (integer.intValue() != 0) {
            result = 0;
            return result;
        }
        sysRolePermissionMapper.deleteByPermissionId(id);
        result = sysPermissionMapper.deleteByPrimaryKey(id);
        return result;
    }

    @Override
    public JSONArray getMuenByUserId(Long userid) {
        JSONArray array = new JSONArray();
        List<SysPermission> list = sysPermissionMapper.queryPermissionByUserId(userid)
                .stream()
                .filter(p-> new Integer(1).equals(p.getType()))
                .collect(Collectors.toList());
        TreeUtils.permissionsTree(0, list, array);
        return array;
    }

}
