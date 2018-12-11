package cc.shixw.netty.hashedWheelTimer;


import io.netty.util.HashedWheelTimer;
import io.netty.util.Timeout;
import io.netty.util.Timer;
import io.netty.util.TimerTask;

import java.util.concurrent.TimeUnit;

/**
 * @author shixianwei
 * @date 2018/12/11 20:41
 */
public class HashedWheelTimerTest {

    public static void main(String[] args) {
        final Timer timer = new HashedWheelTimer();

        timer.newTimeout((TimerTask) timeout -> System.out.println("timeout 5 = [" + timeout + "]"),5, TimeUnit.SECONDS);

        timer.newTimeout((TimerTask) timeout -> System.out.println("timeout 10 = [" + timeout + "]"),10, TimeUnit.SECONDS);


    }
}
