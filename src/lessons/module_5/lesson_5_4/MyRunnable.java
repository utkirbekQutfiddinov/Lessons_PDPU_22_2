package lessons.module_5.lesson_5_4;

public class MyRunnable implements Runnable{
    @Override
    public void run() {
        System.out.println("test");
    }

    public static void myPrint(String text){
        System.out.println("123");
        System.out.println("Inside of my print: "+text);
    }
}
