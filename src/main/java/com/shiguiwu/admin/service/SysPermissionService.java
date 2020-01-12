package com.shiguiwu.admin.service;

import com.alibaba.fastjson.JSONArray;
import com.shiguiwu.admin.entity.SysPermission;
import com.shiguiwu.admin.util.Results;

import java.util.List;

/**
 * @description: ${DESC}
 * @author: stone
 * @date: Created by 2020/1/5 21:32
 * @version: 1.0.0
 * @pakeage: com.shiguiwu.admin.service
 */
public interface SysPermissionService {


    int deleteByPrimaryKey(Integer id);

    int insert(SysPermission record);

    int insertSelective(SysPermission record);

    SysPermission selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysPermission record);

    int updateByPrimaryKey(SysPermission record);

    JSONArray queryPermissTree();

    List<SysPermission> findAll();

    int addAOrEditPermission(SysPermission sysPermission);

    int delete(Integer id);

    JSONArray getMuenByUserId(Long userid);
}
