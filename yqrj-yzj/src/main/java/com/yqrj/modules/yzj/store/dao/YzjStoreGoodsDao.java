package com.yqrj.modules.yzj.store.dao;

import com.yqrj.common.dao.BaseDao;
import com.yqrj.modules.yzj.store.dto.YzjStoreGoodsDTO;
import com.yqrj.modules.yzj.store.entity.YzjStoreGoodsEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 商品详情及专区
 * @author ZhangRongFei
 * @date 2019/9/29 14:42
 */
@Mapper
public interface YzjStoreGoodsDao extends BaseDao<YzjStoreGoodsEntity> {

    @Select("select * from yzj_store_goods where goods_type=#{goods_type}")
    List<YzjStoreGoodsDTO> list(Integer goodsType);
}
