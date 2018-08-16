package org.apache.dubbo.test;

import org.apache.dubbo.container.Main;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import server.HelloService;

/**
 * Created by zhengmk on 2018/7/30 0030.
 */
public class App {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("dubbo-client.xml");
        HelloService service = (HelloService) context.getBean("helloService");
        service.sayHello("zmk");
    }
}
