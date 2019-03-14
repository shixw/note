package cc.shixw.queue;

import java.util.concurrent.PriorityBlockingQueue;

/**
 * @author shixianwei
 * @date 2019/3/8 18:07
 */
public class UnblockQueueDemo {

    private PriorityBlockingQueue<Integer> queue = new PriorityBlockingQueue<>(10);

    public static void main(String[] args) {
        UnblockQueueDemo unblockQueueDemo = new UnblockQueueDemo();
        Consumer consumer =  unblockQueueDemo.new Consumer();
        Producer producer =  unblockQueueDemo.new Producer();

        consumer.start();
        producer.start();
    }

    class Consumer extends Thread{

        @Override
        public void run() {
            consume();
        }

        private void consume(){
            while (true){
                synchronized (queue){
                    while (queue.size()==0){
                        try {
                            System.out.println("队列空，等待数据");
                            queue.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                            queue.notify();
                        }
                    }
                    queue.poll();
                    queue.notify();
                    System.out.println("从队列取走个元素，剩余："+queue.size()+" 个元素");
                }
            }
        }
    }

    class Producer extends Thread{
        @Override
        public void run() {
            producer();
        }

        private void producer(){
            while (true){
                synchronized (queue){
                    while (queue.size()==10){
                        try {
                            System.out.println("队列慢");
                            queue.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    queue.offer(1);
                    queue.notify();
                    System.out.println("插入一个元素，剩余空间："+(10-queue.size()));
                }
            }
        }
    }
}
