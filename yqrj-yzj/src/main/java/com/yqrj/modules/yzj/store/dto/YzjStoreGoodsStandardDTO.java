package com.yqrj.modules.yzj.store.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

import java.math.BigDecimal;

/**
 * 商品规格
 *
 * @author cxl cxl315@qq.com
 * @since 1.0.0 2019-09-06
 */
@Data
@ApiModel(value = "商品规格")
public class YzjStoreGoodsStandardDTO implements Serializable {
    private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "规格编号")
	private Long id;

	@ApiModelProperty(value = "商品编号")
	private Long goodsId;

	@ApiModelProperty(value = "规格名称")
	private String standardName;

	@ApiModelProperty(value = "规格值")
	private String standardValue;

	@ApiModelProperty(value = "市场价格")
	private BigDecimal marketPrice;

	@ApiModelProperty(value = "会员价格")
	private BigDecimal memberPrice;

	@ApiModelProperty(value = "广告费")
	private BigDecimal adPrice;

	@ApiModelProperty(value = "库存")
	private BigDecimal inventory;

	@ApiModelProperty(value = "重量(克)")
	private BigDecimal weight;

	@ApiModelProperty(value = "成本价(含税)")
	private BigDecimal costPrice;

	@ApiModelProperty(value = "商品编码")
	private String goodsCode;

	@ApiModelProperty(value = "销量")
	private BigDecimal salesVolume;

	@ApiModelProperty(value = "删除标志")
	private Integer delFlag;

	@ApiModelProperty(value = "创建人")
	private Long creator;

	@ApiModelProperty(value = "创建时间")
	private Date createDate;

	@ApiModelProperty(value = "修改人")
	private Long updater;

	@ApiModelProperty(value = "修改时间")
	private Date updateDate;


}