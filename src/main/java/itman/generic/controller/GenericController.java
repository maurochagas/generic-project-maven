package itman.generic.controller;

import itman.generic.service.GenericService;
import itman.generic.utils.IUpdatable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

public abstract class GenericController<T extends IUpdatable<T>, ID> implements IGenericController<T, ID> {

    private final GenericService<T, ID> service;

    public GenericController(GenericService<T, ID> service) {
        this.service = service;
    }

    @Override
    @GetMapping
    public List<T> findAll() {
        return service.findAll();
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<T> findById(@PathVariable ID id) {
        Optional<T> entity = service.findById(id);
        return entity.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Override
    @PostMapping
    public T create(@Validated @RequestBody T entity) {
        return service.save(entity);
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<T> update(@PathVariable ID id, @Validated @RequestBody T entity) {
        Optional<T> existingEntity = service.findById(id);
        if (existingEntity.isPresent()) {
            T updatedEntity = existingEntity.get();
            updatedEntity.updateProperties(entity);
            return ResponseEntity.ok(service.save(updatedEntity));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable ID id) {
        if (service.findById(id).isPresent()) {
            service.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
