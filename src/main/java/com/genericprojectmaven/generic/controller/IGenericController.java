package com.genericprojectmaven.generic.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface IGenericController<T, ID> {
    List<T> findAll();

    ResponseEntity<T> findById(@PathVariable ID id);

    T create(@Validated @RequestBody T entity);

    ResponseEntity<T> update(@PathVariable ID id, @Validated @RequestBody T entity);

    ResponseEntity<Void> deleteById(@PathVariable ID id);
}
