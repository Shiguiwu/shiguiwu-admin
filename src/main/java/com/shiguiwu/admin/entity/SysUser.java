package com.shiguiwu.admin.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @description: ${DESC}
 * @author: stone
 * @date: Created by 2020/1/5 21:32
 * @version: 1.0.0
 * @pakeage: com.shiguiwu.admin.entity
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class SysUser extends BaseEntity<Long> {


    private static final long serialVersionUID = -7451319758246631000L;
    private String username;

    private String password;

    private String nickname;

    private String headimgurl;

    private String phone;

    private String telephone;

    private String email;

    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date birthday;

    private Byte sex;

    private Byte status;


}