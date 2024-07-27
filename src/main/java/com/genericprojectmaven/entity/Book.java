package com.genericprojectmaven.entity;

import com.genericprojectmaven.generic.utils.Updatable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Book implements Updatable<Book> {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String title;
    private String author;
    private String category;

    @Override
    public void updateProperties(Book book) {
        this.title = book.getTitle();
        this.author = book.getAuthor();
        this.category = book.getCategory();
    }

}
