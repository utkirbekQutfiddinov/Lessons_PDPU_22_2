package singleton;

public class MyThread implements Runnable {
    @Override
    public void run() {
        singleton.Car car= singleton.Car.getInstance();
        System.out.println(car.hashCode());
    }
}
