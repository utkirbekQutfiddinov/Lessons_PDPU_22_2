package lessons.module_4.lessson_4_8;

import java.io.Serializable;

public class BookTest implements Serializable {
    private String name;
    private String author;

    public BookTest(String name, String author) {
        this.name = name;
        this.author = author;
    }

    @Override
    public String toString() {
        return "BookTest{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}
