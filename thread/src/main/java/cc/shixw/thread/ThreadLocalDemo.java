package cc.shixw.thread;

import java.util.concurrent.CountDownLatch;

/**
 * @author shixianwei
 * @date 2019/2/27 17:29
 */
public class ThreadLocalDemo {

    public static void main(String[] args) {
        int threads = 3;
        CountDownLatch countDownLatch = new CountDownLatch(threads);
        InnerClass innerClass = new InnerClass();
        for (int i=1;i<=threads;i++){
            new Thread(()->{
                for (int j = 0; j < 4; j++) {
                    innerClass.add(String.valueOf(j));
                    innerClass.print();
                }
                innerClass.set("hello world");
                countDownLatch.countDown();
            }).start();
        }
    }

    private static class InnerClass{

        public void add(String str){
            StringBuilder sb = Counter.counter.get();
            Counter.counter.set(sb.append(str));
        }

        public void print(){
            System.out.printf("Thread Name:%s,Thread hashcode:%s,Intance hashcode:%s,value:%s\n",
              Thread.currentThread().getName(),
              Counter.counter.hashCode(),
              Counter.counter.get().hashCode(),
              Counter.counter.get().toString()
            );
        }

        public void set(String str){
            Counter.counter.set(new StringBuilder(str));
            System.out.printf("Thread Name:%s,Thread hashcode:%s,Intance hashcode:%s,value:%s\n",
                    Thread.currentThread().getName(),
                    Counter.counter.hashCode(),
                    Counter.counter.get().hashCode(),
                    Counter.counter.get().toString()
            );
        }
    }

    private static class Counter{

        private static ThreadLocal<StringBuilder> counter = new ThreadLocal<StringBuilder>(){
            @Override
            protected StringBuilder initialValue() {
                return new StringBuilder();
            }
        };
    }
}
