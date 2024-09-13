package org.example.repositories;

import java.util.Optional;

//добавить findAll
public interface BaseRepository<T> {

    Optional<T> findById(int id);

    T save(T entity);

    void softDeleteById(int id);


}
