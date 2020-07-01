package com.tckj.wx.application.service.impl;

import com.tckj.wx.application.entity.Menu;
import com.tckj.wx.application.dao.MenuMapper;
import com.tckj.wx.application.service.IMenuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 菜单表 服务实现类
 * </p>
 *
 * @author WCH
 * @since 2020-06-28
 */
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements IMenuService {

}
