package top.hopestation.springframework.context;

import top.hopestation.springframework.beans.BeansException;

public interface ConfigurableApplicationContext extends  ApplicationContext{

    /**
     * 刷新容器
     * @throws BeansException
     */
    void refresh() throws BeansException;
}
