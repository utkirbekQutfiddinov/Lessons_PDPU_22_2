package singleton;

public class Car {
    private static Car instance;
    private Car(){}

    public static Car getInstance(){
        if(instance==null){
            synchronized (instance){
                if (instance==null){
                    instance=new Car();
                }
            }
        }
        return instance;
    }
}
