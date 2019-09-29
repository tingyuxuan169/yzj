package com.yqrj.modules.sys.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.yqrj.common.utils.YqrjUtils;
import com.yqrj.common.utils.Result;
import com.yqrj.common.utils.SignUtil;
import com.yqrj.modules.common.Constants;
import com.yqrj.modules.sys.service.SysRockFintechService;

/**
 * 钜石存管平台 API
 *
 * @author cxl cxl315@qq.com
 * @since 1.0.0
 */
@Service
public class SysRockFintechServiceImpl implements SysRockFintechService {
    private Logger logger = LoggerFactory.getLogger(getClass());

    /**
     *  钜石存管平台 API接口调用
     * 
     * @param reqMap 接口参数
     * @param bool 是否生产日志
     * 
     */
    @Override
    public Result rockFintechApi(Map<String, Object> reqMap, boolean bool) {
        // TODO Auto-generated method stub
        JSONObject result = new JSONObject();
        try {
            //TODO 获取公共参数
            Map<String, Object> parameters = getPublicParas();
            //TODO put所有前端参数
            parameters.putAll(reqMap);
            if (bool) {
                //>>>>>>>>>>保存接口日志开始<<<<<<<<<<

                //>>>>>>>>>>保存接口日志结束<<<<<<<<<<
            }
            //TODO 去银行获取结果
            String reSign = SignUtil.sign(parameters);
            //TODO 返回前端参数
            result.put("reqMap", parameters);
            //TODO 返回银行结果
            result.put("retRes", YqrjUtils.getJsonObject(reSign));
        } catch (Exception e) {

        }
        if (bool) {
            //>>>>>>>>>>修改接口日志开始<<<<<<<<<<

            //>>>>>>>>>>修改接口日志结束<<<<<<<<<<
        }
        return new Result().ok(result);
    }

    /**
     * 设置公用参数
     * @return
     */
    private static Map<String, Object> getPublicParas() {
        Map<String, Object> reqMap = new HashMap<String, Object>();
        //接口名称——必须,接口名称对应表
        //reqMap.put("service", service);
        //时间戳——必须,商户发起接口调用时服务器时间。采用Unix时间戳格式：1489000690(10)位
        reqMap.put("timestamp", System.currentTimeMillis());
        //通用唯一识别码——必须,商户发起接口调用之前必须生成一个唯一标识发送给服务器。
        reqMap.put("uuid", Constants.out_serial_no);
        //签名类型——可选,默认为MD5，目前仅支持MD5。
        reqMap.put("sign_type", "");
        //参数编码——可选,默认为UTF-8。
        reqMap.put("encode", "UTF-8");
        //版本号——可选,默认为当前文档版本号2.0.0。
        reqMap.put("version", "2.0.0");
        //商户自定义数据——可选,用于传递商户自定义数据，商户上传的数据会直接返回给商户    目前传的是源数据ID
        reqMap.put("custom", "");
        //交易终端 ,必填，000001手机APP 000002网页 000003微信 000004柜面
        reqMap.put("client", "000002");
        //客户端ip
        reqMap.put("client_ip", "127.0.0.1");
        //电脑端上送MAC地址，如果获取不到就上送：pc_client，移动端上送IMEI，ios获取不到IMEI就上送：广告ID（IDFA）
        reqMap.put("client_service", "pc_client");
        return reqMap;
    }

}
