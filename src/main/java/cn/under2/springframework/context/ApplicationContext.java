package cn.under2.springframework.context;

import cn.under2.springframework.beans.factory.HierarchicalBeanFactory;
import cn.under2.springframework.beans.factory.ListableBeanFactory;
import cn.under2.springframework.core.io.ResourceLoader;

public interface ApplicationContext extends ListableBeanFactory, HierarchicalBeanFactory, ResourceLoader, ApplicationEventPublisher{
}
