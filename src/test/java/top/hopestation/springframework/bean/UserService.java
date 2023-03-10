package top.hopestation.springframework.bean;

public class UserService {

    private String name;

    public UserService(String name){
        this.name = name;
    }
    public void getUserInfo(){
        System.out.println("查询用户信息：" + name);
    }
}
