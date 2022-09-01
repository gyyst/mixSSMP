package com.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.controller.utils.Code;
import com.controller.utils.Result;
import com.domain.Book;
import com.service.IBookService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/books")
@Slf4j
public class BookController {
    //    private static final Logger log = LoggerFactory.getLogger(BookController.class);
    @Autowired
    private IBookService bookService;

    @GetMapping
    public Result getAll() {
        Result result = new Result(Code.SUCCESS, bookService.list());
        log.info("getAll()");
        return result;
    }

    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id) {
        Result result = new Result(Code.SUCCESS, bookService.getById(id));
        log.info("getById()");
        return result;
    }

    @PostMapping
    public Result save(@RequestBody Book book) {
        Result result = new Result(Code.SUCCESS, bookService.save(book));
        log.info("save()");
        return result;
    }

    @PutMapping
    public Result update(@RequestBody Book book) {
        Result result = new Result(Code.SUCCESS, bookService.updateById(book));
        log.info("update()");
        return result;
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        Result result = new Result(Code.SUCCESS, bookService.removeById(id));
        log.info("delete()");
        return result;
    }

//    @GetMapping("/{current}/{pageSize}")
//    public Result getByPage(@PathVariable Integer current, @PathVariable Integer pageSize) {
//        IPage<Book> bookIPage = bookService.selectByPage(current, pageSize);
//        if (current > bookIPage.getPages()) {
//            bookIPage = bookService.selectByPage((int) bookIPage.getPages(), pageSize);
//        }
//        Result result = new Result(Code.SUCCESS, bookIPage);
//
//        return result;
//    }

    @GetMapping("/{current}/{pageSize}")
    public Result getByPage(@PathVariable Integer current, @PathVariable Integer pageSize, Book book) {
        IPage<Book> bookIPage = bookService.selectByPage(current, pageSize, book);
        if (current > bookIPage.getPages()) {
            bookIPage = bookService.selectByPage((int) bookIPage.getPages(), pageSize, book);
        }
        Result result = new Result(Code.SUCCESS, bookIPage);
        log.info("getByPage()");
        return result;
    }
}
