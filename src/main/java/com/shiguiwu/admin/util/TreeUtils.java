package com.shiguiwu.admin.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.shiguiwu.admin.entity.BaseEntity;
import com.shiguiwu.admin.entity.SysPermission;

import java.util.Comparator;
import java.util.List;


public class TreeUtils {

    /**
     * 菜单树
     *
     * @param parentId
     * @param permissionsAll
     * @param array
     */
    public static void setPermissionsTree(Integer parentId, List<SysPermission> permissionsAll, JSONArray array) {
        for (SysPermission per : permissionsAll) {
            if (per.getParentid().equals(parentId)) {
                String string = JSONObject.toJSONString(per);
                JSONObject parent = (JSONObject) JSONObject.parse(string);
                array.add(parent);
                if (permissionsAll.stream().filter(p -> p.getParentid().equals(per.getId())).findAny() != null) {
                    JSONArray child = new JSONArray();
                    parent.put("child", child);
                    setPermissionsTree(per.getId(), permissionsAll, child);
                }
            }
        }
    }


    /**
     * 菜单树 v2
     *
     * @param parentId
     * @param permissionsAll
     * @param array
     */
    public static void permissionsTree(Integer parentId, List<SysPermission> permissionsAll, JSONArray array) {
        permissionsAll.stream().filter(per -> parentId.equals(per.getParentid())).forEach(per1 -> {
            JSONObject parent = (JSONObject) JSON.toJSON(per1);
            array.add(parent);
            if (permissionsAll.stream().filter(p -> p.getParentid().equals(per1.getId())).findAny() != null) {
                JSONArray child = new JSONArray();
                parent.put("child", child);
                permissionsTree(per1.getId(), permissionsAll, child);
            }
        });
    }
}
