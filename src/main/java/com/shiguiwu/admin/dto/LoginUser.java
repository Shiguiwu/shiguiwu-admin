package com.shiguiwu.admin.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.shiguiwu.admin.entity.SysPermission;
import com.shiguiwu.admin.entity.SysUser;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @description: 登录了
 * @author: stone
 * @date: Created by 2020/1/11 21:13
 * @version: 1.0.0
 * @pakeage: com.shiguiwu.admin.dto
 */
@Data
public class LoginUser extends SysUser implements UserDetails {

    private List<SysPermission> permissions;


    @Override
    @JsonIgnore
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return permissions
                .parallelStream()
                .filter(p -> StringUtils.isNotBlank(p.getPermission()))
                .map(g -> new SimpleGrantedAuthority(g.getPermission()))
                .collect(Collectors.toSet());
    }

    @Override
    @JsonIgnore
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    @JsonIgnore
    public boolean isAccountNonLocked() {
        return getStatus() != Status.LOCKED;
    }

    @Override
    @JsonIgnore
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
