package com.genericprojectmaven.generic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
public abstract class GenericService<T, ID> implements IGenericService<T, ID> {

    private final JpaRepository<T, ID> repository;

    public GenericService(JpaRepository<T, ID> repository) {
        this.repository = repository;
    }

    @Override
    public List<T> findAll() { return repository.findAll(); }

    @Override
    public Optional<T> findById(ID id) { return repository.findById(id); }

    @Override
    public T save(T entity) { return repository.save(entity); }

    @Override
    public void deleteById(ID id) { repository.deleteById(id); }
}
