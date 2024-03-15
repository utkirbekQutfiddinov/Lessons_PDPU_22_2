package lessons.module_5.lesson_5_8;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.logging.Logger;

public class ReflectionApi {


    Logger logger=Logger.getLogger(ReflectionApi.class.getName());
    public static void main(String[] args) throws InstantiationException, IllegalAccessException, InvocationTargetException {
        /**
         * Class
         * Method
         * Annotation
         * Field
         * Modifier
         * Method
         * Constructor
         */

        /**
         * Difference between getAAA(1) vs getDeclaredAAA(2)
         * 1. gets parent class and its own public AAA
         * 2. gets all of its own AAA
         */



    }

    private static void settingFields() throws InstantiationException, IllegalAccessException, InvocationTargetException {
        Class<Student> studentClass = Student.class;

        Constructor<?> declaredConstructor = studentClass.getDeclaredConstructors()[0];
        declaredConstructor.setAccessible(true);

        Student s = (Student) declaredConstructor.newInstance();
        Student s1 = (Student) declaredConstructor.newInstance();

        System.out.println(s);
        System.out.println(s1);
        System.out.println("###################3");

        for (Method declaredMethod : studentClass.getDeclaredMethods()) {
            if(declaredMethod.getName().equals("setName")){
                declaredMethod.invoke(s,"Eshmat");
                declaredMethod.invoke(s1,"Toshmat");
            }
        }


        for (Field declaredField : studentClass.getDeclaredFields()) {
            declaredField.setAccessible(true);
            if(declaredField.getName().equals("age")){
                declaredField.set(s,20);
                declaredField.set(s1,200);
            }
        }

        System.out.println("###################3");
        System.out.println(s);
        System.out.println(s1);
    }

    private static void constructors() {
        Class<Student> studentClass = Student.class;

        for (Constructor<?> constructor : studentClass.getConstructors()) {
            System.out.println(constructor);
        }
    }

    private static void methods() {
        Class<Student> studentClass = Student.class;

        for (Method method : studentClass.getMethods()) {
            System.out.println(method);
        }
    }

    private static void fields() {
        Class<Student> studentClass = Student.class;
        for (Field field : studentClass.getDeclaredFields()) {
            System.out.println(field);
        }
    }

    private static void annotations() {
        Class<Student> studentClass = Student.class;

        Annotation[] declaredAnnotations = studentClass.getAnnotations();

        for (Annotation declaredAnnotation : declaredAnnotations) {
            System.out.println(declaredAnnotation);
        }
    }
}
