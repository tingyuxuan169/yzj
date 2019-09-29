/**
 * Copyright (c) 2018 一掌金 All rights reserved.
 * <p>
 * https://www.yizhangjin.com.cn
 * <p>
 * 版权所有，侵权必究！
 */

package com.yqrj.common.service;

import com.yqrj.common.page.PageData;

import java.util.List;
import java.util.Map;

/**
 *  CRUD基础服务接口
 *
 * @author cxl cxl315@qq.com
 */
public interface CrudService<T, D> extends BaseService<T> {

    PageData<D> page(Map<String, Object> params);

    List<D> list(Map<String, Object> params);

    D get(Long id);

    void save(D dto);

    void update(D dto);

    void delete(Long[] ids);

}