package builder;

public class BuilderTest {
    public static void main(String[] args) {
        builder.Book b=new builder.Book().builder()
                .setId(12)
//                .setAuthor("adskjb")
//                .setName("aSADHASJ")
//                .setPageCount(5132)
//                .setPublisher("sdfjsnkj")
                .build();

        System.out.println(b);

    }
}
