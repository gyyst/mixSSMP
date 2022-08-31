package com;

import com.dao.BookDao;
import com.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class MixSsmpApplicationTests {

    @Autowired
    private BookDao bookDao;

    @Test
    void contextLoads() {
    }

    @Test
    public void test1() {
        List<Book> books = bookDao.selectList(null);
        System.out.println(books);
    }
}
