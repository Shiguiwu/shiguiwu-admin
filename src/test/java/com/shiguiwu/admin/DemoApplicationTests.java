package com.shiguiwu.admin;

import java.awt.*;
import java.security.Permission;
import java.util.Date;
import java.util.List;

import com.alibaba.fastjson.JSONArray;
import com.google.common.collect.Lists;
import com.shiguiwu.admin.entity.SysPermission;
import com.shiguiwu.admin.entity.SysUser;
import com.shiguiwu.admin.mapper.SysUserMapper;
import com.shiguiwu.admin.util.JSONUtil;
import com.shiguiwu.admin.util.TreeUtils;
import com.spire.pdf.PdfDocument;
import com.spire.pdf.PdfPageBase;
import com.spire.pdf.general.find.PdfTextFind;
import com.spire.pdf.widget.PdfPageCollection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    @Autowired
    private SysUserMapper sysUserMapper;
    @Test
    public void contextLoads() {

        SysUser sysUser = new SysUser();
        sysUser.setUsername("shigu1iw22u1");
        sysUser.setPassword("12322456");
        sysUser.setNickname("石小白2211");
        sysUser.setHeadimgurl("www.baidu.com");
        sysUser.setPhone("1867689410");
        sysUser.setTelephone("020-966996");
        sysUser.setEmail("2406749643@qq.com");
        sysUser.setBirthday(new Date());
        sysUser.setSex((byte) 1);
        sysUser.setStatus((byte)1);
        sysUserMapper.insert(sysUser);

        System.out.println(sysUser.getId());
    }

    @Test
    public void queryOne() throws Exception{

        //加载PDF文档
        PdfDocument pdf = new PdfDocument();
        pdf.loadFromFile("C:\\Users\\shiguiwu\\Desktop\\python-已转档.pdf");
        PdfTextFind[] result = null;

        PdfPageCollection pdfPageCollection =  pdf.getPages();

        //遍历文档页面
        for (int i =0; i<pdf.getPages().getCount();i++) {
            PdfPageBase page = pdfPageCollection.get(i);
            //查找文档中所有的"乡愁"字符串
            result = page.findText("python",false,true).getFinds();

            for (PdfTextFind find : result) {
                //高亮显示查找结果
                find.applyHighLight(Color.yellow);
            }
        }
        //保存文档

        PdfPageBase add = pdf.getPages().add();
        pdf.getPages().remove(add);
        pdf.saveToFile("C:\\Users\\shiguiwu\\Desktop\\python-已转档1.pdf");
        pdf.close();

//        SysUser sysUser = sysUserMapper.selectByPrimaryKey(45L);
//
//        System.out.println(sysUser.getId());
    }

    @Test
    public void tree() {

        List<SysPermission> list = Lists.newArrayList();
        for (int i = 1; i < 3; i++) {
            SysPermission permission = new SysPermission();
            permission.setParentid(0);
            permission.setId(i);
            permission.setCreateTime(new Date());
            permission.setUpdateTime(new Date());
            list.add(permission);
        }
        for (int i = 3; i <6; i++) {
            SysPermission permission = new SysPermission();
            permission.setParentid(i%2 == 1? 1:2);
            permission.setId(i);
            permission.setCreateTime(new Date());
            permission.setUpdateTime(new Date());
            list.add(permission);
        }

        JSONArray array = new JSONArray();
        TreeUtils.permissionsTree(0,list,array);
        System.out.println(JSONUtil.toJson(array));



    }

    @Test
    public void test0(){
        System.out.println(new Integer(0).equals(0));

    }

}
