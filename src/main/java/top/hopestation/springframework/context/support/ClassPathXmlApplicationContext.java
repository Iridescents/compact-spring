package top.hopestation.springframework.context.support;

import top.hopestation.springframework.beans.BeansException;

/**
 * 根据XML路径，初始化Bean容器
 */
public class ClassPathXmlApplicationContext extends AbstractXmlApplicationContext{


    private String[] configLocations;

    public ClassPathXmlApplicationContext(){}

    public ClassPathXmlApplicationContext(String configLocations) throws BeansException {
        this(new String[]{configLocations});
    }


    public ClassPathXmlApplicationContext(String[] configLocations) {
        // 构造函数直接初始化容器
        this.configLocations = configLocations;
        // 类实例化时，直接调用该方法
        refresh();
    }

    @Override
    protected String[] getConfigLocations(){
        return  configLocations;
    }
 }
