package top.hopestation.springframework.beans;

import top.hopestation.springframework.beans.factory.ListableBeanFactory;
import top.hopestation.springframework.beans.factory.config.AutowireCapableBeanFactory;
import top.hopestation.springframework.beans.factory.config.BeanDefinition;
import top.hopestation.springframework.beans.factory.config.ConfigurableBeanFactory;

import java.beans.Beans;

public interface ConfigurableListableBeanFactory extends ListableBeanFactory, AutowireCapableBeanFactory, ConfigurableBeanFactory {

    BeanDefinition getBeanDefinition(String beanName) throws BeansException;

    void preInstantiateSingletons() throws BeansException;

}
