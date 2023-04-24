package cn.under2.springframework.context;

import cn.under2.springframework.beans.BeansException;

public interface ConfigurableApplicationContext extends  ApplicationContext{

    /**
     * 刷新容器
     * @throws BeansException
     */
    void refresh() throws BeansException;

    void registerShutdownHook();

    void close();
}
