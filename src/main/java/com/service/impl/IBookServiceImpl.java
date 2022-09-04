package com.service.impl;

import com.alicp.jetcache.anno.CacheInvalidate;
import com.alicp.jetcache.anno.CacheRefresh;
import com.alicp.jetcache.anno.CacheUpdate;
import com.alicp.jetcache.anno.Cached;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dao.BookDao;
import com.domain.Book;
import com.service.IBookService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

@Service
public class IBookServiceImpl extends ServiceImpl<BookDao, Book> implements IBookService {
    @Autowired
    BookDao bookDao;

    @Override
    public IPage<Book> selectByPage(Integer current, Integer pageSize, Book book) {
        LambdaQueryWrapper<Book> lambdaQueryWrapper = new LambdaQueryWrapper<Book>();
        lambdaQueryWrapper.like(Strings.isNotEmpty(book.getName()), Book::getName, book.getName());
        lambdaQueryWrapper.like(Strings.isNotEmpty(book.getType()), Book::getType, book.getType());
        lambdaQueryWrapper.like(Strings.isNotEmpty(book.getDescription()), Book::getDescription, book.getDescription());

        IPage<Book> page = new Page<>(current, pageSize);
        bookDao.selectPage(page, lambdaQueryWrapper);
        return page;
    }

    @Override
    @Cached(name = "book_", key = "#id", expire = 3600)
    @CacheRefresh(refresh = 10)
    public Book getById(Serializable id) {
        return super.getById(id);
    }

    @Override
    @CacheUpdate(name = "book_", key = "#entity.id", value = "#entity")
    public boolean updateById(Book entity) {
        return super.updateById(entity);
    }

    @Override
    @CacheInvalidate(name = "book_", key = "#id")
    public boolean removeById(Serializable id) {
        return super.removeById(id);
    }
}
