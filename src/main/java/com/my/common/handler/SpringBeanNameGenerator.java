package com.my.common.handler;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationBeanNameGenerator;

/**
 * Created by conan on 2017/5/24.
 */
public class SpringBeanNameGenerator extends AnnotationBeanNameGenerator{
    @Override
    protected String buildDefaultBeanName(BeanDefinition definition) {
        return definition.getBeanClassName();
    }
}
