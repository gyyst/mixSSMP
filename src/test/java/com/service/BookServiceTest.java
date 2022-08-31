package com.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BookServiceTest {
    @Autowired
    private IBookService iBookService;

    @Test
    public void testSelectById() {
        System.out.println(iBookService.getById(4));
    }
}
