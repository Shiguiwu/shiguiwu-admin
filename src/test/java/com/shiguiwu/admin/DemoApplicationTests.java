package com.shiguiwu.admin;
import java.util.Date;

import com.shiguiwu.admin.entity.SysUser;
import com.shiguiwu.admin.mapper.SysUserMapper;
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
        sysUser.setUsername("shiguiwu");
        sysUser.setPassword("123456");
        sysUser.setNickname("石小白");
        sysUser.setHeadimgurl("www.baidu.com");
        sysUser.setPhone("18676894410");
        sysUser.setTelephone("020-9966996");
        sysUser.setEmail("2406749643@qq.com");
        sysUser.setBirthday(new Date());
        sysUser.setSex(false);
        sysUser.setStatus(false);
        sysUserMapper.insert(sysUser);
    }

    @Test
    public void queryOne() {

        SysUser sysUser = sysUserMapper.selectByPrimaryKey(45);

        System.out.println(sysUser);
    }

}
