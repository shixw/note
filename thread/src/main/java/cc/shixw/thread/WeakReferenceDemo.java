package cc.shixw.thread;

import java.lang.ref.WeakReference;

/**
 * @author shixianwei
 * @date 2019/2/28 20:26
 */
public class WeakReferenceDemo {

    public static void main(String[] args) {

        Car car = new Car("1");
        WeakReference<Car> weakReference = new WeakReference<Car>(car);

        while (true){
            if (weakReference!=null){

            }else{
                System.out.println(car);
                System.out.println("null");
                break;
            }
        }
    }

    private static class Car{

        private String name;

        public Car(String name) {
            this.name = name;
        }
    }
}
