package com.my.common.modules.sys.service;

import com.my.common.modules.sys.dao.DictDao;
import com.my.common.modules.sys.model.Dict;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by conan on 2017/5/24.
 */
@Service
public class DictService {
    @Autowired
    private DictDao dictDao;

    /**
     * 查询字典
     *
     * @param d
     * @return
     */
    public List<Dict> findList(Dict d) {
        return dictDao.findList(d);
    }
}
