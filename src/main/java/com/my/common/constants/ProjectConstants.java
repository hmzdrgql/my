package com.my.common.constants;

import com.my.common.bean.annotation.Config;

/**
 * Created by conan on 2017/5/23.
 * 配置文件常量，spring启动时诸如之
 */
public class ProjectConstants {
    @Config("project_name")
    public static String PROJECT_NAME;
    // 阿里云缓存用户ID
    @Config("cache_ocs_uid")
    public static String CACHE_UID;
    // 阿里云缓存密码
    @Config("cache_ocs_pwd")
    public static String CACHE_PWD;
    // 阿里云缓存连接串
    @Config("cache_ocs_url")
    public static String CACHE_URL;
    //项目是否为debug模式
    @Config("project_debug")
    public static boolean PRO_DEBUG;
    //短信是否为debug模式
    @Config("sms_debug")
    public static boolean SMS_DEBUG;
    @Config("client_id")
    public static String IM_CLIENT_ID;
    @Config("client_secret")
    public static String IM_CLIENT_SECRET;
    @Config("org_name")
    public static String IM_ORG_NAME;
    @Config("app_name")
    public static String IM_APP_NAME;
    @Config("JPush_Secret")
    public static String PUSH_SECRET;
    @Config("JPush_Key")
    public static String PUSH_KEY;
    //OSS
    @Config("access_key_ID")
    public static String OSS_ID;
    @Config("access_key_secret")
    public static String OSS_SECRET;
    @Config("REGION_CN_HANGZHOU")
    public static String OSS_REGION_CN_HANGZHOU;
    @Config("STS_API_VERSION")
    public static String OSS_STS_API_VERSION;//当前 STS API 版本
    @Config("roleArn")
    public static String OSS_ROLE_ARN;//RoleArn 需要在 RAM 控制台上获取
    //短信模板
    @Config("SMS_REG")
    public static String SMS_REG;
    @Config("SMS_FORGET_PASSWORD")
    public static String SMS_FORGET_PASSWORD;
    @Config("SMS_CHANGE_PHONE")
    public static String SMS_CHANGE_PHONE;
    //短信开发者参数
    @Config("ACCOUNT_ID")
    public static String SMS_ACCOUNT_ID;
    @Config("TOKEN")
    public static String SMS_TOKEN;
    @Config("APP_ID")
    public static String SMS_APP_ID;
    @Config("wei_xin_token")
    public static String WE_XIN_TOKEN;
    @Config("wei_xin_app_id")
    public static String WE_XIN_APP_ID;
    @Config("wei_xin_secret")
    public static String WE_XIN_SECRET;
    @Config("oss_endpoint")
    public static String OSS_ENDPOINT;
    @Config("oss_bucket_name")
    public static String OSS_BUCKET_NAME;
    @Config("oss_access_key_id")
    public static String OSS_ACCESS_KEY_ID;
    @Config("oss_access_key_secret")
    public static String OSS_ACCESS_KEY_SECRET;
    @Config("oss_base_url")
    public static String OSS_BASE_URL;
    //支付宝签约合作者身份ID
    @Config("alipay_parener")
    public static String ALI_PARTNER;
    // 支付宝签约卖家支付宝账号
    @Config("alipay_seller_id")
    public static String ALI_SELLER_ID;
    // 支付宝移动端支付回调地址
    @Config("alipay_app_notify_url_pay")
    public static String ALI_APP_NOTIFY_URL_PAY;
    // 支付宝页面跳转同步通知页面
    @Config("alipay_return_url_pay")
    public static String ALI_RETURN_URL_PAY;
    // 支付宝商户私钥
    @Config("alipay_private_key")
    public static String ALI_PRIVATE_KEY;
    // 支付宝公钥,并不是通过工具生成的商户公钥
    @Config("alipay_public_key")
    public static String ALI_PUBLIC_KEY;
    //    微信支付
    @Config("wei_xin_pay_app_id")
    public static String WEI_XIN_PAY_APP_ID;
    @Config("wei_xin_pay_key")
    public static String WEI_XIN_PAY_KEY;
    @Config("wei_xin_pay_mch_id")
    public static String WEI_XIN_PAY_MCH_ID;
    @Config("wei_xin_pay_notify_url")
    public static String WEI_XIN_PAY_NOTIFY_URL;
    @Config("wei_xin_pay_url")
    public static String WEI_XIN_PAY_URL;
    @Config("wei_xin_pay_cert_path")
    public static String WEI_XIN_PAY_CERT_PATH;
    @Config("wei_xin_pay_cert_pwd")
    public static String WEI_XIN_PAY_CERT_PWD;
    //物流
    @Config("express_key")
    public static String EXPRESS_KEY;
    //微信公众号支付
    @Config("wei_xin_wap_pay_app_id")
    public static String WEI_XIN_WAP_PAY_APP_ID;
    @Config("wei_xin_wap_pay_mch_id")
    public static String WEI_XIN_WAP_PAY_MCH_ID;
    @Config("wei_xin_wap_pay_notify_url")
    public static String WEI_XIN_WAP_PAY_NOTIFY_URL;
    @Config("wei_xin_wap_pay_cert_path")
    public static String WEI_XIN_WAP_PAY_CERT_PATH;
    @Config("wei_xin_wap_pay_cert_pwd")
    public static String WEI_XIN_WAP_PAY_CERT_PWD;

}
