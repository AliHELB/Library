package com.example.library.dao;

import java.util.List;
import java.util.Optional;

import com.example.library.entity.Auteur;

public interface IAuteurDAO {
    Auteur save(Auteur auteur);

    Optional<Auteur> findById(Long id);

    List<Auteur> findAll();

    void deleteById(Long id);

    boolean existsById(Long id);

}