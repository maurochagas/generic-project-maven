package com.genericprojectmaven.controller;

import com.genericprojectmaven.entity.Book;
import com.genericprojectmaven.generic.controller.GenericController;
import com.genericprojectmaven.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/books")
public class BookController extends GenericController<Book, UUID> {

    @Autowired
    public BookController(BookService bookService) {
        super(bookService);
    }
}
