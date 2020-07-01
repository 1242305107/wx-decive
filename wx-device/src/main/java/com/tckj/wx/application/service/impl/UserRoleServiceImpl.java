package com.tckj.wx.application.service.impl;

import com.tckj.wx.application.entity.UserRole;
import com.tckj.wx.application.dao.UserRoleMapper;
import com.tckj.wx.application.service.IUserRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 角色用户关系表 服务实现类
 * </p>
 *
 * @author WCH
 * @since 2020-06-28
 */
@Service
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRole> implements IUserRoleService {

}
