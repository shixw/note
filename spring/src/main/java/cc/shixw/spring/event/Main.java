package cc.shixw.spring.event;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author shixianwei
 * @date 2019/3/4 20:41
 */
public class Main {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("event.xml");

        UserService userService = (UserService) applicationContext.getBean("userService");

        userService.register("dbzxiang");
    }
}
