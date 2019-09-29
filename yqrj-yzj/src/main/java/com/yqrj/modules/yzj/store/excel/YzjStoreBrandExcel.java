package com.yqrj.modules.yzj.store.excel;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;

import java.util.Date;

/**
 * 商品品牌
 *
 * @author cxl cxl315@qq.com
 * @since 1.0.0 2019-09-06
 */
@Data
public class YzjStoreBrandExcel {
    @Excel(name = "品牌编号")
    private Long id;
    @Excel(name = "品牌名称")
    private String name;
    @Excel(name = "品牌图片")
    private String imgUrl;
    @Excel(name = "品牌描述")
    private String remark;
    @Excel(name = "删除标志0正常1删除")
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