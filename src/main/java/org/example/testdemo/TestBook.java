package org.example.testdemo;

import org.example.entity.Book;
import org.example.service.BookService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestBook {

    @Test
    public void test(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean2.xml");
        BookService bookService = context.getBean("bookService", BookService.class);
        Book book = new Book();
        book.setBookName("阿里巴巴");
        book.setAuther("马云");
        bookService.add(book);
        System.out.println(bookService.findCount());
    }
}
