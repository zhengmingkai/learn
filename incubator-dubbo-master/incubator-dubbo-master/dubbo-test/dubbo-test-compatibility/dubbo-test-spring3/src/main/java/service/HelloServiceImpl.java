package service;

/**
 * Created by zhengmk on 2018/7/27 0027.
 */
public class HelloServiceImpl implements HelloService {
    public String test(String s) {
        return "hello "+ s;
    }
}
