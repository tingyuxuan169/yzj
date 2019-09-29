package com.yqrj.modules.yzj.sys.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.yqrj.common.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * 公告信息
 *
 * @author cxl cxl315@qq.com
 * @since 1.0.0 2019-09-04
 */
@Data
@EqualsAndHashCode(callSuper=false)
@TableName("yzj_notice")
public class YzjNoticeEntity extends BaseEntity {
	private static final long serialVersionUID = 1L;

    /**
     * 公告类型0平台1商城
     */
	private Integer ntype;
    /**
     * 公告标题
     */
	private String title;
    /**
     * 公告正文
     */
	private String content;
    /**
     * 点击量
     */
	private Integer hits;
    /**
     * 公告状态0未审核1已审核2已失效
     */
	private Integer status;
    /**
     * 生效时间
     */
	private Date startTime;
    /**
     * 失效时间
     */
	private Date endTime;
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