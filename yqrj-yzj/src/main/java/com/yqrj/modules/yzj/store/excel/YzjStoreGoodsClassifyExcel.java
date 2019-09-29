package com.yqrj.modules.yzj.store.excel;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;

import java.util.Date;

/**
 * 商品分类
 *
 * @author cxl cxl315@qq.com
 * @since 1.0.0 2019-09-06
 */
@Data
public class YzjStoreGoodsClassifyExcel {
    @Excel(name = "分类编号")
    private Long id;
    @Excel(name = "分类名称")
    private String name;
    @Excel(name = "分类图片")
    private String imgUrl;
    @Excel(name = "上级分类")
    private Long pid;
    @Excel(name = "分类描述")
    private String remark;
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