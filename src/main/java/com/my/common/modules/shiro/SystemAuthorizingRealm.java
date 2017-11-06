package com.my.common.modules.shiro;

import com.my.common.handler.SpringContextHolder;
import com.my.common.utils.Encodes;
import com.my.modules.backstagemanagement.sys.bean.SysUserBean;
import com.my.modules.backstagemanagement.sys.service.SystemService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import java.io.Serializable;

/**
 * Created by lenovo on 2017/8/24.
 */
public class SystemAuthorizingRealm extends AuthorizingRealm{

    private SystemService systemService;

    /**
     * 认证回调函数，登录时调用
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken)authcToken;
        //校验用户名密码
        SysUserBean user = getSystemService().getUserByLoginName(token.getUsername());
        if(user != null){
            byte[] salt = Encodes.decodeHex(user.getPassword().substring(0,16));
            return new SimpleAuthenticationInfo(new Principal(user),
                    user.getPassword().substring(0,16), ByteSource.Util.bytes(salt), getName());
        }else{
            return null;
        }
    }

    /**
     * 获取系统业务对象
     */
    public SystemService getSystemService() {
        if (systemService == null) {
            systemService = SpringContextHolder.getBean(SystemService.class);
        }
        return systemService;
    }

    /**
     * 授权用户信息
     */
    public static class Principal implements Serializable {

        private static final long serialVersionUID = 1L;

        private String id; // 编号
        private String username; // 登录名
        private String name; // 姓名

        public Principal(SysUserBean user) {
            this.id = user.getId();
            this.username = user.getUsername();
            this.name = user.getName();
        }

        public String getId() {
            return id;
        }

        public String getUsername() {
            return username;
        }

        public String getName() {
            return name;
        }

        @Override
        public String toString() {
            return id;
        }

    }
}
