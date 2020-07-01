package com.tckj.wx.application.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 角色菜单表
 * </p>
 *
 * @author WCH
 * @since 2020-06-28
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("tb_role_menu")
@ApiModel(value="RoleMenu对象", description="角色菜单表")
public class RoleMenu extends Model<RoleMenu> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    @TableId(value = "role_to_menu_id", type = IdType.AUTO)
    private Integer roleToMenuId;

    @ApiModelProperty(value = "角色代号")
    @TableField("role_id")
    private String roleId;

    @ApiModelProperty(value = "菜单代号,规范权限标识")
    @TableField("menu_id")
    private String menuId;


    @Override
    protected Serializable pkVal() {
        return this.roleToMenuId;
    }

}
