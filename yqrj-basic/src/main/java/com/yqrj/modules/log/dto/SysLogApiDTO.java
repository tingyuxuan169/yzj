package com.yqrj.modules.log.dto;

import java.io.Serializable;
import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 接口日志
 *
 * @author cxl cxl315@qq.com
 * @since 1.0.0 2019-07-07
 */
@Data
@ApiModel(value = "接口日志")
public class SysLogApiDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "流水号")
    private Long              id;

    @ApiModelProperty(value = "通用唯一识别码")
    private String            uuid;

    @ApiModelProperty(value = "接口编码")
    private String            apicode;

    @ApiModelProperty(value = "接口标记0请求1回调")
    private Integer           apisign;

    @ApiModelProperty(value = "接口地址")
    private String            apiaddr;

    @ApiModelProperty(value = "传输方式get post")
    private String            apimode;

    @ApiModelProperty(value = "发送/回调内容")
    private String            sendms;

    @ApiModelProperty(value = "接收/返回内容")
    private String            recvms;

    @ApiModelProperty(value = "结果编码")
    private String            code;

    @ApiModelProperty(value = "源数据ID")
    private Long              sourceId;

    @ApiModelProperty(value = "创建者")
    private Long              creator;

    @ApiModelProperty(value = "创建时间")
    private Date              createDate;

    @ApiModelProperty(value = "更新者")
    private Long              updater;

    @ApiModelProperty(value = "更新时间")
    private Date              updateDate;

}