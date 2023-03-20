package top.hopestation.springframework.core.io;

public interface ResourceLoader {

    String CLASS_URl_PREFIX = "classpath:";

    Resource getResource(String location);

}
