package builder;

public class Book {
    private Integer id;
    private String name;
    private String author;
    private String publisher;
    private Integer pageCount;

    private BookBuilder builder;

    public BookBuilder builder(){
        this.builder=new BookBuilder();
        return this.builder;
    }

    public class BookBuilder{
        private Book book;

        public BookBuilder(){
            this.book=new Book();
        }

        public Book build(){
            return this.book;
        }

        public BookBuilder setId(Integer id) {
            this.book.id= id;
            return this;
        }

        public BookBuilder setName(String name) {
            this.book.name = name;
            return this;
        }

        public BookBuilder setAuthor(String author) {
            this.book.author = author;
            return this;
        }

        public BookBuilder setPublisher(String publisher) {
            this.book.publisher = publisher;
            return this;
        }

        public BookBuilder setPageCount(Integer pageCount) {
            this.book.pageCount = pageCount;
            return this;
        }
    }


    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", publisher='" + publisher + '\'' +
                ", pageCount=" + pageCount +
                '}';
    }
}
