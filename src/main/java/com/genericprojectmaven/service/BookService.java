package com.genericprojectmaven.service;

import com.genericprojectmaven.entity.Book;
import com.genericprojectmaven.generic.service.GenericService;
import com.genericprojectmaven.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class BookService extends GenericService<Book, UUID> {

    @Autowired
    public BookService(BookRepository bookRepository) {
        super(bookRepository);
    }
}
