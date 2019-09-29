package com.yqrj.modules.yzj.store.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.yqrj.common.entity.BaseEntity;
import lombok.*;
import java.util.Date;

/**
 * 商品详情及商品专区
 * @Author  ZhangRongFei
 * @Date 2019/09/29 14:17
 */

@Data
@EqualsAndHashCode(callSuper=false)
@TableName("yzj_store_goods")
public class YzjStoreGoodsEntity extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 商品编号
     */
    private Long goodsCode;

    /**
     * 商品名称
     */
    private String goodsName;

    /**
     * 商品品牌编号
     */
    private Long goodsBrandCode;

    /**
     * 商品分类编号
     */
    private Long goodsClassifyCode;

    /**
     * 商品编码
     */
    private String goodsRecode;

    /**
     * 商品主图
     */
    private String goodsView;

    /**
     * 商品视频封面图
     */
    private String goodsVideoView;

    /**
     * 商品视频
     */
    private String goodsVideo;

    /**
     * 关键词
     */
    private String keyWord;

    /**
     * 商品详情
     */
    private String goodsDetail;

    /**
     * 推荐商品
     */
    private String recommendingCommodities;

    /**
     * 同店商品（最多关联六个商品，在商品详情页展示同店商品）
     */
    private String sameStoreGoods;

    /**
     * 促销商品
     */
    private String promotionGoods;

    /**
     * 新品商品
     */
    private String newGoods;

    /**
     * 热销商品
     */
    private String bestSellersGoods;

    /**
     * 特价商品
     */
    private String specialsGoods;

    /**
     * 独家商品
     */
    private String exclusiveGoods;

    /**
     * 市场价格
     */
    private Double marketPrice;

    /**
     * 会员价格
     */
    private Double membershipPrice;

    /**
     * 广告费
     */
    private Double advertisingFee;

    /**
     * 总库存
     */
    private String totalInventory;

    /**
     * 总重量
     */
    private Double weight;

    private Double costPrice;

    /**
     * 运费
     */
    private Double freight;

    /**
     * 额外赠送会员积分
     */
    private String membershipPoint;

    /**
     * 额外赠送分销积分
     */
    private String distributionPoints;

    /**
     * 商品限购
     */
    private String commodityRestriction;

    /**
     * 等级折扣
     */
    private String classDiscount;

    /**
     * 开售时间
     */
    private Date openingTime;

    /**
     * 发票
     */
    private String invoice;

    /**
     * 保修时间
     */
    private Date warrantyTime;

    private Integer goodsStatus;

    private Integer isDel;


    /**
     * 更新者
     */
    private Date updater;

    /**
     * 更新时间
     */
    private Date updateDate;

    /**
     * 销量
     */
    private String sales;

    /**
     * 商品类型
     */
    private Integer goodsType;

}
