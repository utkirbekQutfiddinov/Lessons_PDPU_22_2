package singleton;

public class MyThread implements Runnable {
    @Override
    public void run() {
        Car car=Car.getInstance();
        System.out.println(car.hashCode());
    }
}
