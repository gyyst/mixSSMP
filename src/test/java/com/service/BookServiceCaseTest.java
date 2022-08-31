package com.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BookServiceCaseTest {
    @Autowired
    private BookService bookService;

    @Test
    public void testSelectById() {
        System.out.println(bookService.selectById(4));

    }
}
