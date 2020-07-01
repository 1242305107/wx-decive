package com.tckj.wx.application.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.time.LocalDateTime;
import java.io.Serializable;
import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 机构表
 * </p>
 *
 * @author WCH
 * @since 2020-06-24
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("tb_organization")
@ApiModel(value="Organization对象", description="机构表")
public class Organization extends Model<Organization> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "自增id")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "机构名称")
    @TableField("organization_name")
    private String organizationName;

    @ApiModelProperty(value = "机构标识")
    @TableField("img")
    private String img;

    @ApiModelProperty(value = "联系人")
    @TableField("manager")
    private String manager;

    @ApiModelProperty(value = "联系电话")
    @TableField("telephone")
    private String telephone;

    @ApiModelProperty(value = "删除状态 0:正常 1:已删除")
    @TableField("delete_status")
    private Integer deleteStatus;

    @ApiModelProperty(value = "创建时间")
    @TableField(value = "create_time",fill = FieldFill.INSERT)
    private Date createTime;

    @ApiModelProperty(value = "修改时间")
    @TableField(value = "update_time",fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

    @ApiModelProperty(value = "创建人")
    @TableField("create_user")
    private String createUser;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
