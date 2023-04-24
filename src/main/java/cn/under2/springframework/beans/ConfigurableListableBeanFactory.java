package cn.under2.springframework.beans;

import cn.under2.springframework.beans.factory.ListableBeanFactory;
import cn.under2.springframework.beans.factory.config.AutowireCapableBeanFactory;
import cn.under2.springframework.beans.factory.config.BeanDefinition;
import cn.under2.springframework.beans.factory.config.ConfigurableBeanFactory;

public interface ConfigurableListableBeanFactory extends ListableBeanFactory, AutowireCapableBeanFactory, ConfigurableBeanFactory {

    BeanDefinition getBeanDefinition(String beanName) throws BeansException;

    void preInstantiateSingletons() throws BeansException;

}
