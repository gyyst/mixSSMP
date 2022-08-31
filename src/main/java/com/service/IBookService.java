package com.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.domain.Book;

public interface IBookService extends IService<Book> {

    IPage<Book> selectByPage(Integer current, Integer pageSize, Book book);
}
