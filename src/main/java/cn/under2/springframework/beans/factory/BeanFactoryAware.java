package cn.under2.springframework.beans.factory;

import cn.under2.springframework.beans.BeansException;

public interface BeanFactoryAware extends Aware{

    void setBeanFactory(BeanFactory beanFactory) throws BeansException;

}
