package cc.shixw.spring.event;

import org.springframework.context.ApplicationEvent;

/**
 * @author shixianwei
 * @date 2019/3/4 20:15
 */
public class UserRegisterEvent extends ApplicationEvent {

    public String name;

    public UserRegisterEvent(Object source) {
        super(source);
    }

    public UserRegisterEvent(Object source, String name) {
        super(source);
        this.name = name;
    }
}
