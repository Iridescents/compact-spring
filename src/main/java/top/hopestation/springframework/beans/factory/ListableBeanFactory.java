package top.hopestation.springframework.beans.factory;

import top.hopestation.springframework.beans.BeansException;

import java.util.Map;

public interface ListableBeanFactory extends BeanFactory{

    /**
     * 按照类型返回Bean实例
     * @param type
     * @return
     * @param <T>
     * @throws BeansException
     */
    <T> Map<String,T>  getBeansOfType(Class<T> type) throws BeansException;

    /**
     * 返回注册表中所有Bean名称
     */
    String[] getBeanDefinitionNames();
}
