package com.my.common.utils;

import com.my.common.bean.annotation.Config;
import com.my.common.constants.ProjectConstants;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.Properties;

/**
 * Created by conan on 2017/5/23.
 */
public class CustomPropertyPlaceholderConfigurer extends PropertyPlaceholderConfigurer{
    private Properties props;
    @Override
    protected void processProperties(
            ConfigurableListableBeanFactory beanFactory, final Properties props)
            throws BeansException {
        super.processProperties(beanFactory, props);
        this.props = props;
        ReflectionUtils.doWithFields(ProjectConstants.class, new ReflectionUtils.FieldCallback() {
            @Override
            public void doWith(Field field) throws IllegalArgumentException, IllegalAccessException {
                Config cfg = field.getAnnotation(Config.class);
                if (cfg == null) {
                    return;
                }
                String key = cfg.value().length() <= 0 ? field.getName() : cfg.value();
                if (StringUtils.isBlank(key)) {
                    return;
                }
                Object value = props.getProperty(key);
                if (value == null) {
                    return;
                }
                field.setAccessible(true);
                Type type = field.getGenericType();
                if (type == Integer.TYPE) {
                    field.setInt(null, Integer.parseInt(value.toString()));
                } else if (type == Boolean.TYPE) {
                    field.setBoolean(null, Boolean.parseBoolean(value.toString()));
                } else{
                    field.set(null, value);
                }
            }
        });
    }

    public Object getProperty(String key) {
        return props.get(key);
    }
}
