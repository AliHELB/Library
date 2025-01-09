package com.example.library.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.library.entity.Auteur;
import com.example.library.repository.AuteurRepository;

public class AuteurDAO implements IAuteurDAO {
    @Autowired
    private AuteurRepository auteurRepository;

    @Override
    public Auteur save(Auteur auteur) {
        return auteurRepository.save(auteur);
    }

    @Override
    public Optional<Auteur> findById(Long id) {
        return auteurRepository.findById(id);
    }

    @Override
    public List<Auteur> findAll() {
        return auteurRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        auteurRepository.deleteById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return auteurRepository.existsById(id);
    }

}
