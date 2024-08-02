package com.genericprojectmaven.entity;

import com.genericprojectmaven.generic.utils.IUpdatable;
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
public class Book implements IUpdatable<Book> {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String title;
    private String author;
    private String category;

    @Override
    public void updateProperties(Book book) {
        Updatable.updateProperties(this, book);
    }

}
