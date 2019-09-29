package com.yqrj.modules.yzj.store.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;


/**
 * 商品品牌
 *
 * @author cxl cxl315@qq.com
 * @since 1.0.0 2019-09-06
 */
@Data
@ApiModel(value = "商品品牌")
public class YzjStoreBrandDTO implements Serializable {
    private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "品牌编号")
	private Long id;

	@ApiModelProperty(value = "品牌名称")
	private String name;

	@ApiModelProperty(value = "品牌图片")
	private String imgUrl;

	@ApiModelProperty(value = "品牌描述")
	private String remark;

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