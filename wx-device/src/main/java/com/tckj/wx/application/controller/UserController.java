package com.tckj.wx.application.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tckj.wx.application.common.util.ResultHelper;
import com.tckj.wx.application.dao.UserMapper;
import com.tckj.wx.application.entity.User;
import com.tckj.wx.application.service.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author wch123
 * @since 2020-06-22
 */
@Api(tags = "用户模块")
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;


    @ApiOperation("查询用户")
    @GetMapping("/getList")
    public ResultHelper getList() {
        List<User> list=userService.findList();
        return ResultHelper.succeed(list);
    }

    @ApiOperation("分页查询")
    @GetMapping("/getPage")
    public ResultHelper getPage() {

        IPage<User> page = userService.page(new Page<>(1, 10));


        return ResultHelper.succeed(page);
    }

}

