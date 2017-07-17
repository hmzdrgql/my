package com.my.common.modules.sys.service;

import com.my.common.constants.Constants;
import com.my.common.modules.cache.CacheFacade;
import com.my.common.utils.Utils;

/**
 * Created by conan on 2017/5/24.
 */
public class TokenService {

    /**
     * 处理token
     *
     * @param terminal
     * @param userId
     * @return
     */
    public static String handleToken(String terminal, String userId) {
        if (terminal == null) {
            return null;
        }
        String token = Utils.md5(userId + System.currentTimeMillis());
        switch (terminal) {
            case Constants.Terminal.TERMINAL_ANDROID:
            case Constants.Terminal.TERMINAL_IOS:
            case Constants.Terminal.TERMINAL_WAP:
                CacheFacade.set(userId + Constants.LoginAu.TOKEN_APP, token, 0);
                break;
        }
        return token;
    }

    /**
     * 删除token
     *
     * @param terminal
     * @param userId
     * @return
     */
    public static void removeToken(String terminal, String userId) {
        if (terminal == null) {
            return;
        }
        switch (terminal) {
            case Constants.Terminal.TERMINAL_ANDROID:
            case Constants.Terminal.TERMINAL_IOS:
            case Constants.Terminal.TERMINAL_WAP:
                CacheFacade.delete(userId + Constants.LoginAu.TOKEN_APP);
                break;
        }
    }

    /**
     * 获取token后缀
     *
     * @param terminal
     * @return
     */
    public static String getSuffix(String terminal) {
        String suffix = "";
        if (terminal != null) {
            switch (terminal) {
                case Constants.Terminal.TERMINAL_ANDROID:
                case Constants.Terminal.TERMINAL_IOS:
                case Constants.Terminal.TERMINAL_WAP:
                    suffix = Constants.LoginAu.TOKEN_APP;
                    break;
            }
        }
        return suffix;
    }
}
