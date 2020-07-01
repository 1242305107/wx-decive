package com.tckj.wx.application.dao;

import com.tckj.wx.application.entity.Menu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.Set;

/**
 * <p>
 * 菜单表 Mapper 接口
 * </p>
 *
 * @author WCH
 * @since 2020-06-28
 */
public interface MenuMapper extends BaseMapper<Menu> {

    Set<Menu> selecApiMenuList(@Param("roleIds") Set<String> roleIds)throws Exception;
}
