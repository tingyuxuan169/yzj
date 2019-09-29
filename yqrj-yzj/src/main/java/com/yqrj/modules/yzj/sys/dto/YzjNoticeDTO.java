package com.yqrj.modules.yzj.sys.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;


/**
 * 公告信息
 *
 * @author cxl cxl315@qq.com
 * @since 1.0.0 2019-09-04
 */
@Data
@ApiModel(value = "公告信息")
public class YzjNoticeDTO implements Serializable {
    private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "公告编号")
	private Long id;

	@ApiModelProperty(value = "公告类型0平台1商城")
	private Integer ntype;

	@ApiModelProperty(value = "公告标题")
	private String title;

	@ApiModelProperty(value = "公告正文")
	private String content;

	@ApiModelProperty(value = "点击量")
	private Integer hits;

	@ApiModelProperty(value = "公告状态0未审核1已审核2已失效")
	private Integer status;

	@ApiModelProperty(value = "生效时间")
	private Date startTime;

	@ApiModelProperty(value = "失效时间")
	private Date endTime;

	@ApiModelProperty(value = "删除标志0正常1删除")
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