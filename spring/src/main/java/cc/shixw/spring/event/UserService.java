package cc.shixw.spring.event;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;

/**
 * @author shixianwei
 * @date 2019/3/4 20:17
 */
public class UserService implements ApplicationEventPublisherAware {

    private ApplicationEventPublisher applicationEventPublisher;

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }

    public void register(String name){
        System.out.println("用户："+name+" 以注册!");
        applicationEventPublisher.publishEvent(new UserRegisterEvent(name));
    }
}
