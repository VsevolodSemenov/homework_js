package aop1;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(MyConfig.class);

        UniLibrary uniLibrary = context.getBean("uniLibrary", UniLibrary.class);
        Book book = context.getBean("book", Book.class);
        uniLibrary.getBook(book);
        uniLibrary.getMagazine();
        uniLibrary.returnMagazine();
        uniLibrary.returnBook(book);
        context.close();
    }
}
