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
    public void queryOne() {

        SysUser sysUser = sysUserMapper.selectByPrimaryKey(45);

        System.out.println(sysUser.getId());
    }

}
