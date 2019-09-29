package com.yqrj.common.mybatisplus;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.apache.commons.lang3.StringUtils;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class EntityPluWrapper<T> extends QueryWrapper<T> {

	private final static String EQ = "eq_";
	private final static String LIKE = "like_";
	private final static String GT = "gt_";
	private final static String GE = "ge_";
	private final static String LT = "lt_";
	private final static String LE = "le_";
	private final static String IN = "in_";
	private final static String NIN = "nin_";
	private final static String NNULL = "nnull_";
	private final static String INULL = "inull_";
	private final static String ORDERA = "ordera_";
	private final static String ORDERD = "orderd_";
	private final static String GROUP = "group_";
	private final static String OR = "or_";
	private final static String NE = "ne_";
	private final static String NLIKE = "nlike_";
	private final static String BETWEEN = "btn_";
	private final static String ANDOR = "andor_";

	/**
	 * 数据库表映射实体类
	 */
	protected T entity = null;

	public EntityPluWrapper(Map<String, Object> params) {
		super();

		Iterator<String> items = params.keySet().iterator();

		String key = "";
		while (items.hasNext()) {
			key = items.next();
			addConditionByParam(key, params.get(key));
		}
	}

	public void addConditionByParam(String key, Object value) {

		if (key.equals("id")) {
			this.eq(StringUtils.isNotBlank((String) value), "id", value);
		} else if (key.startsWith(EQ)) { // 等同于SQL的 =
			this.eq(key.substring(EQ.length()), value);
		} else if (key.startsWith(LIKE)) { // 等同于SQL的 like
			this.like(key.substring(LIKE.length()), (String) value);
		} else if (key.startsWith(GT)) { // 等同于SQL的>
			this.gt(key.substring(GT.length()), value);
		} else if (key.startsWith(GE)) { // 等同于SQL的>=
			this.ge(key.substring(GE.length()), value);
		} else if (key.startsWith(LT)) { // 等同于SQL的<
			this.lt(key.substring(LT.length()), value);
		} else if (key.startsWith(LE)) { // 等同于SQL的<=
			this.le(key.substring(LE.length()), value);
		} else if (key.startsWith(IN)) { // 等同于SQL的 in
			this.in(key.substring(IN.length()), (List) value);
		} else if (key.startsWith(NIN)) { // 等同于SQL的 not in
			this.notIn(key.substring(NIN.length()), (List) value);
		} else if (key.startsWith(ORDERA)) { // 等同于SQL的 order by asc
			this.orderByAsc(key.substring(ORDERA.length()));
		} else if (key.startsWith(ORDERD)) { // 等同于SQL的 order by desc
			this.orderByDesc(key.substring(ORDERD.length()));
		} else if (key.startsWith(GROUP)) {
			this.groupBy(key.substring(GROUP.length()));
		} else if (key.startsWith(OR)) {
			this.or().like(key.substring(OR.length()), (String) value);
		} else if (key.startsWith(NE)) {// 等同于SQL的 !=或<>
			this.ne(key.substring(NE.length()), value);
		} else if (key.startsWith(NLIKE)) {// 等同于SQL的 not like
			this.notLike(key.substring(NLIKE.length()), (String) value);
		} else if (key.startsWith(NNULL)) {
			this.isNotNull(key.substring(NNULL.length()));
		} else if (key.startsWith(INULL)) {
			this.isNull(key.substring(NNULL.length()));
		} else if (key.startsWith(BETWEEN)) {
			List obj = (List) value;
			if (obj != null && obj.size() > 1) {
				this.between(key.substring(BETWEEN.length()), (Date) obj.get(0), (Date) obj.get(1));
			}
			/**
			 * } else if(key.startsWith(ANDOR)){ List obj = (List)value; if(obj != null) {
			 * this.and(i -> i.n) }
			 **/
		}
	}
}
