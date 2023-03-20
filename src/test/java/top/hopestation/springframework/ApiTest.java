package top.hopestation.springframework;

import cn.hutool.core.io.IoUtil;
import org.junit.Before;
import org.junit.Test;
import top.hopestation.springframework.context.support.ClassPathXmlApplicationContext;
import top.hopestation.springframework.test.bean.UserDao;
import top.hopestation.springframework.test.bean.UserService;
import top.hopestation.springframework.beans.PropertyValue;
import top.hopestation.springframework.beans.PropertyValues;
import top.hopestation.springframework.beans.factory.config.BeanDefinition;
import top.hopestation.springframework.beans.factory.config.BeanReference;
import top.hopestation.springframework.beans.factory.support.DefaultListableBeanFactory;
import top.hopestation.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import top.hopestation.springframework.test.common.MyBeanFactoryPostProcessor;
import top.hopestation.springframework.test.common.MyBeanPostProcessor;
import top.hopestation.springframework.core.io.DefaultResourceLoader;
import top.hopestation.springframework.core.io.Resource;

import java.io.IOException;
import java.io.InputStream;

public class ApiTest {


    private DefaultResourceLoader resourceLoader;

    @Before
    public void  init(){
        resourceLoader = new DefaultResourceLoader();
    }


    @Test
    public void test_xml2(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring.xml");
        UserService userService = context.getBean("userService", UserService.class);
        System.out.println("userService.queryUserInfo() = " + userService.queryUserInfo());
    }

    @Test
    public void test_BeanFactoryPostProcessorAndBeanPostProcessor(){

        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        reader.loadBeanDefinition("classpath:spring.xml");

        MyBeanFactoryPostProcessor beanFactoryPostProcessor = new MyBeanFactoryPostProcessor();
        beanFactoryPostProcessor.postProcessBeanFactory(beanFactory);

        MyBeanPostProcessor beanPostProcessor = new MyBeanPostProcessor();
        beanFactory.addBeanPostProcessor(beanPostProcessor);

        UserService userService = beanFactory.getBean("userService", UserService.class);
        System.out.println("userService.queryUserInfo() = " + userService.queryUserInfo());


    }

    @Test
    public void test_xml(){
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        reader.loadBeanDefinition("classpath:spring.xml");

        UserService userService = (UserService)beanFactory.getBean("userService", UserService.class);
        userService.queryUserInfo();
    }

    @Test
    public void test_classPath() throws IOException {
        Resource resource = resourceLoader.getResource("classpath:important.properties");
        InputStream inputStream = resource.getInputStream();
        String content = IoUtil.readUtf8(inputStream);
        System.out.println("content = " + content);
    }

    @Test
    public void test_file() throws IOException {
        // 这个测试没通过 ，因为new File应该是绝对路径
        Resource resource = resourceLoader.getResource("src/test/resources/important.properties");
        InputStream inputStream = resource.getInputStream();
        String content = IoUtil.readUtf8(inputStream);
        System.out.println("content = " + content);
    }

    @Test
    public void test_url() throws IOException {
        Resource resource = resourceLoader.getResource("https://github.com/fuzhengwei/small-spring/blob/main/important.properties");
        InputStream inputStream = resource.getInputStream();
        String content = IoUtil.readUtf8(inputStream);
        System.out.println("content = " + content);
    }

    @Test
    public void test5() {
        // 第五章
        DefaultListableBeanFactory defaultListableBeanFactory = new DefaultListableBeanFactory();

        // 先注册一个UserDao
        defaultListableBeanFactory.registerBeanDefinition("userDao", new BeanDefinition(UserDao.class));

        // 注册 UserService 并为其手动初始化 BeanDefinition
        PropertyValues propertyValues = new PropertyValues();
        propertyValues.addPropertyValue(new PropertyValue("name", "xiaoli"));
        propertyValues.addPropertyValue(new PropertyValue("desc", "desccc"));
        propertyValues.addPropertyValue(new PropertyValue("userDao", new BeanReference("userDao")));
        BeanDefinition beanDefinition = new BeanDefinition(UserService.class, propertyValues);
        defaultListableBeanFactory.registerBeanDefinition("userService", beanDefinition);

        UserService userService = (UserService) defaultListableBeanFactory.getBean("userService", "小明");
        System.out.println("userService = " + userService);
        userService.queryUserInfo();

        UserService userService2 = (UserService) defaultListableBeanFactory.getSingleton("userService");
        System.out.println("userService2 = " + userService2);
        userService2.queryUserInfo();

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

