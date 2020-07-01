package com.tckj.wx.application.service.impl;


import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tckj.wx.application.common.util.ComUtil;
import com.tckj.wx.application.dao.MenuMapper;
import com.tckj.wx.application.dao.RoleMapper;
import com.tckj.wx.application.dao.UserMapper;
import com.tckj.wx.application.dao.UserRoleMapper;
import com.tckj.wx.application.entity.*;
import com.tckj.wx.application.service.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author WCH
 * @since 2020-06-22
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService , UserDetailsService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserRoleMapper userRoleMapper;
    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private MenuMapper menuMapper;

    @Override
    public List<User> findList() {
        return userMapper.selectList(null);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        LoginUser loginUser = null;
        try {
            loginUser = this.findByUsername(username);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (loginUser == null) {
            throw new AuthenticationCredentialsNotFoundException("用户不存在");
        }
        return loginUser;
    }


    public LoginUser findByUsername(String username) throws Exception {
        User user = this.getOne(new QueryWrapper<User>().eq("username",username));
        return setUserRoles(user);
    }


    public LoginUser setUserRoles (User user) throws Exception {
        if (ComUtil.isEmpty(user)) {
            return null;
        }
        LoginUser loginAppUser = new LoginUser();
        BeanUtils.copyProperties(user, loginAppUser);

        List<UserRole> list = userRoleMapper.selectList(new QueryWrapper<UserRole>().eq("user_id", loginAppUser.getId()));
        Set<String> set = list.parallelStream().map(UserRole::getRoleId).collect(Collectors.toSet());

        if (CollectionUtils.isEmpty(set)){
            return loginAppUser;
        }

        List<Role> roles = roleMapper.selectBatchIds(set);
        loginAppUser.setRoles(roles);// 设置角色

        if (!CollectionUtils.isEmpty(roles)) {
            Set<String> roleIds = roles.parallelStream().map(Role::getId).collect(Collectors.toSet());
            //查询大屏按钮
           /* List<Menu> buttonList= menuService.findByRoleIds(roleIds,2,2);
            if (!CollectionUtils.isEmpty(buttonList)){
                List<String> buttons= buttonList.parallelStream().map(Menu::getCode).collect(Collectors.toList());
                loginAppUser.setButtonList(buttons);
                for (String button : buttons) {
                    if ("button-config".equals(button)){
                        List<Menu> configMenuList= menuService.findByRoleIds(roleIds,1,1);
                        if (!CollectionUtils.isEmpty(configMenuList)){
                            List<Menu> menus = menuService.treeMenuList(0 + "", configMenuList);
                            loginAppUser.setConfigMenuList(menus);
                        }
                    }else if ("button-business".equals(button)){
                        List<Menu> businessMenuList= menuService.findByRoleIds(roleIds,1,0);
                        if (!CollectionUtils.isEmpty(businessMenuList)){
                            List<Menu> menus = menuService.treeMenuList(0 + "", businessMenuList);
                            loginAppUser.setBusinessMenuList(menus);
                        }
                    }
                }
            }*/

           //查询所有接口权限
            Set<Menu> sysPermissions = menuMapper.selecApiMenuList(roleIds);
            if (!CollectionUtils.isEmpty(sysPermissions)) {
                Set<String> permissions = sysPermissions.parallelStream().map(Menu::getCode)
                        .collect(Collectors.toSet());
                loginAppUser.setPermissions(permissions);// 设置权限集合
            }
        }
        return loginAppUser;
    }
}
