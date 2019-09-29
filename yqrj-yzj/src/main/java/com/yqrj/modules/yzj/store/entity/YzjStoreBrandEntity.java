package com.yqrj.modules.yzj.store.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.yqrj.common.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * 商品品牌
 *
 * @author cxl cxl315@qq.com
 * @since 1.0.0 2019-09-06
 */
@Data
@EqualsAndHashCode(callSuper=false)
@TableName("yzj_store_brand")
public class YzjStoreBrandEntity extends BaseEntity {
	private static final long serialVersionUID = 1L;

    /**
     * 品牌名称
     */
	private String name;
    /**
     * 品牌图片
     */
	private String imgUrl;
    /**
     * 品牌描述
     */
	private String remark;
    /**
     * 删除标志0正常1删除
     */
	private Integer delFlag;
    /**
     * 修改人
     */
	private Long updater;
    /**
     * 修改时间
     */
	private Date updateDate;
}