package com.service;

import com.domain.Book;

import java.util.List;

public interface BookService {
    public boolean save(Book book);

    public boolean update(Book book);

    public boolean delete(Book book);

    Book selectById(Integer id);

    List<Book> selectAll();

}
