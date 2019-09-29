package com.yqrj.modules.yzj.sys.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.yqrj.common.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * 轮播图
 *
 * @author cxl cxl315@qq.com
 * @since 1.0.0 2019-09-06
 */
@Data
@EqualsAndHashCode(callSuper=false)
@TableName("yzj_slideshow")
public class YzjSlideshowEntity extends BaseEntity {
	private static final long serialVersionUID = 1L;

    /**
     * 轮播图类型0平台1商城
     */
	private Integer stype;
    /**
     * 标题
     */
	private String title;
    /**
     * 位置
     */
	private String site;
    /**
     * 说明
     */
	private String remark;
    /**
     * 链接
     */
	private String link;
    /**
     * 是否显示0显示1隐藏
     */
	private Integer isshow;
    /**
     * 排序号
     */
	private Integer sort;
    /**
     * 开始日期
     */
	private Date startDate;
    /**
     * 截止日期
     */
	private Date endDate;
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