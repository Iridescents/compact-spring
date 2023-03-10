package top.hopestation.springframework.beans.factory.support;

import top.hopestation.springframework.beans.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;

public interface InstantiationStrategy {

    Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor ctor,Object[] args);

}
