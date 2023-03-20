package top.hopestation.springframework.beans.factory.support;

import top.hopestation.springframework.beans.BeansException;
import top.hopestation.springframework.beans.ConfigurableListableBeanFactory;
import top.hopestation.springframework.beans.factory.config.BeanDefinition;

import java.util.HashMap;
import java.util.Map;

/**
 * IOC核心类
 * 功能：根据 BeanDefinition 生产 Bean 并放入一级缓存 SingletonObjects
 */
public class DefaultListableBeanFactory extends AbstractAutowireCapableBeanFactory implements BeanDefinitionRegistry ,ConfigurableListableBeanFactory{


    private final Map<String, BeanDefinition> beanDefinitionMap = new HashMap<>();

    @Override
    public void registerBeanDefinition(String beanName, BeanDefinition beanDefinition) {
        beanDefinitionMap.put(beanName, beanDefinition);
     }

    @Override
    public boolean containsBeanDefinition(String beanName) {
        return beanDefinitionMap.containsKey(beanName);
    }

    @Override
    public BeanDefinition getBeanDefinition(String beanName) throws BeansException {
        BeanDefinition beanDefinition = beanDefinitionMap.get(beanName);
        if (beanDefinition == null) {
            throw new BeansException("No bean named '" + beanName + "' is defined");
        }
        return beanDefinition;
    }

    @Override
    public void preInstantiateSingletons() throws BeansException {

    }

    @Override
    public <T> Map<String, T> getBeansOfType(Class<T> type) throws BeansException {
        HashMap<String, T> result = new HashMap<>();
        beanDefinitionMap.forEach((beanName,beanDefinition)->{
            Class beanClass = beanDefinition.getBeanClass();
            if(type.isAssignableFrom(beanClass)){
                result.put(beanName,(T)getBean(beanName));
            }
        });
        return result;
    }

    @Override
    public String[] getBeanDefinitionNames() {
        return new String[0];
    }
}
