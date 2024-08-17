package org.example.repositories;

import org.example.entities.BaseEntity;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;
import java.util.Optional;

@NoRepositoryBean
public interface BaseRepository<T> {

    Optional<T> findById(int id);

    T save(T entity);

    void softDeleteById(int id);


}
