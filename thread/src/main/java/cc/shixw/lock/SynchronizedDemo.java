package cc.shixw.lock;

/**
 * @author shixianwei
 * @date 2019/3/4 14:45
 */
public class SynchronizedDemo {

    public synchronized static void AA(){

    }

    public void BB(){
        synchronized (this){


        }
    }
}
