package cn.under2.springframework.beans.factory.support;

import cn.under2.springframework.beans.BeansException;
import cn.under2.springframework.core.io.Resource;
import cn.under2.springframework.core.io.ResourceLoader;

public interface BeanDefinitionReader {

    BeanDefinitionRegistry getRegistry();

    ResourceLoader getResourceLoader();

    void loadBeanDefinition(Resource resource) throws BeansException;

    void loadBeanDefinition(Resource... resource) throws BeansException;

    void loadBeanDefinition(String location) throws BeansException;

    void loadBeanDefinitions(String... locations) throws BeansException;

}
