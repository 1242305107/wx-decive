package com.tckj.wx.application.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tckj.wx.application.entity.User;

import java.util.List;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author WCH
 * @since 2020-06-22
 */
public interface IUserService extends IService<User> {

    List<User> findList();

}
