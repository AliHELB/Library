package com.example.library.service;

import com.example.library.dao.*;
import com.example.library.dto.LivreDTO;
import com.example.library.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LivreService implements ILivreService {

    @Autowired
    private ILivreDAO livreDAO;

    @Autowired
    private IAuteurDAO auteurDAO;

    @Override
    public LivreDTO addBook(LivreDTO livreDTO) {
        Livre livre = toEntity(livreDTO);
        livre.setAuteur(auteurDAO.findById(livreDTO.getIdAuteur())
                .orElseThrow(() -> new RuntimeException("auteur pas trouvé")));
        return toDTO(livreDAO.save(livre));
    }

    @Override
    public LivreDTO updateBook(Long id, LivreDTO livreDTO) {
        Livre livre = livreDAO.findById(id).orElseThrow(() -> new RuntimeException("livre pas trouvé"));
        livre.setTitre(livreDTO.getTitre());
        livre.setGenre(livreDTO.getGenre());
        livre.setAuteur(auteurDAO.findById(livreDTO.getIdAuteur())
                .orElseThrow(() -> new RuntimeException("auteur pas trouvé")));
        return toDTO(livre);
    }

    @Override
    public void deleteBook(Long id) {
        if (!livreDAO.existsById(id))
            throw new RuntimeException("livre non trouvé");
        livreDAO.deleteById(id);
    }

    @Override
    public List<LivreDTO> getAllBooks() {
        return livreDAO.findAll().stream().map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public LivreDTO getBookById(Long id) {
        Livre livre = livreDAO.findById(id).orElseThrow(() -> new RuntimeException("livre pas trouvé"));
        return toDTO(livre);
    }

    private LivreDTO toDTO(Livre livre) {
        LivreDTO dto = new LivreDTO();
        dto.setId(livre.getId());
        dto.setTitre(livre.getTitre());
        dto.setGenre(livre.getGenre());
        return dto;
    }

    private Livre toEntity(LivreDTO dto) {
        Livre livre = new Livre();
        livre.setId(dto.getId());
        livre.setTitre(dto.getTitre());
        livre.setGenre(dto.getGenre());
        return livre;
    }
}