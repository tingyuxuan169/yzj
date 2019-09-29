package com.yqrj.modules.yzj.store.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 商品详情及商品专区
 * @author ZhangRongFei
 * @date 2019/9/29 14:25
 */
@Data
@ApiModel(value = "商品详情及商品专区")
public class YzjStoreGoodsDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "商品ID")
    private Long id;

    /**
     * 商品编号
     */
    @ApiModelProperty
    private Long goodsCode;

    /**
     * 商品名称
     */
    @ApiModelProperty
    private String goodsName;

    /**
     * 商品品牌编号
     */
    @ApiModelProperty
    private Long goodsBrandCode;

    /**
     * 商品分类编号
     */
    @ApiModelProperty
    private Long goodsClassifyCode;

    /**
     * 商品编码
     */
    @ApiModelProperty
    private String goodsRecode;

    /**
     * 商品主图
     */
    @ApiModelProperty
    private String goodsView;

    /**
     * 商品视频封面图
     */
    @ApiModelProperty
    private String goodsVideoView;

    /**
     * 商品视频
     */
    @ApiModelProperty
    private String goodsVideo;

    /**
     * 商品详情
     */
    @ApiModelProperty
    private String goodsDetail;

    /**
     * 推荐商品
     */
    @ApiModelProperty
    private String recommendingCommodities;

    /**
     * 同店商品（最多关联六个商品，在商品详情页展示同店商品）
     */
    @ApiModelProperty
    private String sameStoreGoods;

    /**
     * 促销商品
     */
    @ApiModelProperty
    private String promotionGoods;


    /**
     * 市场价格
     */
    @ApiModelProperty
    private Double marketPrice;

    /**
     * 会员价格
     */
    @ApiModelProperty
    private Double membershipPrice;

    /**
     * 广告费
     */
    @ApiModelProperty
    private Double advertisingFee;

    /**
     * 总库存
     */
    @ApiModelProperty
    private String totalInventory;

    /**
     * 总重量
     */
    @ApiModelProperty
    private Double weight;

    @ApiModelProperty
    private Double costPrice;

    /**
     * 运费
     */
    @ApiModelProperty
    private Double freight;

    /**
     * 额外赠送会员积分
     */
    @ApiModelProperty
    private String membershipPoint;

    /**
     * 额外赠送分销积分
     */
    @ApiModelProperty
    private String distributionPoints;

    /**
     * 商品限购
     */
    @ApiModelProperty
    private String commodityRestriction;

    /**
     * 等级折扣
     */
    @ApiModelProperty
    private String classDiscount;


    /**
     * 销量
     */
    @ApiModelProperty
    private String sales;

    /**
     * 商品类型
     */
    @ApiModelProperty
    private Integer goodsType;
}
