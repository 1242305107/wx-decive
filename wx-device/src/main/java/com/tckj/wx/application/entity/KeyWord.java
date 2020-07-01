package com.tckj.wx.application.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


/**
 * <p>
 * 
 * </p>
 *
 * @author wch
 * @since 2020-06-23
 */
@TableName(value = "KeyWord")
@Data
@ApiModel(value="KeyWord对象", description="")
public class KeyWord extends Model<KeyWord> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "ID", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "客户")
    @TableField("CLIENT")
    private String client;

    @ApiModelProperty(value = "订单日期")
    @TableField("ORDER_DATA")
    private String orderData;

    @ApiModelProperty(value = "交货日期")
    @TableField("DELIVERY_DATA")
    private String deliveryData;

    @ApiModelProperty(value = "客户PO")
    @TableField("CLIENT_PO")
    private String clientPo;

    @ApiModelProperty(value = "公司货号")
    @TableField("ART_NO")
    private Integer artNo;

    @ApiModelProperty(value = "制单者")
    @TableField("PREPARED_BY")
    private String preparedBy;

    @ApiModelProperty(value = "产品名称")
    @TableField("PRODUCT_NAME")
    private String productName;

    @ApiModelProperty(value = "产品尺寸")
    @TableField("PRODUCT_SIZE")
    private Double productSize;

    @ApiModelProperty(value = "包装尺寸")
    @TableField("PACKAGE_SIZE")
    private Double packageSize;

    @ApiModelProperty(value = "装箱数量")
    @TableField("PACKING_QUANTITY")
    private Integer packingQuantity;

    @ApiModelProperty(value = "产品克重")
    @TableField("PRODUCT_WEIGHT")
    private Float productWeight;

    @ApiModelProperty(value = "采购数量")
    @TableField("PURCHASE_AMOUNT")
    private Integer purchaseAmount;

    @ApiModelProperty(value = "参与生产者1")
    @TableField("PARTICIPANT_A")
    private String participantA;

    @ApiModelProperty(value = "参与生产者2")
    @TableField("PARTICIPANT_B")
    private String participantB;

    @ApiModelProperty(value = "参与生产者3")
    @TableField("PARTICIPANT_C")
    private String participantC;

    @ApiModelProperty(value = "总成本")
    @TableField("COST")
    private Float cost;

    @ApiModelProperty(value = "接单价格")
    @TableField("ORDER_PRICE")
    private Float orderPrice;

    @ApiModelProperty(value = "描述")
    @TableField("REMOKE")
    private String remoke;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }


}
