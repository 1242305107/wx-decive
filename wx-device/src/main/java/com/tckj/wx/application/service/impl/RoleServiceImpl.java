package com.tckj.wx.application.service.impl;

import com.tckj.wx.application.entity.Role;
import com.tckj.wx.application.dao.RoleMapper;
import com.tckj.wx.application.service.IRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 角色表 服务实现类
 * </p>
 *
 * @author WCH
 * @since 2020-06-28
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements IRoleService {

}
