package cn.under2.springframework.core.io;

import cn.hutool.core.lang.Assert;

import java.net.MalformedURLException;
import java.net.URL;

public class DefaultResourceLoader implements ResourceLoader {

    /**
     * 传入一个地址，
     * - 假如以 classpath:开头，则转换为 ClassPathResource
     * - 否则，尝试以 UrlResource 来解析
     * - 若解析失败，则尝试以 FileSystemResource 来解析
     * @param location
     * @return
     */
    @Override
    public Resource getResource(String location) {
        Assert.notNull(location, "location must not be null");
        if(location.startsWith(CLASS_URl_PREFIX)){
            return new ClassPathResource(location.substring(CLASS_URl_PREFIX.length()));
        }
        else {
            try {
                URL url = new URL(location);
                return new UrlResource(url);
            } catch (MalformedURLException e) {
                return new FileSystemResource(location);
            }
        }
    }
}
