package com.yqrj.modules.log.excel;

import java.util.Date;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;

/**
 * 接口日志
 *
 * @author cxl cxl315@qq.com
 * @since 1.0.0 2019-07-07
 */
@Data
public class SysLogApiExcel {
    @Excel(name = "流水号")
    private Long    id;
    @Excel(name = "通用唯一识别码")
    private String  uuid;
    @Excel(name = "接口编码")
    private String  apicode;
    @Excel(name = "接口标记0请求1回调")
    private Integer apisign;
    @Excel(name = "接口地址")
    private String  apiaddr;
    @Excel(name = "传输方式get post")
    private String  apimode;
    @Excel(name = "发送/回调内容")
    private String  sendms;
    @Excel(name = "接收/返回内容")
    private String  recvms;
    @Excel(name = "结果编码")
    private String  code;
    @Excel(name = "源数据ID")
    private Long    sourceId;
    @Excel(name = "创建者")
    private Long    creator;
    @Excel(name = "创建时间")
    private Date    createDate;
    @Excel(name = "更新者")
    private Long    updater;
    @Excel(name = "更新时间")
    private Date    updateDate;

}