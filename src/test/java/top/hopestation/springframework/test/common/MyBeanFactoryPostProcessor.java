package top.hopestation.springframework.test.common;

import top.hopestation.springframework.beans.BeansException;
import top.hopestation.springframework.beans.ConfigurableListableBeanFactory;
import top.hopestation.springframework.beans.PropertyValue;
import top.hopestation.springframework.beans.PropertyValues;
import top.hopestation.springframework.beans.factory.config.BeanDefinition;
import top.hopestation.springframework.beans.factory.config.BeanFactoryPostProcessor;

public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        BeanDefinition beanDefinition = beanFactory.getBeanDefinition("userService");
        PropertyValues propertyValues = beanDefinition.getPropertyValues();
        propertyValues.addPropertyValue(new PropertyValue("company","改为：字节跳动"));
    }
}
