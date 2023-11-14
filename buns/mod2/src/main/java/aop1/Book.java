package aop1;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
public class Book {
    @Value("Бойцовский клуб")
    private String name;

    @Value("Чак Паланик")
    private String author;

    @Value("1996")
    private int yearOfPublication;

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public int getYearOfPublication() {
        return yearOfPublication;
    }
}
