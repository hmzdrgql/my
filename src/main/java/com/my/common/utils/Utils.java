package com.my.common.utils;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Hashtable;
import java.util.Random;
import java.util.UUID;

/**
 * Created by conan on 2017/5/24.
 */
public class Utils {
    public static final int MINUTE = 60;
    public static final int HOUR = MINUTE * 60;

    public static String uuid() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    /**
     * 根据手机号生成用户名
     *
     * @param phone
     * @return
     */
    public static String generateNameByPhone(String phone) {
        return phone.substring(0, 3) + "****" + phone.substring(7);
    }

    /**
     * 生成短信验证码
     *
     * @return
     */
    public static String generateSmsCode() {
        Random random = new Random();
        String verificationCode = "";
        for (int i = 0; i < 4; i++) {
            verificationCode += random.nextInt(10);
        }
        return verificationCode;
    }

    /**
     * 邀请码生成工具
     */
    public static class InvitationCodeUtils {

        /**
         * 自定义进制(0,1没有加入,容易与o,l混淆)
         */
        private static final char[] r = new char[]{'Q', 'w', 'E', '8', 'a', 'S', '2', 'd', 'Z', 'x', '9', 'c', '7', 'p', 'O', '5', 'i', 'K', '3', 'm', 'j', 'U', 'f', 'r', '4', 'V', 'y', 'L', 't', 'N', '6', 'b', 'g', 'H'};
        /**
         * 自动补全组(不能与自定义进制有重复)
         */
        private static final char[] b = new char[]{'q', 'W', 'e', 'A', 's', 'D', 'z', 'X', 'C', 'P', 'o', 'I', 'k', 'M', 'J', 'u', 'F', 'R', 'v', 'Y', 'T', 'n', 'B', 'G', 'h'};
        /**
         * 进制长度
         */
        private static final int l = r.length;
        /**
         * 序列最小长度
         */
        private static final int s = 6;

        /**
         * 根据id或手机号生成六位随机码
         *
         * @param num
         * @return 随机码
         */
        public static String generateCode(long num) {
            char[] buf = new char[32];
            int charPos = 32;

            while ((num / l) > 0) {
                buf[--charPos] = r[(int) (num % l)];
                num /= l;
            }
            buf[--charPos] = r[(int) (num % l)];
            String str = new String(buf, charPos, (32 - charPos));
            //不够长度的自动随机补全
            if (str.length() < s) {
                StringBuffer sb = new StringBuffer();
                Random rnd = new Random();
                for (int i = 0; i < s - str.length(); i++) {
                    sb.append(b[rnd.nextInt(b.length - 1)]);
                }
                str += sb.toString();
            }
            return str;
        }
    }

    public static Class getSuperClassGenericType(final Class clazz, final int index) {
        //返回表示此 Class 所表示的实体（类、接口、基本类型或 void）的直接超类的 Type。
        Type genType = clazz.getGenericSuperclass();
        if (!(genType instanceof ParameterizedType)) {
            return Object.class;
        }
        //返回表示此类型实际类型参数的 Type 对象的数组。
        Type[] params = ((ParameterizedType) genType).getActualTypeArguments();
        if (index >= params.length || index < 0) {
            return Object.class;
        }
        if (!(params[index] instanceof Class)) {
            return Object.class;
        }
        return (Class) params[index];
    }

    public static String md5(String str) {
        return DigestUtils.md5Hex(str);
    }

    public static String sha(String str) {
        return DigestUtils.sha1Hex(str);
    }

    /**
     * 生成二维码
     *
     * @return
     */
    public static byte[] generateOrCode(String text) {
        int width = 500;
        int height = 500;
        Hashtable hints = new Hashtable();
        String format = "png";
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
        try {
            BitMatrix bitMatrix = new MultiFormatWriter().encode(text, BarcodeFormat.QR_CODE, width, height, hints);
            MatrixToImageWriter.writeToStream(bitMatrix, format, byteArrayOutputStream);
        } catch (WriterException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return byteArrayOutputStream.toByteArray();
    }

    /**
     * 获得classpath下的文件流
     *
     * @param path
     * @return
     */
    public static InputStream getClassPathFileStream(String path) {
        Resource resource = new ClassPathResource(path);
        if (resource.isReadable()) {
            //每次都会打开一个新的流
            try {
                return resource.getInputStream();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }


    /**
     * 获取ip地址,防止集群、代理
     *
     * @param request
     * @return ip
     */
    public static String getAddress(HttpServletRequest request) {
        return request.getRemoteAddr();
    }

    public static String getCookieValue(HttpServletRequest request, String cookieName) {
        Cookie[] cookies = request.getCookies();
        if (null != cookies) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals(cookieName)) {
                    return cookie.getValue();
                }
            }
        }
        return null;
    }
}
