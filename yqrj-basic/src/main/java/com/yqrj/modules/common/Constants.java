package com.yqrj.modules.common;

import java.util.UUID;

public class Constants {
    // 是否开启保存系统日志功能 0关闭1开启
    public static String  full_log_open_code      = "full_log_open";
    // 是否开启保护重复提交的功能 0关闭1开启
    public static String  full_resubmit_open_code = "full_re_submit_open";
    // 是否开启银行接口 0关闭1开启
    public static String  api_open_code           = "api_open";
    // 客户端-电脑
    public static String  client_service_pc       = "pc";
    // 客户端-手机
    public static String  client_service_mb       = "mb";
    // 客户-出借组织
    public static Long    dept_id_1               = 1067246875800000065L;
    // 客户-借款组织
    public static Long    dept_id_2               = 1067246875800000067L;
    // 客户-代偿组织
    public static Long    dept_id_3               = 1140427059823120385L;
    // 客户-出借角色
    public static Long    role_id_1               = 1140430670183534594L;
    // 客户-借款角色
    public static Long    role_id_2               = 1140430713745575937L;
    // 客户-代偿角色
    public static Long    role_id_3               = 1140430742963097601L;
    // 账户类型-普通户
    public static String  account_type_1          = "200201";
    // 账户类型-企业户
    public static String  account_type_2          = "200204";
    //用户角色-平台操作员
    public static Integer role_type_0             = 0;
    //用户角色-出借角色
    public static Integer role_type_1             = 1;
    //用户角色-借款角色
    public static Integer role_type_2             = 2;
    //用户角色-代偿角色
    public static Integer role_type_3             = 3;
    //卡类型-主卡
    public static Integer card_type_1             = 1;
    //卡类型-副卡
    public static Integer card_type_2             = 2;

    public static String  bankApiUrl              = "https://apiuat.rockfintech.com/2.0.0/deposit";
    public static String  bankKey                 = "6615464102995367";
    public static String  bankSecret              = "cc8820f743c995117333fecbea57f53a";
    public static String  bankOrg                 = "5001";
    public static String  bankPrivateKey          = getBankPrivateKey();
    public static String  bankPublicKey           = getBankPublicKey();

    private static String getBankPrivateKey() {
        StringBuffer strPrivateKey = new StringBuffer();
        strPrivateKey.append("MIIEvwIBADANBgkqhkiG9w0BAQEFAASCBKkwggSlAgEAAoIBAQDjJv6S7wl9c63X");
        strPrivateKey.append('\r');
        strPrivateKey.append("iQKciRMw8kMTDHnstXt0z+xvYYXuqkBNaln8uMcplDJ+VmVSx3u6NrbQ241oYG71");
        strPrivateKey.append('\r');
        strPrivateKey.append("j6qGAqdRY67h5l6dMyDTmghCarNgO96FN3KcMg88VTwM0UP4T1VV+LCDxzwRw9bE");
        strPrivateKey.append('\r');
        strPrivateKey.append("tvXz84phvF/UPJrdf+cK7uB3S/zH15uzQc0Vj46PD6CSSdlwM15bIQhqCbU/rH0+");
        strPrivateKey.append('\r');
        strPrivateKey.append("ZQEpUoXhWF34c9tOyq/8AEuTZEJvvg5O+6SfR79s/MZ6lsIJJHjVEqzjHtn5tLxX");
        strPrivateKey.append('\r');
        strPrivateKey.append("LM5eRT8veputOSJGEByhUbzlQLSKeqDbqkS+u5fnAveADZYc/CidGkVRV947F4iU");
        strPrivateKey.append('\r');
        strPrivateKey.append("y4Ig502nAgMBAAECggEBAMFSDpc+mPUL3ofxMyfGAW9Gv48Wry2lxsxDqRWiCjp0");
        strPrivateKey.append('\r');
        strPrivateKey.append("6wT33l4XZGkel1qubM1muQZiSnS2ZkLOz6BuBNLIr121WMEpLpzbRrTQAveDl+Xv");
        strPrivateKey.append('\r');
        strPrivateKey.append("DhKSfhgxAoZ2hATklNRfsGDapl+A0L7NzZrdm7VjMAK+L1CRw7t/f0Luylq9cQUh");
        strPrivateKey.append('\r');
        strPrivateKey.append("/7mnD14lMEDklKLzL/nznS62VX7kjFbPtdvqckIc347Z0LrPqCBhuWGYNEKC1yLM");
        strPrivateKey.append('\r');
        strPrivateKey.append("rFccPHbV49pZ8vdupfgAaAiKRJXpnpyvT2RquSPrD8rngTcQ+vHSrWdZbicEq5OF");
        strPrivateKey.append('\r');
        strPrivateKey.append("9AjfvBgwbvUZlFOWtqI4haLBHf/74eKrtjNHwexTtgECgYEA+sW+MyQZUQfxtngD");
        strPrivateKey.append('\r');
        strPrivateKey.append("ijapuNwcO/gs+J/KYAydS4HOZB8OyFfBL25wyVgyz560wHYweaRXfgr70a2XdpEc");
        strPrivateKey.append('\r');
        strPrivateKey.append("aTFAYd8Gj77iOWyxjiY18/VPGqyxEWnUmxbTEkTc46ksKkps/tEVyBu4ka4EO+Cb");
        strPrivateKey.append('\r');
        strPrivateKey.append("sCPbiwxiCntFOy/X3LCkVkewalkCgYEA5+MzqTGyr57Qj3KCcMxk+Ac6PbvETedI");
        strPrivateKey.append('\r');
        strPrivateKey.append("IfznhBm2y6MuRJsdb0p+y3P8+IdOTosWQAzcKpqsvhYPn7s0mB16yAyU8H3DqAMu");
        strPrivateKey.append('\r');
        strPrivateKey.append("c92ROmXbnW7/09pxE5UbHcadSXGaQZVz+Ap9QhJIwZuB/olc/tPAhjvxXCvf9QF+");
        strPrivateKey.append('\r');
        strPrivateKey.append("IBKTBpjud/8CgYAO+/ndfG621M6wpIMxowqJLT3Sp4WoZYPmMVrExEDc4q4zcmrs");
        strPrivateKey.append('\r');
        strPrivateKey.append("tqCup0KB/W23glhrLFK+CVH6uXCveQRFlNfQAU+XD0TdQY1qfQYEScgsQ91guP4n");
        strPrivateKey.append('\r');
        strPrivateKey.append("NjnugYbhY55r+H6Cy2ONzXo92jQOj+E9qSbZLCg/kBYW70jquvNW5Hm6IQKBgQCs");
        strPrivateKey.append('\r');
        strPrivateKey.append("28to9ukyzXq/VCc0mskxs4GQ/2WohR5aZ8LV0K1ZQ/17mv3oNmoqk/4h7gtLtZcS");
        strPrivateKey.append('\r');
        strPrivateKey.append("jAObps3arWtcMRtVwbQDaI2mcLnnhueb67EVDVUXGOWQMahVZrNeEO6zDwJknVpj");
        strPrivateKey.append('\r');
        strPrivateKey.append("rr4NAMBHwvq2mgM+2u8LoaechABhDYnNssrzAhHSVQKBgQDDCVsntYmFeAI/TV4f");
        strPrivateKey.append('\r');
        strPrivateKey.append("pMyS3OFGBHs2UqVfssdcorR7Og14KdBzgC+tfYHMIWERtJN+fZjQ6t3bmxeLHG2V");
        strPrivateKey.append('\r');
        strPrivateKey.append("EIZ3QQWRnYcEuxGaFMsmcukMnt3oCk041poIMlqsOEc9+P0LpXmCE1cmTkkFkXLT");
        strPrivateKey.append('\r');
        strPrivateKey.append("BJ22Am5wBqzNjsPVek8u5MYHIw==");
        strPrivateKey.append('\r');
        return strPrivateKey.toString();
    }

    private static String getBankPublicKey() {
        StringBuffer strPublicKey = new StringBuffer();
        strPublicKey.append("MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEArIEJRYUYtYUFIVXxRkw3");
        strPublicKey.append('\r');
        strPublicKey.append("vw4Bt8xqwySmIG9Iou1S0+i7xXzchpIR/kid1L9kJJGfk6bd6451RU+eEcaeI08B");
        strPublicKey.append('\r');
        strPublicKey.append("OutsVidca051/PnkTRZl7S+Tpwau6TSUFfAMFNEYwFkuvmqGbm/EqyN0Mb0wZz7s");
        strPublicKey.append('\r');
        strPublicKey.append("vmJIE6iKhgv+rGVkmXaAQQsu1f5erXKM4M6ukWSwIuStOGjgn33PK7s4TUwQK9Ay");
        strPublicKey.append('\r');
        strPublicKey.append("q0QgJyT3j/WRjy8nB/D8plnitl/SI5VR7xsMkpy2giovYtp4LvFV5QOFSYobqiP2");
        strPublicKey.append('\r');
        strPublicKey.append("Te0a93ey7H2IAXOBveTCihr+d3jaAh2Qdj+Lfu7UaqtdpTjR0zN707G7HPVTRXLz");
        strPublicKey.append('\r');
        strPublicKey.append("bQIDAQAB");
        strPublicKey.append('\r');
        return strPublicKey.toString();
    }

    public static String out_serial_no = UUID.randomUUID().toString().replace("-", "");
    public static String callback_url  = "http://www.baidu.com";
}
