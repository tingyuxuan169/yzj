package com.yqrj.modules.yzj.store.excel;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;

import java.util.Date;

/**
 * 商品详情及专区
 * @author ZhangRongFei
 * @date 2019/9/29 14:53
 */
@Data
public class YzjStoreGoodsExcel {
    @Excel(name = "商品ID")
    private Long id;

    /**
     * 商品编号
     */
    @Excel(name = "商品编号")
    private Long goodsCode;

    /**
     * 商品名称
     */
    @Excel(name = "商品名称")
    private String goodsName;

    /**
     * 商品品牌编号
     */
    @Excel(name = "商品品牌编号")
    private Long goodsBrandCode;

    /**
     * 商品分类编号
     */
    @Excel(name = "商品分类编号")
    private Long goodsClassifyCode;

    /**
     * 商品编码
     */
    @Excel(name = "商品编码")
    private String goodsRecode;

    /**
     * 商品主图
     */
    @Excel(name = "商品主图")
    private String goodsView;

    /**
     * 商品视频封面图
     */
    @Excel(name = "商品视频封面图")
    private String goodsVideoView;

    /**
     * 商品视频
     */
    @Excel(name = "商品视频")
    private String goodsVideo;

    /**
     * 关键词
     */
    @Excel(name = "关键词")
    private String keyWord;

    /**
     * 商品详情
     */
    @Excel(name = "商品详情")
    private String goodsDetail;

    /**
     * 推荐商品
     */
    @Excel(name = "推荐商品")
    private String recommendingCommodities;

    /**
     * 同店商品（最多关联六个商品，在商品详情页展示同店商品）
     */
    @Excel(name = "同店商品（最多关联六个商品，在商品详情页展示同店商品）")
    private String sameStoreGoods;

    /**
     * 促销商品
     */
    @Excel(name = "促销商品")
    private String promotionGoods;

    /**
     * 新品商品
     */
    @Excel(name = "新品商品")
    private String newGoods;

    /**
     * 热销商品
     */
    @Excel(name = "热销商品")
    private String bestSellersGoods;

    /**
     * 特价商品
     */
    @Excel(name = "特价商品")
    private String specialsGoods;

    /**
     * 独家商品
     */
    @Excel(name = "独家商品")
    private String exclusiveGoods;

    /**
     * 市场价格
     */
    @Excel(name = "市场价格")
    private Double marketPrice;

    /**
     * 会员价格
     */
    @Excel(name = "会员价格")
    private Double membershipPrice;

    /**
     * 广告费
     */
    @Excel(name = "广告费")
    private Double advertisingFee;

    /**
     * 总库存
     */
    @Excel(name = "总库存")
    private String totalInventory;

    /**
     * 总重量
     */
    @Excel(name = "总重量")
    private Double weight;

    @Excel(name = "商品ID")
    private Double costPrice;

    /**
     * 运费
     */
    @Excel(name = "运费")
    private Double freight;

    /**
     * 额外赠送会员积分
     */
    @Excel(name = "额外赠送会员积分")
    private String membershipPoint;

    /**
     * 额外赠送分销积分
     */
    @Excel(name = "额外赠送分销积分")
    private String distributionPoints;

    /**
     * 商品限购
     */
    @Excel(name = "商品限购")
    private String commodityRestriction;

    /**
     * 等级折扣
     */
    @Excel(name = "等级折扣")
    private String classDiscount;

    /**
     * 开售时间
     */
    @Excel(name = "开售时间")
    private Date openingTime;

    /**
     * 发票
     */
    @Excel(name = "发票")
    private String invoice;

    /**
     * 保修时间
     */
    @Excel(name = "保修时间")
    private Date warrantyTime;

    @Excel(name = "")
    private Integer goodsStatus;

    @Excel(name = "")
    private Integer isDel;


    /**
     * 更新者
     */
    @Excel(name = "更新者")
    private Date updater;

    /**
     * 更新时间
     */
    @Excel(name = "更新时间")
    private Date updateDate;

    /**
     * 销量
     */
    @Excel(name = "销量")
    private String sales;

    /**
     * 商品类型
     */
    @Excel(name = "商品类型")
    private Integer goodsType;
}
