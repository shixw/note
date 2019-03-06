package cc.shixw.spring.event;

import org.springframework.context.ApplicationListener;

/**
 * @author shixianwei
 * @date 2019/3/4 20:21
 */
public class BonusServerListener implements ApplicationListener<UserRegisterEvent> {
    @Override
    public void onApplicationEvent(UserRegisterEvent userRegisterEvent) {
        System.out.println("积分服务接到通知,给："+userRegisterEvent.getSource()+" 增加积分。。。。。");
    }
}
