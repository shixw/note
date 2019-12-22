package cc.shixw.thread;

public class ThreadDemo {
    public static void main(String[] args) throws InterruptedException {
        new Thread(new MyRunnable("123442")).start();

        Thread.sleep(1000L);
    }
}

class MyRunnable implements Runnable{

    public MyRunnable(String threadId){
        System.out.println("threadId=="+threadId);
        System.out.println("currentThreadName=="+Thread.currentThread().getName());
    }

    @Override
    public void run() {
        System.out.println("RunCurrentThreadName=="+Thread.currentThread().getName());
    }
}
