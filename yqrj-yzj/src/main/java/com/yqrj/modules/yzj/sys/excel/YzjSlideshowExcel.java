package com.yqrj.modules.yzj.sys.excel;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;

import java.util.Date;

/**
 * 轮播图
 *
 * @author cxl cxl315@qq.com
 * @since 1.0.0 2019-09-06
 */
@Data
public class YzjSlideshowExcel {
    @Excel(name = "轮播图编号")
    private Long id;
    @Excel(name = "轮播图类型0平台1商城")
    private Integer stype;
    @Excel(name = "标题")
    private String title;
    @Excel(name = "位置")
    private String site;
    @Excel(name = "说明")
    private String remark;
    @Excel(name = "链接")
    private String link;
    @Excel(name = "是否显示0显示1隐藏")
    private Integer isshow;
    @Excel(name = "排序号")
    private Integer sort;
    @Excel(name = "开始日期")
    private Date startDate;
    @Excel(name = "截止日期")
    private Date endDate;
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