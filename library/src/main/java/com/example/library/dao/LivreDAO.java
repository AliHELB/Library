package com.example.library.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.library.entity.Livre;
import com.example.library.repository.LivreRepository;

@Repository
public class LivreDAO implements ILivreDAO {
    @Autowired
    private LivreRepository livreRepository;

    @Override
    public Livre save(Livre livre) {
        return livreRepository.save(livre);
    }

    @Override
    public Optional<Livre> findById(Long id) {
        return livreRepository.findById(id);
    }

    @Override
    public List<Livre> findAll() {
        return livreRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        livreRepository.deleteById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return livreRepository.existsById(id);
    }

}
