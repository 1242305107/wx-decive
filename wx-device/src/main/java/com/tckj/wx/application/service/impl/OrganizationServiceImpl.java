package com.tckj.wx.application.service.impl;

import com.tckj.wx.application.entity.Organization;
import com.tckj.wx.application.dao.OrganizationMapper;
import com.tckj.wx.application.service.IOrganizationService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 机构表 服务实现类
 * </p>
 *
 * @author WCH
 * @since 2020-06-24
 */
@Service
public class OrganizationServiceImpl extends ServiceImpl<OrganizationMapper, Organization> implements IOrganizationService {

    @Autowired
    private OrganizationMapper organizationMapper;




}
