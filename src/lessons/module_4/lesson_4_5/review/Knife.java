package lessons.module_4.lesson_4_5.review;

public class Knife {
    public void cut() {
        System.out.println(Thread.currentThread().getName()+" is cutting some vegetables...: "+this.hashCode());
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+" has done!");
    }
}
