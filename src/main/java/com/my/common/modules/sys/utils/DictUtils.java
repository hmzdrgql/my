package com.my.common.modules.sys.utils;

import com.alibaba.fastjson.TypeReference;
import com.my.common.handler.SpringContextHolder;
import com.my.common.modules.cache.CacheFacade;
import com.my.common.modules.sys.model.Dict;
import com.my.common.modules.sys.service.DictService;
import org.apache.commons.lang.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by conan on 2017/5/24.
 */
public class DictUtils {

    public static final String CACHE_DICT_MAP = "dictMap";
    private static DictService dictService = SpringContextHolder.getBean(DictService.class);

    /**
     * 类型，值查询标题
     *
     * @param value        值
     * @param type         类型
     * @param defaultValue 默认值
     */
    public static String getDictLabel(String value, String type, String defaultValue) {
        if (StringUtils.isNotBlank(type) && StringUtils.isNotBlank(value)) {
            for (Dict dict : getDictList(type)) {
                if (type.equals(dict.getType()) && value.equals(dict.getValue())) {
                    return dict.getLabel();
                }
            }
        }
        return defaultValue;
    }

    /**
     * 标题，类型查询值
     *
     * @param label        标题
     * @param type         类型
     * @param defaultLabel
     */
    public static String getDictValue(String label, String type, String defaultLabel) {
        if (StringUtils.isNotBlank(type) && StringUtils.isNotBlank(label)) {
            for (Dict dict : getDictList(type)) {
                if (type.equals(dict.getType()) && label.equals(dict.getLabel())) {
                    return dict.getValue();
                }
            }
        }
        return defaultLabel;
    }

    /**
     * 标题，类型查询值
     *
     * @param label 标题
     * @param type  类型
     */
    public static Dict getDict(String label, String type) {
        if (StringUtils.isNotBlank(type) && StringUtils.isNotBlank(label)) {
            for (Dict dict : getDictList(type)) {
                if (type.equals(dict.getType()) && label.equals(dict.getLabel())) {
                    return dict;
                }
            }
        }
        return null;
    }

    /**
     * 类型查询字典列表
     *
     * @param type 类型
     */
    public static List<Dict> getDictList(String type) {
        Map<String, List<Dict>> dictMap = CacheFacade.getObject(CACHE_DICT_MAP, new TypeReference<Map<String, List<Dict>>>() {
        });
        if (dictMap == null) {
            dictMap = new HashMap<>();
            Dict d = new Dict();
            for (Dict dict : dictService.findList(d)) {
                List<Dict> dictList = dictMap.get(dict.getType());
                if (dictList != null) {
                    dictList.add(dict);
                } else {
                    List<Dict> list = new ArrayList<>();
                    list.add(dict);
                    dictMap.put(dict.getType(), list);
                }
            }
            CacheFacade.set(CACHE_DICT_MAP, dictMap, 0);
        }
        List<Dict> dictList = dictMap.get(type);
        if (dictList == null) {
            dictList = new ArrayList<>();
        }
        return dictList;
    }

    /**
     * 获取lables
     *
     * @param type
     */
    public static List<String> getDicLabelList(String type) {
        List<Dict> dictList = DictUtils.getDictList(type);
        List<String> dictStrList = new ArrayList<String>();
        for (Dict dict : dictList) {
            dictStrList.add(dict.getLabel());
        }
        return dictStrList;
    }
}
