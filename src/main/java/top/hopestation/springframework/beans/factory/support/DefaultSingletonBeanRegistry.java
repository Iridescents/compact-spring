package top.hopestation.springframework.beans.factory.support;

import top.hopestation.springframework.beans.factory.config.SingletonBeanRegistry;

import java.util.HashMap;
import java.util.Map;

/**
 * 此类负责管理Bean注册表 ， 在此样例中也可以不实现SingletonBeanRegistry接口，直接写出get\add方法
 * SingletonBeanRegistry（- 在spring源码中，也有其他的实现类  ）
 *
 */
public class DefaultSingletonBeanRegistry implements SingletonBeanRegistry {

    private final Map<String, Object> singletonObjects = new HashMap<>();


    @Override
    public Object getSingleton(String beanName) {
        return singletonObjects.get(beanName);
    }

    protected void addSingleton(String beanName,Object singletonObject){
        singletonObjects.put(beanName,singletonObject);
    }

}
