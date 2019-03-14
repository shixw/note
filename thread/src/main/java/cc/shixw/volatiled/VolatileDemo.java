package cc.shixw.volatiled;

/**
 * @author shixianwei
 * @date 2019/3/7 15:42
 */
public class VolatileDemo {

    public int i = 0;

    public void increment(){
        i++;
    }
    public static void main(String[] args) throws InterruptedException {
        VolatileDemo volatileDemo = new VolatileDemo();

        for (int i = 0; i < 20; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    volatileDemo.increment();
                }
            }).start();
        }
        Thread.sleep(2000);
        System.out.println(volatileDemo.i);


    }
}
