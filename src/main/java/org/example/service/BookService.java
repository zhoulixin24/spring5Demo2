package org.example.service;

import org.example.dao.BookDao;
import org.example.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    @Autowired
    private BookDao bookDao;

    //新增
    public void add(Book book){
        bookDao.add(book);
    }
}
