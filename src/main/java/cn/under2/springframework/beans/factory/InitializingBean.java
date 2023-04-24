package cn.under2.springframework.beans.factory;

public interface InitializingBean {

    void afterProperties() throws Exception;
}
