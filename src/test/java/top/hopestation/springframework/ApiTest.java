package top.hopestation.springframework;

import org.junit.Test;
import top.hopestation.springframework.bean.UserService;
import top.hopestation.springframework.beans.factory.config.BeanDefinition;
import top.hopestation.springframework.beans.factory.support.DefaultListableBeanFactory;

public class ApiTest {


    @Test
    public void test() {

        DefaultListableBeanFactory defaultListableBeanFactory = new DefaultListableBeanFactory();

        BeanDefinition beanDefinition = new BeanDefinition(UserService.class);
        defaultListableBeanFactory.registerBeanDefinition("userService", beanDefinition);

        UserService userService = (UserService) defaultListableBeanFactory.getBean("userService","小明");
        userService.getUserInfo();

        UserService userService2 = (UserService) defaultListableBeanFactory.getSingleton("userService");
        userService2.getUserInfo();

    }

//    @Test
//    public void test02(){
//
//        DefaultListableBeanFactory defaultListableBeanFactory = new DefaultListableBeanFactory();
//
//        BeanDefinition beanDefinition = new BeanDefinition(UserService.class);
//        defaultListableBeanFactory.registerBeanDefinition("userService",beanDefinition);
//
//        UserService userService = (UserService)defaultListableBeanFactory.getBean("userService");
//        userService.getUserInfo();
//
//        UserService userService2 = (UserService)defaultListableBeanFactory.getSingleton("userService");
//        userService2.getUserInfo();
//
//
//    }

//    @Test
//    public void test01(){
//
//        BeanFactory beanFactory = new BeanFactory();
//
//        beanFactory.registerBeanDefinition("userService",new BeanDefinition(new UserService()));
//
//        UserService userService = (UserService)beanFactory.getBean("userService");
//
//        userService.getUserInfo();
//
//    }
}

