package com.yqrj.modules.yzj.store.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;


/**
 * 商品分类
 *
 * @author cxl cxl315@qq.com
 * @since 1.0.0 2019-09-06
 */
@Data
@ApiModel(value = "商品分类")
public class YzjStoreGoodsClassifyDTO implements Serializable {
    private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "分类编号")
	private Long id;

	@ApiModelProperty(value = "分类名称")
	private String name;

	@ApiModelProperty(value = "分类图片")
	private String imgUrl;

	@ApiModelProperty(value = "上级分类")
	private Long pid;

	@ApiModelProperty(value = "分类描述")
	private String remark;

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