package com.my.common.constants;

/**
 * Created by conan on 2017/5/24.
 */
public interface Constants {
    int MINUTE = 60;
    int HOUR = MINUTE * 60;

    interface Http {
        String AUTHORIZATION = "Authorization";
    }

    interface IM {
        String TOKEN = "im_access_token";
//        //发送消息
//        String PUSH_MESSAGE = BASE_URL + "/{org_name}/{app_name}/messages";
//        //更新群组信息
//        String UPDATE_GROUP_INFO = BASE_URL + "/{org_name}/{app_name}/chatgroups/{group_id}";
    }

    interface WeiXin {
        String TOKEN = "weixin_access_token";
        String TICKET = "weixin_jsapi_ticket";
    }

    /**
     * 登录信息
     */
    interface LoginAu {
        String TOKEN_APP = "-app-token";
    }

    /**
     * 终端类型
     */
    interface Terminal {
        String TERMINAL_ANDROID = "1";
        String TERMINAL_IOS = "2";
        String TERMINAL_WAP = "3";
        String TERMINAL_NAME = "terminal";
    }

    /**
     * 验证码类型
     */
    interface ValidateCode {
        String CODE_REG = "1";//注册
        String CODE_FORGET_PWD = "2";//忘记密码
        String CODE_CHANGE_PHONE = "3";//更换手机号
        String CODE_KEY = "_sms_code_";
    }


    /**
     * 通知消息类型
     */
    interface NotificationMsgType {
        String EXPRESS = "1";//物流
        String SYSTEM = "2";//系统
        String TRANSACTION = "3";//交易
    }

    /**
     * 通知消息内容类型
     */
    interface MessageContentType {
        String NORMAL = "1";//普通
        String AUTH = "2";//认证详情
        String QUESTION = "3";//问诊
        String TRANSACTION = "4";//交易
        String EXPRESS = "5";//物流
    }

    /**
     * 通知消息目标类型
     */
    interface NotificationTargetType {
        String PERSON = "1";//个人
        String ALL = "2";//全部
    }

    interface OSS {
        String TOKEN = "oss_token";
    }

    interface Dict {
        String INTEGRAL_DISCOUNT_LABEL = "integral_discount";
        String INTEGRAL_DISCOUNT_TYPE = "integral";
        String RICE_SCALE_LABEL = "rice_scale";
        String RICE_TYPE = "rice";
    }

    interface Order {
        String ORDER_TYPE_NORMAL = "1";//普通订单
        String ORDER_TYPE_CHILDREN = "2";//拆分子订单
        String ORDER_TYPE_PARENT = "3";//拆分父订单
        String ORDER_STATUS_WAIT_PAY = "1";//待付款
        String ORDER_STATUS_WAIT_TRANSPORT = "2";//待发货
        String ORDER_STATUS_WAIT_RECEIPT = "3";//待收货
        String ORDER_STATUS_WAIT_COMMENT = "4";//待评价
        String ORDER_STATUS_BACKING = "5";//退货中
        String ORDER_STATUS_BACK_SUCCESS = "6";//退货成功
        String ORDER_STATUS_CANCEL = "7";//已关闭
        String ORDER_STATUS_FINISH = "8";//已完成
        String ORDER_STATUS_APPROVE = "9";//退货同意
        String PAY_TYPE_MONEY = "1";//余额支付
        String PAY_TYPE_ALI_PAY = "2";//支付宝支付
        String PAY_TYPE_WEI_XIN = "3";//微信支付
        String PAY_TYPE_WEI_XIN_WAP = "4";//微信公众号支付
        String BACK_WAIT_AGREE = "1";//退货待处理
        String BACK_AGENT_AGREE = "2";//退货经销商同意
        String BACK_MANAGER_AGREE = "3";//退货管理员同意
        String BACK_CONFIRM = "5";//退货确认
    }

    interface Integral {
        String INTEGRAL_TYPE_ADD = "1";
        String INTEGRAL_TYPE_SUBTRACT = "2";
    }

    interface Product {
        String PRODUCT_DISCOUNT_STATUS = "1";//普通订单
    }

    interface Coupon {
        String COUPON_STATUS_NORMAL = "0";//正常
        String COUPON_STATUS_USE = "1";//使用
    }

    interface Rice {
        String RICE_TYPE_GET = "1";//米粒流水收入类型
    }

    interface USER_TYPE {
        String COMMON = "1"; // 普通用户
        String DOCTOR = "2"; // 医生
    }

    public interface USER_STATUE {
        String VALID = "0"; // 有效
        String INVALID = "1"; // 无效
    }

    public interface MESSAGE_TARGET_USER_TYPE {
        String SINGLE = "1"; // 个人
        String ALL = "2"; // 全体
    }

    interface Pay {
        String PAY_TYPE_WEI_XIN = "1";
        String PAY_TYPE_ALI = "2";
        String PAY_TYPE_UNION = "3";
        String PAY_TYPE_WEI_XIN_WAP="4";
    }

    interface ThirdLogin {
        String TYPE_WEIXIN = "1";
    }

    interface DoctorUser {
        String BIND_TYPE_SACN = "2";
    }

    /**
     * 分享类型
     */
    interface Share {
        //商品
        String TYPE_GOODS = "1";
        // 二维码
        String TYPE_QRCODE = "2";
    }
    interface AliPay{
        // 调用的接口名，无需修改
        String service = "alipay.wap.create.direct.pay.by.user";
        // 支付类型 ，无需修改
        String payment_type = "1";
        // 字符编码格式 目前支持utf-8
        String input_charset = "utf-8";
        String notify_url = "";
        String return_url = "";
        String sign_type = "RSA";
    }
    interface Express{
        //物流
        String STATUS_WAIT = "0";
    }
}
