package com.tckj.wx.application.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tckj.wx.application.common.util.ComUtil;
import com.tckj.wx.application.common.util.ResultHelper;
import com.tckj.wx.application.entity.Organization;
import com.tckj.wx.application.service.IOrganizationService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;

import java.util.List;

/**
 * <p>
 * 机构表 前端控制器
 * </p>
 *
 * @author WCH
 * @since 2020-06-24
 */
@Api(tags = "机构模块")
@RestController
@RequestMapping("/organization")
public class OrganizationController {

    @Autowired
    private IOrganizationService organizationService;

    @ApiOperation(value = "添加组织机构")
    @PostMapping("saveOrUpdate")
    public ResultHelper saveOrUpdate(@RequestBody Organization organization){
        organization.setCreateTime(null);
        organization.setUpdateTime(null);
        boolean b = organizationService.saveOrUpdate(organization);
        return ResultHelper.succeed(organization);
    }


    @ApiOperation(value = "查询所有机构")
    @GetMapping("findList")
    public ResultHelper findList(){
        List<Organization> list = organizationService.list();
        return ResultHelper.succeed(list);
    }

    @ApiOperation(value = "删除机构")
    @ApiImplicitParam(name = "id",value = "机构id",required = false,dataType = "int",paramType = "query")
    @GetMapping("deleteOrganizationById")
    public ResultHelper deleteOrganizationById(@RequestParam Integer id){
        boolean b = organizationService.removeById(id);
        if (!b){
            return ResultHelper.failed2Msg("删除失败");
        }
        return ResultHelper.succeed("删除成功");
    }



    @ApiOperation(value = "机构分页查询")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "current",value = "当前页数",required = false,dataType = "int",paramType = "query",defaultValue = "1"),
            @ApiImplicitParam(name = "size",value = "每页显示数量",required = false,dataType = "int",paramType = "query",defaultValue = "10")
    })
    @GetMapping("findPage")
    public ResultHelper findPage(@RequestParam(required = false,defaultValue = "1") Integer current,
                                 @RequestParam(required = false,defaultValue = "10") Integer size){
        IPage<Organization> page = organizationService.page(new Page<>(current, size));
        return ResultHelper.succeed(page);
    }


    @ApiOperation(value = "根据机构名称模糊查询")
    @ApiImplicitParam(name = "organizationName",value = "机构名称",required = false,dataType = "string",paramType = "query")
    @GetMapping("findByOrganization")
    public ResultHelper findByOrganization(@RequestParam(required = false) String organizationName){
        QueryWrapper<Organization> wrapper = new QueryWrapper<>();
        if (!ComUtil.isEmpty(organizationName)){
            wrapper.like("organization_name", organizationName);
        }

        List<Organization> list = organizationService.list(wrapper);
        return ResultHelper.succeed(list);
    }


}
