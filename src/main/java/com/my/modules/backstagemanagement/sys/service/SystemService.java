package com.my.modules.backstagemanagement.sys.service;

import com.my.common.utils.Digests;
import com.my.common.utils.Encodes;
import com.my.common.utils.UserUtils;
import com.my.modules.backstagemanagement.sys.bean.SysUserBean;
import com.my.modules.backstagemanagement.sys.dao.ISysUserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * Created by conan on 2017/5/24.
 */
@Service
@Transactional(readOnly = true)
public class SystemService {
    public static final String HASH_ALGORITHM = "SHA-1";
    public static final int HASH_INTERATIONS = 1024;
    public static final int SALT_SIZE = 8;

    @Autowired
    private ISysUserDao userDao;

    /**
     * 生成安全的密码，生成随机的16位salt并经过1024次 sha-1 hash
     */
    public static String entryptPassword(String plainPassword) {
        byte[] salt = Digests.generateSalt(SALT_SIZE);
        byte[] hashPassword = Digests.sha1(plainPassword.getBytes(), salt, HASH_INTERATIONS);
        return Encodes.encodeHex(salt) + Encodes.encodeHex(hashPassword);
    }

    /**
     * 根据登录名获取用户
     *
     * @param loginName
     * @return
     */
    public SysUserBean getUserByLoginName(String loginName) {
        return UserUtils.getByLoginName(loginName);
    }

    @Transactional(readOnly = false)
    public void updateUserLoginInfo(SysUserBean user) {
        // 更新本次登录信息
        user.setLoginIp(UserUtils.getSession().getHost());
        userDao.updateLoginInfo(UserUtils.getSession().getHost(), new Date(), user.getId());
    }
}
