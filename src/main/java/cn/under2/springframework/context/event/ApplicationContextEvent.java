package cn.under2.springframework.context.event;

import cn.under2.springframework.context.ApplicationContext;
import cn.under2.springframework.context.ApplicationEvent;

public class ApplicationContextEvent extends ApplicationEvent {
    /**
     * Constructs a prototypical Event.
     *
     * @param source the object on which the Event initially occurred
     * @throws IllegalArgumentException if source is null
     */
    public ApplicationContextEvent(Object source) {
        super(source);
    }

    public final ApplicationContext getApplicationContext(){
        return (ApplicationContext)getSource();
    }

}
