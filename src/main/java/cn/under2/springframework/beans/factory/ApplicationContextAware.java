package cn.under2.springframework.beans.factory;

import cn.under2.springframework.beans.BeansException;
import cn.under2.springframework.context.ApplicationContext;

public interface ApplicationContextAware extends Aware{

    void setApplicationContext(ApplicationContext applicationContext) throws BeansException;

}
    