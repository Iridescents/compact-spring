package cn.under2.springframework.beans.factory.support;

import cn.under2.springframework.beans.BeansException;
import cn.under2.springframework.beans.factory.FactoryBean;
import cn.under2.springframework.beans.factory.config.BeanDefinition;
import cn.under2.springframework.beans.factory.config.BeanPostProcessor;
import cn.under2.springframework.beans.factory.config.ConfigurableBeanFactory;
import cn.under2.springframework.util.ClassUtils;

import java.util.ArrayList;
import java.util.List;

/***
 * 抽象Bean工厂
 * - 继承 DefaultSingletonBeanRegistry ：具备了注册Bean的能力，存放在singletonObjects中
 * - 实现 BeanFactory ：有了获取bean的接口
 * - getBeanDefinition ：获取Bean定义
 * - createBean ：创造Bean
 *
 * 抽象类 AbstractBeanFactory 负责生产Bean
 * 继承的 普通类 DefaultSingletonBeanRegistry 负责管理单例Bean注册表
 * 这样分层的好处在于按功能解耦，一个类负责生产、一个类负责管理Bean实例
 *
 *
 */
public abstract class AbstractBeanFactory extends FactoryBeanRegistrySupport implements ConfigurableBeanFactory {

    /**
     * ClassLoader to resolve bean class names with, if necessary
     */
    private ClassLoader beanClassLoader = ClassUtils.getDefaultClassLoader();

    private final List<BeanPostProcessor> beanPostProcessors = new ArrayList<BeanPostProcessor>();


    @Override
    public Object getBean(String beanName) {
        return doGetBean(beanName, null);
    }

    @Override
    public Object getBean(String beanName, Object... args) {
        return doGetBean(beanName, args);
    }

    @Override
    public <T> T getBean(String beanName, Class<T> required) {
        return (T) getBean(beanName);
    }

    protected <T> T doGetBean(final String name, final Object[] args) {
        SecurityManager securityManager = System.getSecurityManager();
        Object sharedInstance = getSingleton(name);
        if (sharedInstance != null) {
            return (T) getObjectForBeanInstance(sharedInstance,name);
        }
        BeanDefinition beanDefinition = getBeanDefinition(name);
        Object bean = createBean(name, beanDefinition, args);
        return (T) getObjectForBeanInstance(bean, name);
    }



    protected abstract BeanDefinition getBeanDefinition(String beanName) throws BeansException;

    protected abstract Object createBean(String beanName, BeanDefinition beanDefinition, Object[] args) throws BeansException;

    @Override
    public void addBeanPostProcessor(BeanPostProcessor beanPostProcessor) {
        // TODO 放在list的尾部是为什么
        // Remove from old position, if any
        this.beanPostProcessors.remove(beanPostProcessor);
        // Add to end of list
        this.beanPostProcessors.add(beanPostProcessor);
    }

    public List<BeanPostProcessor> getBeanPostProcessors() {
        return beanPostProcessors;
    }

    public ClassLoader getBeanClassLoader() {
        return this.beanClassLoader;
    }

    private Object getObjectForBeanInstance(Object beanInstance, String beanName) {
        // 不是FactoryBean直接返回
        if (!(beanInstance instanceof FactoryBean)) {
            return beanInstance;
        }
        // 尝试从FactoryBean缓存拿
        Object object = getCachedObjectForFactoryBean(beanName);
        if (object == null) {
            getObjectFromFactoryBean((FactoryBean<?>) beanInstance, beanName);
        }
        return object;
    }

}
