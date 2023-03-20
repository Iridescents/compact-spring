package top.hopestation.springframework.beans.factory.support;

import top.hopestation.springframework.beans.BeansException;
import top.hopestation.springframework.core.io.Resource;
import top.hopestation.springframework.core.io.ResourceLoader;

public interface BeanDefinitionReader {

    BeanDefinitionRegistry getRegistry();

    ResourceLoader getResourceLoader();

    void loadBeanDefinition(Resource resource) throws BeansException;

    void loadBeanDefinition(Resource... resource) throws BeansException;

    void loadBeanDefinition(String location) throws BeansException;

    void loadBeanDefinitions(String... locations) throws BeansException;

}
