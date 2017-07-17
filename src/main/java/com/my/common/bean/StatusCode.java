package com.my.common.bean;

import com.my.common.bean.annotation.CodeAnnot;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by conan on 2017/5/24.
 */
public enum StatusCode {
    @CodeAnnot("服务器正在维护") SERVER_ERROR(1),
    @CodeAnnot("余额不足")MONEY_NOT_ENOUGH(2),
    @CodeAnnot("参数异常")VALIDATION_FAILED(3),
    @CodeAnnot("密码不正确")PASSWORD_ERROR(4),
    @CodeAnnot("账号不存在")ACCOUNT_NO_EXIST(5),
    @CodeAnnot("验证码不正确")VALIDATE_CODE_ERROR(6),
    @CodeAnnot("手机号已存在")PHONE_EXIST(7),
    @CodeAnnot("用户已被查封")USER_CLOSE(8),
    @CodeAnnot("验证码发送失败")SEND_SMS_ERROR(9),

    @CodeAnnot("用户不存在")USER_NOT_EXIST(10),
    @CodeAnnot("积分不足") INTEGRAL_NOT_ENOUGH(11),
    @CodeAnnot("优惠券已失效") COUPON_ERROR(12),
    @CodeAnnot("无效商品") PRODUCT_ERROR(13),
    @CodeAnnot("无法配送") NOT_AGENT(14),
    @CodeAnnot("优惠券不匹配") COUPON_NOT_FOUND_PRODUCT(15),
    @CodeAnnot("产品不存在")PRODUCTS_NOT_EXIST(16),
    @CodeAnnot("订单不存在")ORDER_NOT_FOUND(17),
    @CodeAnnot("您已申请退货")BACK_EXIST(18),
    @CodeAnnot("退货不存在")BACK_NO_EXIST(19),

    @CodeAnnot("用户注册微信生成二维码失败")REG_QRCODE_WEI_XIN_CREATE(20),
    @CodeAnnot("未找到医生")NOT_FIND_BY_QRCODEURL(21),
    @CodeAnnot("评论不存在")COMMENTS_NOT_FOUND(22),
    @CodeAnnot("商品库存不足") NO_STOCK_NUM(23),
    @CodeAnnot("debug模式无法操作") SERVER_DEBUG_ERROR(24),
    @CodeAnnot("产品列表为空") PRODUCT_EMPTY(25),
    @CodeAnnot("优惠券库存不足")COUPON_NOT_EXIST(26),
            ;



    private static final Map<String, String> hMap = new HashMap<>();

    static {
        Field[] fields = StatusCode.class.getFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(CodeAnnot.class)) {
                hMap.put(field.getName(), field.getAnnotation(CodeAnnot.class).value());
            }
        }
    }

    private final int value;

    // 构造器默认也只能是private, 从而保证构造函数只能在内部使用
    StatusCode(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public String getDescription() {
        return hMap.get(this.toString());
    }
}
