package com.yqrj.modules.yzj.sys.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;


/**
 * 轮播图
 *
 * @author cxl cxl315@qq.com
 * @since 1.0.0 2019-09-06
 */
@Data
@ApiModel(value = "轮播图")
public class YzjSlideshowDTO implements Serializable {
    private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "轮播图编号")
	private Long id;

	@ApiModelProperty(value = "轮播图类型0平台1商城")
	private Integer stype;

	@ApiModelProperty(value = "标题")
	private String title;

	@ApiModelProperty(value = "位置")
	private String site;

	@ApiModelProperty(value = "说明")
	private String remark;

	@ApiModelProperty(value = "链接")
	private String link;

	@ApiModelProperty(value = "是否显示0显示1隐藏")
	private Integer isshow;

	@ApiModelProperty(value = "排序号")
	private Integer sort;

	@ApiModelProperty(value = "开始日期")
	private Date startDate;

	@ApiModelProperty(value = "截止日期")
	private Date endDate;

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