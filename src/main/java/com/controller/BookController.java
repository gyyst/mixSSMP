package com.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.controller.utils.Code;
import com.controller.utils.Result;
import com.domain.Book;
import com.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    private IBookService bookService;

    @GetMapping
    public Result getAll() {
        Result result = new Result(Code.SUCCESS, bookService.list());
        return result;
    }

    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id) {
        Result result = new Result(Code.SUCCESS, bookService.getById(id));
        return result;
    }

    @PostMapping
    public Result save(@RequestBody Book book) {
        Result result = new Result(Code.SUCCESS, bookService.save(book));
        return result;
    }

    @PutMapping
    public Result update(@RequestBody Book book) {
        Result result = new Result(Code.SUCCESS, bookService.updateById(book));
        return result;
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        Result result = new Result(Code.SUCCESS, bookService.removeById(id));
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

        return result;
    }
}
