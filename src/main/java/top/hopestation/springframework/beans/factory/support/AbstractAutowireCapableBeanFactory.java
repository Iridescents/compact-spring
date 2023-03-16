package top.hopestation.springframework.beans.factory.support;

import cn.hutool.core.bean.BeanUtil;
import top.hopestation.springframework.beans.BeansException;
import top.hopestation.springframework.beans.PropertyValue;
import top.hopestation.springframework.beans.PropertyValues;
import top.hopestation.springframework.beans.factory.config.BeanDefinition;
import top.hopestation.springframework.beans.factory.config.BeanReference;

import java.lang.reflect.Constructor;

/**
 * 抽象有注入能力的Bean工厂
 * - 重写了创建Bean的方法
 */
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory {


    private InstantiationStrategy instantiationStrategy = new CglibSubclassingInstantiationStrategy();

    @Override
    protected Object createBean(String beanName, BeanDefinition beanDefinition, Object[] args) throws BeansException {
        Object bean;
        try {
            bean = createBeanInstance(beanDefinition, beanName, args);
            // 填充Bean的属性
            applyPropertyValue(beanName,bean,beanDefinition);
        }catch (Exception e){
            throw new BeansException("Instantiation of bean failed", e);
        }
        addSingleton(beanName, bean);
        return bean;
    }


    protected Object createBeanInstance(BeanDefinition beanDefinition, String beanName, Object[] args) {
        Constructor constructorToUse = null;
        Class<?> beanClass = beanDefinition.getBeanClass();
        Constructor<?>[] declaredConstructors = beanClass.getDeclaredConstructors();
        for (Constructor<?> ctor : declaredConstructors) {
            if (null != args && ctor.getParameterTypes().length == args.length) {
                constructorToUse = ctor;
                break;
            }
        }
        return getInstantiationStrategy().instantiate(beanDefinition, beanName, constructorToUse, args);
    }

    /**
     * 设置Bean的属性值
     * @param beanName
     * @param bean
     * @param beanDefinition
     */
    protected void applyPropertyValue(String beanName, Object bean, BeanDefinition beanDefinition) {
        try {
            PropertyValues propertyValues = beanDefinition.getPropertyValues();
            for (PropertyValue propertyValue : propertyValues.getPropertyValues()) {
                String name = propertyValue.getName();
                Object value = propertyValue.getValue();
                // 这里相当于自动注入，假如是引用类型则在容器中getBean。这个版本会产生循环依赖的问题
                if(value instanceof BeanReference){
                    BeanReference beanReference = (BeanReference) value;
                    value = getBean(beanReference.getBeanName());
                }
                BeanUtil.setFieldValue(bean,name,value);
            }
        }catch (Exception e){
           throw new  BeansException("Error setting property values: " + beanName);
        }
    }
    public InstantiationStrategy getInstantiationStrategy() {
        return instantiationStrategy;
    }

    public void setInstantiationStrategy(InstantiationStrategy instantiationStrategy) {
        this.instantiationStrategy = instantiationStrategy;
    }


}
