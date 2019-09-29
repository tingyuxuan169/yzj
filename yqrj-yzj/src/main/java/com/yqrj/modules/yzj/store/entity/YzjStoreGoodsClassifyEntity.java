package com.yqrj.modules.yzj.store.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.yqrj.common.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * 商品分类
 *
 * @author cxl cxl315@qq.com
 * @since 1.0.0 2019-09-06
 */
@Data
@EqualsAndHashCode(callSuper=false)
@TableName("yzj_store_goods_classify")
public class YzjStoreGoodsClassifyEntity extends BaseEntity {
	private static final long serialVersionUID = 1L;

    /**
     * 分类名称
     */
	private String name;
    /**
     * 分类图片
     */
	private String imgUrl;
    /**
     * 上级分类
     */
	private Long pid;
    /**
     * 分类描述
     */
	private String remark;
    /**
     * 删除标志
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