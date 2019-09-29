package com.yqrj.modules.yzj.store.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.yqrj.common.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 商品规格
 *
 * @author cxl cxl315@qq.com
 * @since 1.0.0 2019-09-06
 */
@Data
@EqualsAndHashCode(callSuper=false)
@TableName("yzj_store_goods_standard")
public class YzjStoreGoodsStandardEntity extends BaseEntity {
	private static final long serialVersionUID = 1L;

    /**
     * 商品编号
     */
	private Long goodsId;
    /**
     * 规格名称
     */
	private String standardName;
    /**
     * 规格值
     */
	private String standardValue;
    /**
     * 市场价格
     */
	private BigDecimal marketPrice;
    /**
     * 会员价格
     */
	private BigDecimal memberPrice;
    /**
     * 广告费
     */
	private BigDecimal adPrice;
    /**
     * 库存
     */
	private BigDecimal inventory;
    /**
     * 重量(克)
     */
	private BigDecimal weight;
    /**
     * 成本价(含税)
     */
	private BigDecimal costPrice;
    /**
     * 商品编码
     */
	private String goodsCode;
    /**
     * 销量
     */
	private BigDecimal salesVolume;
    /**
     * 删除标志
     */
	private Integer delFlag;
    /**
     * 修改人
     */
	private Long updater;
    /**
     * 修改时间
     */
	private Date updateDate;
}