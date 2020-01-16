package com.shiguiwu.admin;

import java.awt.*;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.alibaba.fastjson.JSONArray;
import com.google.common.collect.Lists;
import com.shiguiwu.admin.entity.SysPermission;
import com.shiguiwu.admin.entity.SysUser;
import com.shiguiwu.admin.mapper.SysUserMapper;
import com.shiguiwu.admin.util.FileUtil;
import com.shiguiwu.admin.util.JSONUtil;
import com.shiguiwu.admin.util.TreeUtils;
import com.spire.pdf.PdfDocument;
import com.spire.pdf.PdfPageBase;
import com.spire.pdf.general.find.PdfTextFind;
import com.spire.pdf.widget.PdfPageCollection;
import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
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


    @Test
    public  void test1() throws Exception {

        //加载PDF文档
        PdfDocument pdf = new PdfDocument();
        pdf.loadFromFile("C:\\Users\\shiguiwu\\Desktop\\XJLtest002行政村自行车产品发行.pdf");
        PdfTextFind[] result = null;

        PdfPageCollection pdfPageCollection =  pdf.getPages();

        long startTime = System.nanoTime();

        System.out.println("开始时间:"+startTime);
        //遍历文档页面
        for (int i =0; i<pdf.getPages().getCount();i++) {

            PdfPageBase page = pdfPageCollection.get(i);
            //查找文档中所有的"乡愁"字符串
            result = page.findText("投资者",false,true).getFinds();

            for (PdfTextFind find : result) {
                //高亮显示查找结果
                find.applyHighLight(Color.yellow);
            }
        }
        //保存文档

        PdfPageBase add = pdf.getPages().add();
        pdf.getPages().remove(add);
        pdf.saveToFile("C:\\Users\\shiguiwu\\Desktop\\XJLtest002行政村自行车产品发行1.pdf");

        String base = FileUtil.encodeBase64File("C:\\Users\\shiguiwu\\Desktop\\XJLtest002行政村自行车产品发行1.pdf");//转base64需要

        System.out.println("用使用时间:"+(System.nanoTime()  - startTime)/ 1_000_000);
        pdf.close();

//        SysUser sysUser = sysUserMapper.selectByPrimaryKey(45L);
//
//        System.out.println(sysUser.getId());
    }



    @Test
    public  void test2() throws Exception {


        //加载PDF文档
        PdfDocument pdf = new PdfDocument();
        pdf.loadFromFile("C:\\Users\\shiguiwu\\Desktop\\XJLtest002行政村自行车产品发行.pdf");

        long startTime = System.nanoTime();
        ExecutorService service = Executors.newCachedThreadPool();
        PdfPageCollection pdfPageCollection =  pdf.getPages();

        System.out.println("开始时间:"+startTime);
        //遍历文档页面
        for (int i =0; i<pdf.getPages().getCount();i++) {



                PdfPageBase page = pdfPageCollection.get(i);
                //查找文档中所有的"乡愁"字符串
                PdfTextFind[] result = page.findText("投资者",false,true).getFinds();

                for (PdfTextFind find : result) {
                    //高亮显示查找结果
                    try {
                        find.applyHighLight(Color.yellow);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }




        }
        //保存文档

        PdfPageBase add = pdf.getPages().add();
        pdf.getPages().remove(add);
        pdf.saveToFile("C:\\Users\\shiguiwu\\Desktop\\XJLtest002行政村自行车产品发行1.pdf");

        String base = FileUtil.encodeBase64File("C:\\Users\\shiguiwu\\Desktop\\XJLtest002行政村自行车产品发行1.pdf");//转base64需要

        pdf(base);
        System.out.println("用使用时间:"+(System.nanoTime()  - startTime)/ 1_000_000);
        pdf.close();

    }
    public void pdf(String string) {
        BufferedInputStream bis = null;
        FileOutputStream fos = null;
        BufferedOutputStream bos = null;
        try{
            byte[] bytes= Base64.decode(string);
            ByteArrayInputStream byteArrayInputStream=new ByteArrayInputStream(bytes);
            bis=new BufferedInputStream(byteArrayInputStream);
            File file=new File("C:\\Users\\shiguiwu\\Desktop\\XJLtest002行政村自行车产品发行5.pdf");
            File path=file.getParentFile();
            if(!path.exists()){
                path.mkdirs();
            }
            fos=new FileOutputStream(file);
            bos=new BufferedOutputStream(fos);

            byte[] buffer=new byte[1024];
            int length=bis.read(buffer);
            while(length!=-1){
                bos.write(buffer,0,length);
                length=bis.read(buffer);
            }
            bos.flush();
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            try{
                bis.close();
                bos.close();
                fos.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }

    }

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Test
    public void testBatchUpdate() {
        CompletableFuture<List<SysUser>> future = new CompletableFuture<>();
        sysUserMapper.findAll(null).parallelStream().forEach(e -> {
            e.setPassword(passwordEncoder.encode("123456"));
            sysUserMapper.updateByPrimaryKeySelective(e);

        });



    }

}
