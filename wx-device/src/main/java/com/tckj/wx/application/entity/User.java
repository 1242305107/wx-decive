package com.tckj.wx.application.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


/**
 * <p>
 * 用户表
 * </p>
 *
 * @author WCH
 * @since 2020-06-22
 */
@Data
@TableName("tb_user")
@ApiModel(value="User对象", description="用户表")
public class User extends Model<User> implements Cloneable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "用户主键")
    private String id;

    @ApiModelProperty(value = "用户名")
    private String username;

    @ApiModelProperty(value = "密码")
    private String password;

    @ApiModelProperty(value = "昵称")
    private String nickname;

    @ApiModelProperty(value = "头像url")
    @TableField("head_img_url")
    private String headImgUrl;

    @ApiModelProperty(value = "手机号")
    private String phone;

    @ApiModelProperty(value = "性别")
    private Integer sex;

    @ApiModelProperty(value = "状态（0有效,1无效）")
    @TableLogic
    private Integer enabled;

    @ApiModelProperty(value = "类型（1草地 2耕地 3林地 4其他 5地图用户）")
    private String type;

    @ApiModelProperty(value = "创建时间")
    @TableField("create_time")
    private Long createTime;

    @ApiModelProperty(value = "修改时间")
    @TableField("update_time")
    private Long updateTime;

    @ApiModelProperty(value = "机构主键")
    @TableField("organization_id")
    private Integer organizationId;

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
