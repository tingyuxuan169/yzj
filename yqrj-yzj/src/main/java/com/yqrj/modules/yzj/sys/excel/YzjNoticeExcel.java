package com.yqrj.modules.yzj.sys.excel;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;

import java.util.Date;

/**
 * 公告信息
 *
 * @author cxl cxl315@qq.com
 * @since 1.0.0 2019-09-04
 */
@Data
public class YzjNoticeExcel {
    @Excel(name = "公告编号")
    private Long id;
    @Excel(name = "公告类型0平台1商城")
    private Integer ntype;
    @Excel(name = "公告标题")
    private String title;
    @Excel(name = "公告正文")
    private String content;
    @Excel(name = "点击量")
    private Integer hits;
    @Excel(name = "公告状态0未审核1已审核2已失效")
    private Integer status;
    @Excel(name = "生效时间")
    private Date startTime;
    @Excel(name = "失效时间")
    private Date endTime;
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