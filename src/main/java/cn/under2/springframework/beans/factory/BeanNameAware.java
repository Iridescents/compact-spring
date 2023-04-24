package cn.under2.springframework.beans.factory;

import cn.under2.springframework.beans.BeansException;

public interface BeanNameAware extends Aware{

    void setBeanName(String name) throws BeansException;

}
    