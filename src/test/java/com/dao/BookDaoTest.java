package com.dao;

import com.MixSsmpApplication;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.domain.Book;
import org.apache.logging.log4j.util.Strings;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;

import java.util.List;

@SpringBootTest
public class BookDaoTest {
    @Autowired
    private BookDao bookDao;

    //    @Test
//    public void test1() {
//        List<Book> books = bookDao.selectList(null);
//        System.out.println(books);
//    }
//
//    @Test
//    public void testsave() {
//        Book book = new Book();
//        book.setType("1234");
//        book.setDescription("1234");
//        book.setName("1234");
//        bookDao.insert(book);
//    }
//
//    @Test
//    public void testSelectById() {
//        Book book = bookDao.selectById(13);
//        System.out.println(book);
//    }
//
//    @Test
//    public void testSelectByPage() {
//        IPage page = new Page(2, 5);
//        IPage Page = bookDao.selectPage(page, null);
//        System.out.println(Page.getCurrent() + "----" + Page.getSize());
//        System.out.println(Page.getRecords());
//    }
//
//    @Test
//    public void testSelectBy() {
//        QueryWrapper<Book> qw = new QueryWrapper<>();
//        qw.like("name", "spring");
//        List<Book> books = bookDao.selectList(qw);
//        System.out.println(books);
//
//    }
//
//    @Test
//    public void testSelectBy2() {
//        String name = "12";
//        LambdaQueryWrapper<Book> lqw = new LambdaQueryWrapper<>();
//        lqw.like(Strings.isNotEmpty(name), Book::getName, name);
//        List<Book> books = bookDao.selectList(lqw);
//        System.out.println(books);
//
//    }

}
