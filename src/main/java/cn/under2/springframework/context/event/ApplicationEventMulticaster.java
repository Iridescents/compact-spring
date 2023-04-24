package cn.under2.springframework.context.event;

import cn.under2.springframework.context.ApplicationEvent;
import cn.under2.springframework.context.ApplicationListener;

public interface ApplicationEventMulticaster {

    void addApplicationListener(ApplicationListener<?> listener);

    void removeApplicationListener(ApplicationListener<?> listener);

    void multicastEvent(ApplicationEvent event);

}
