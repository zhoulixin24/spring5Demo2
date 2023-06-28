package org.example.dao;


import org.example.entity.Book;

public interface BookDao {
    void add(Book book);

    void update(Book book);

    void delete(int id);

    int selectCount();
}
