package com.tckj.wx.application.entity;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.CollectionUtils;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author WCH
 * @date 2020/6/28 14:40
 */
@Data
public class LoginUser extends User implements UserDetails {


    //角色
    private List<Role> roles;
    //接口权限
    private Set<String> permissions;
    //按钮
    private List<String> buttonList;
    //配置系统菜单栏
    private List<Menu> configMenuList;
    //业务系统菜单栏
    private List<Menu> businessMenuList;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> collection = new HashSet<>();
        if (!CollectionUtils.isEmpty(roles)) {
            roles.forEach(role -> {
                if (role.getCode().startsWith("ROLE_")) {
                    collection.add(new SimpleGrantedAuthority(role.getCode()));
                } else {
                    collection.add(new SimpleGrantedAuthority("ROLE_" + role.getCode()));
                }
            });
        }
        if (!CollectionUtils.isEmpty(permissions)) {
            permissions.forEach(per -> {
                collection.add(new SimpleGrantedAuthority(per));
            });
        }
        return collection;
    }


    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
