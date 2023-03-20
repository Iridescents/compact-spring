package top.hopestation.springframework.beans.factory.config;

import top.hopestation.springframework.beans.BeansException;

public interface BeanPostProcessor {

    /**
     * 在 Bean 对象执行初始化方法前，执行此方法
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    Object postProcessBeforeInitialization(Object bean,String beanName) throws BeansException;

    /**
     * 在 Bean 对象执行初始化方法后，执行此方法
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    Object postProcessAfterInitialization(Object bean,String beanName) throws BeansException;

}
