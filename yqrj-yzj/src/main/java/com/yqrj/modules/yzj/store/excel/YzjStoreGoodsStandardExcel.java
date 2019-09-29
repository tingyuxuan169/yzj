package com.yqrj.modules.yzj.store.excel;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 商品规格
 *
 * @author cxl cxl315@qq.com
 * @since 1.0.0 2019-09-06
 */
@Data
public class YzjStoreGoodsStandardExcel {
    @Excel(name = "规格编号")
    private Long id;
    @Excel(name = "商品编号")
    private Long goodsId;
    @Excel(name = "规格名称")
    private String standardName;
    @Excel(name = "规格值")
    private String standardValue;
    @Excel(name = "市场价格")
    private BigDecimal marketPrice;
    @Excel(name = "会员价格")
    private BigDecimal memberPrice;
    @Excel(name = "广告费")
    private BigDecimal adPrice;
    @Excel(name = "库存")
    private BigDecimal inventory;
    @Excel(name = "重量(克)")
    private BigDecimal weight;
    @Excel(name = "成本价(含税)")
    private BigDecimal costPrice;
    @Excel(name = "商品编码")
    private String goodsCode;
    @Excel(name = "销量")
    private BigDecimal salesVolume;
    @Excel(name = "删除标志")
    private Integer delFlag;
    @Excel(name = "创建人")
    private Long creator;
    @Excel(name = "创建时间")
    private Date createDate;
    @Excel(name = "修改人")
    private Long updater;
    @Excel(name = "修改时间")
    private Date updateDate;

}