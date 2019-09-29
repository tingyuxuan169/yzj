package com.yqrj.common.utils;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

import com.alibaba.fastjson.JSONObject;
import com.yqrj.modules.common.Constants;
import com.yqrj.modules.sys.service.SysParamsService;

public class SignUtil { 
	private static Logger logger = LoggerFactory.getLogger(SignUtil.class);
	
	public static String sign(Map<String, Object> reqMap) throws Exception {
		// 创建签名
		String sign = SignUtil.createSign(reqMap, Constants.bankKey, Constants.bankSecret);
		reqMap.put("sign", sign);
		String result = "";
		try {
			result = sendRequest(Constants.bankApiUrl, Constants.bankPublicKey, Constants.bankPrivateKey, Constants.bankKey, Constants.bankOrg, reqMap);
			logger.info("返回结果：" + result);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	/**
	 * 
	 * @Title: createSign
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param requestBody
	 * @param signKey
	 * @param signSecret
	 * @return String
	 */
	public static String createSign(Map<String, Object> requestBody, String signKey, String signSecret) {
		String data = convertMapToJson(requestBody);
		logger.info("签名原始串：" + data);
		String key = DigestUtils.md5Hex(signKey + signSecret);
		logger.info("签名密钥串：" + key);
		String sign = DigestUtils.md5Hex(data + key);
		logger.info("签名结果串：" + sign);
		return sign;
	}

	/**
	 * 
	 * @Title: sendRequest
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param url
	 * @param publicKey
	 * @param privateKey
	 * @param key
	 * @param org
	 * @param ht
	 * @return String
	 * @throws Exception
	 */
	public static String sendRequest(String url, String publicKey, String privateKey, String key, String org, Map<String, Object> ht) throws Exception {
		// 加密
		String param = SignUtil.RSAEncryptRequest(publicKey, ht);
		// 发送请求,得到响应数据
		HttpClient rr = new HttpClient();
		Object o = rr.sendRequestForPost(key, org, url, param);
		if (null == o) {
			throw new Exception("请求返回的数据为null");
		}
		String resStr = "";
		try {
			// 解密
			resStr = SignUtil.RSADecryptResponse(privateKey, String.valueOf(o));
		} catch (Exception e) {
			throw new Exception("响应解密失败:" + e);
		}
		return resStr;
	}
	// 加密
	public static String RSAEncryptRequest(String publicKey, Map reqData) {
		return encrypt(publicKey, JSONObject.toJSONString(reqData).toString());
	}
	// 解密
	public static String RSADecryptResponse(String privateKey, String repData) {
		return decrypt(privateKey, repData);
	}
	// 生成请求密文
	public static String encrypt(String publicKey, String data) {
		try {
			String encryptedStr = RSATool.RSAEncode(publicKey, data);
			logger.info("生成的请求密文为：" + encryptedStr);
			return encryptedStr;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public static String decrypt(String privateKey, String data) {
		try {
			String decryptedStr = RSATool.RSADecode(privateKey, data);
			logger.info("响应解密明文为：" + decryptedStr);
			return decryptedStr;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public static Boolean signVerify(String key, String secret, Map<String, Object> data, String sign) {
		String newSign = createSign(data, key, secret);
		return newSign.equals(sign);
	}

	public static String convertMapToJson(Map<String, Object> requestBody) {
		requestBody.remove("sign");
		TreeSet<String> sortedKey = new TreeSet<String>(requestBody.keySet());
		StringBuilder builer = new StringBuilder();
		for (String key : sortedKey) {
			builer.append(key).append("=").append(convertObjectToJson(requestBody.get(key))).append("&");
		}
		String result = builer.toString();
		logger.info("result：" + result);
		return result.substring(0, result.length() - 1);
	}

	public static String convertObjectToJson(Object obj) {
		logger.info("obj：" + obj);
		if (obj == null) {
			return "";
		}
		if (obj.getClass().isArray()) {
			return StringUtils.join((Object[]) obj, "&");
		} else if (obj instanceof Map) {
			return convertMapToJson((Map<String, Object>) obj);
		} else if (obj.getClass().isPrimitive() || obj.getClass() == String.class) {
			return String.valueOf(obj);
		} else if (obj instanceof Collection) {
			StringBuilder builder = new StringBuilder();
			for (Object _obj : (List<Object>) obj) {
				builder.append(convertObjectToJson(_obj)).append("&");
			}
			String result = builder.toString();
			return result.substring(0, result.length() - 1);
		} else {
			return String.valueOf(obj);
		}
	}
}
