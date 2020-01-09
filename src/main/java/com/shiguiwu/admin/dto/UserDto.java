package com.shiguiwu.admin.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.Email;
import java.util.Date;

/**
 * @description: 用户传输类
 * @author: stone
 * @date: Created by 2020/1/7 19:45
 * @version: 1.0.0
 * @pakeage: com.shiguiwu.admin.dto
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class UserDto extends BaseDto<Long> {


    private static final long serialVersionUID = 4601586659413084973L;

    private String username;

    private String password;

    private String repass;

    private String nickname;

    private String headimgurl;

    private String phone;

    private String telephone;

    @Email
    private String email;

    private Date birthday;

    private Byte sex;

    private String roleId;



}
