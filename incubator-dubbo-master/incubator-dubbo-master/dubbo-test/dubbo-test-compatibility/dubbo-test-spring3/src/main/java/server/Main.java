package server;


import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Administrator on 2018/7/27/027.
 */
public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("dubbo-client.xml");
        context.start();

        HelloService helloService = (HelloService) context.getBean("helloService");
        helloService.sayHello("dd");
        //ExtensionLoader.getExtensionLoader(Protocol.class).getAdaptiveExtension();
    }
}
