package lessons.module_5.lesson_5_8;

@MyAnnotation(name = "Eshmat", age=20)
public class Student extends Person {
    private String name;
    private Integer age;


    public Student() {
    }

    public Student(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }


    public void salom(){
        System.out.println("salom");
    }

    private int get(){
        return 18239;
    }


    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
