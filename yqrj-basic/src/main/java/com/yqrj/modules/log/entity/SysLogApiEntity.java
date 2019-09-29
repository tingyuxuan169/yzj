package com.yqrj.modules.log.entity;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableName;
import com.yqrj.common.entity.BaseEntity;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 接口日志
 *
 * @author cxl cxl315@qq.com
 * @since 1.0.0 2019-07-07
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("sys_log_api")
public class SysLogApiEntity extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 通用唯一识别码
     */
    private String            uuid;
    /**
     * 接口编码
     */
    private String            apicode;
    /**
     * 接口标记0请求1回调
     */
    private Integer           apisign;
    /**
     * 接口地址
     */
    private String            apiaddr;
    /**
     * 传输方式get post
     */
    private String            apimode;
    /**
     * 发送/回调内容
     */
    private String            sendms;
    /**
     * 接收/返回内容
     */
    private String            recvms;
    /**
     * 结果编码
     */
    private String            code;
    /**
     * 源数据ID
     */
    private Long              sourceId;
    /**
     * 更新者
     */
    private Long              updater;
    /**
     * 更新时间
     */
    private Date              updateDate;
}