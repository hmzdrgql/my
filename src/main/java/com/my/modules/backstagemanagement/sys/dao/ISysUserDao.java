package com.my.modules.backstagemanagement.sys.dao;

import com.my.common.base.BaseDao;
import com.my.common.bean.annotation.DataSource;
import com.my.modules.backstagemanagement.sys.bean.SysUserBean;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * Created by conan on 2017/5/24.
 */
@DataSource
public interface ISysUserDao extends BaseDao<SysUserBean> {
    /**
     * 根据登录名称查询用户
     *
     * @param loginName 登录名
     * @return
     */
    public SysUserBean getByLoginName(String loginName);

    /**
     * 更新登录信息，如：登录IP、登录时间
     *
     * @param loginIp   登录ip
     * @param loginDate 登录时间
     * @param id        用户id
     * @return
     */
    public int updateLoginInfo(@Param(value = "loginIp") String loginIp,
                               @Param(value = "loginDate") Date loginDate,
                               @Param(value = "id") String id);


    List<String> findSelectRoleByUserId(String id);

}
