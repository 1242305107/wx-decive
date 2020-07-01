package com.tckj.wx.application.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 菜单表
 * </p>
 *
 * @author WCH
 * @since 2020-06-28
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("tb_menu")
@ApiModel(value="Menu对象", description="菜单表")
public class Menu extends Model<Menu> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "菜单代号,规范权限标识")
    @TableField("id")
    private String id;

    @ApiModelProperty(value = "父菜单主键")
    @TableField("parent_id")
    private String parentId;

    @ApiModelProperty(value = "代码控制权限标识符")
    @TableField("code")
    private String code;

    @ApiModelProperty(value = "菜单名称")
    @TableField("name")
    private String name;

    @ApiModelProperty(value = "菜单类型，0：菜单  1：按钮 2： 接口")
    @TableField("menu_type")
    private Integer menuType;

    @ApiModelProperty(value = "菜单地址")
    @TableField("url")
    private String url;

    @ApiModelProperty(value = "一级菜单栏图标")
    @TableField("icon")
    private String icon;

    @ApiModelProperty(value = "权限属于哪个系统（0、业务；1、配置；2、大屏；）")
    @TableField("type")
    private Integer type;

    @ApiModelProperty(value = "排序")
    @TableField("order")
    private Integer order;


    @Override
    protected Serializable pkVal() {
        return null;
    }

}
