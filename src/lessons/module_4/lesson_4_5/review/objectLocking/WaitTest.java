package lessons.module_4.lesson_4_5.review.objectLocking;

public class WaitTest {
    public static void main(String[] args) {
        Kitchen kit=new Kitchen();
        new Thread(()->{kit.cook();}).start();
        new Thread(()->{kit.eat();}).start();
    }
}
