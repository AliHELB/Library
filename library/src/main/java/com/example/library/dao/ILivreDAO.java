package com.example.library.dao;

import com.example.library.entity.Livre;

import java.util.List;
import java.util.Optional;

public interface ILivreDAO {
    Livre save(Livre livre);

    Optional<Livre> findById(Long id);

    List<Livre> findAll();

    void deleteById(Long id);

    boolean existsById(Long id);
}