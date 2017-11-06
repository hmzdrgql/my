package com.my.common.utils;

import com.my.common.handler.SpringContextHolder;
import com.my.modules.backstagemanagement.sys.bean.SysUserBean;
import com.my.modules.backstagemanagement.sys.dao.ISysUserDao;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.UnavailableSecurityManagerException;
import org.apache.shiro.session.InvalidSessionException;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;

import java.util.List;

//import com.my.common.modules.sys.bean.SysMenuBean;
//import com.my.common.modules.sys.bean.SysRoleBean;
//import com.my.common.modules.sys.dao.ISysMenuDao;
//import com.my.common.modules.sys.dao.ISysRoleDao;

/**
 * Created by conan on 2017/5/24.
 */
public class UserUtils {
    public static final String USER_CACHE = "userCache";
    public static final String USER_CACHE_ID_ = "id_";
    public static final String USER_CACHE_LOGIN_NAME_ = "ln";
    public static final String USER_CACHE_LIST_BY_OFFICE_ID_ = "oid_";
    public static final String CACHE_ROLE_LIST = "roleList";
    public static final String CACHE_MENU_LIST = "menuList";
    private static ISysUserDao userDao = SpringContextHolder.getBean(ISysUserDao.class);
//    private static ISysRoleDao roleDao = SpringContextHolder.getBean(ISysRoleDao.class);
//    private static ISysMenuDao menuDao = SpringContextHolder.getBean(ISysMenuDao.class);

    /**
     * 根据ID获取用户
     *
     * @param id
     * @return 取不到返回null
     */
    public static SysUserBean get(String id) {
        SysUserBean user = (SysUserBean) LocalCacheUtils.get(USER_CACHE, USER_CACHE_ID_ + id);
        if (user == null) {
            user = userDao.getById(id);
            if (user == null) {
                return null;
            }
            //user.setRoleList(roleDao.findList(new SysRoleBean(user)));
            LocalCacheUtils.put(USER_CACHE, USER_CACHE_ID_ + user.getId(), user);
            LocalCacheUtils.put(USER_CACHE, USER_CACHE_LOGIN_NAME_ + user.getUsername(), user);
        }
        return user;
    }

    /**
     * 根据登录名获取用户
     *
     * @param loginName
     * @return 取不到返回null
     */
    public static SysUserBean getByLoginName(String loginName) {
        SysUserBean user = (SysUserBean) LocalCacheUtils.get(USER_CACHE, USER_CACHE_LOGIN_NAME_ + loginName);
        if (user == null) {
            user = userDao.getByLoginName(loginName);
            if (user == null) {
                return null;
            }
            //user.setRoleList(roleDao.findList(new SysRoleBean(user)));
            LocalCacheUtils.put(USER_CACHE, USER_CACHE_ID_ + user.getId(), user);
            LocalCacheUtils.put(USER_CACHE, USER_CACHE_LOGIN_NAME_ + user.getUsername(), user);
        }
        return user;
    }


    /**
     * 清除指定用户缓存
     *
     * @param user
     */
    public static void clearCache(SysUserBean user) {
        LocalCacheUtils.remove(USER_CACHE, USER_CACHE_ID_ + user.getId());
        //LocalCacheUtils.remove(USER_CACHE, USER_CACHE_LOGIN_NAME_ + user.getLoginName());
        //LocalCacheUtils.remove(USER_CACHE, USER_CACHE_LOGIN_NAME_ + user.getOldLoginName());
    }


    /**
     * 获取当前用户角色列表
     *
     * @return
     */
//    public static List<SysRoleBean> getRoleList() {
//        List<SysRoleBean> roleList = (List<SysRoleBean>) getCache(CACHE_ROLE_LIST);
//        if (roleList == null) {
//            roleList = roleDao.findList(new SysRoleBean());
//            putCache(CACHE_ROLE_LIST, roleList);
//        }
//        return roleList;
//    }

    /**
     * 获取当前用户授权菜单
     *
     * @return
     */
//    public static List<SysMenuBean> getMenuList() {
//        List<SysMenuBean> menuList = (List<SysMenuBean>) getCache(CACHE_MENU_LIST);
//        if (menuList == null) {
//            SysMenuBean m = new SysMenuBean();
//            SysUserBean user = getUser();
//            if (user.getRoleIdList().contains("1")) {
//                menuList = menuDao.queryList(m);
//            } else {
//                m.setUserId(user.getId());
//                menuList = menuDao.findByUserId(m);
//            }
//
//            putCache(CACHE_MENU_LIST, menuList);
//        }
//        return menuList;
//    }

    /**
     * 获取授权主要对象
     */
    public static Subject getSubject() {
        return SecurityUtils.getSubject();
    }


    public static Session getSession() {
        try {
            Subject subject = SecurityUtils.getSubject();
            Session session = subject.getSession(false);
            if (session == null) {
                session = subject.getSession();
            }
            if (session != null) {
                return session;
            }
        } catch (InvalidSessionException e) {

        }
        return null;
    }


    public static Object getCache(String key) {
        return getCache(key, null);
    }

    public static Object getCache(String key, Object defaultValue) {
        Object obj = getSession().getAttribute(key);
        return obj == null ? defaultValue : obj;
    }

    public static void putCache(String key, Object value) {
        getSession().setAttribute(key, value);
    }

    public static void removeCache(String key) {
        getSession().removeAttribute(key);
    }

    /**
     * 判断当前用户是否拥有超级管理员权限
     *
     * @return
     */
//    public static boolean curUserHasSuperRole() {
//        boolean superRole = false;
//        SysUserBean sysUserBean = UserUtils.getUser();
//        List<SysRoleBean> roleList = sysUserBean.getRoleList();
//        for (SysRoleBean role : roleList) {
//            if ("1".equals(role.getId())) {
//                superRole = true;
//                break;
//            }
//        }
//        return superRole;
//    }
}
