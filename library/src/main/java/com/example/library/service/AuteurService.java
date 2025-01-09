package com.example.library.service;

import com.example.library.dto.AuteurDTO;
import com.example.library.dto.LivreDTO;
import com.example.library.dao.*;
import com.example.library.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.stream.Collectors;

public class AuteurService implements IAuteurService {

    @Autowired
    private IAuteurDAO auteurDAO;

    @Override
    public AuteurDTO addAuthor(AuteurDTO auteurDTO) {
        Auteur auteur = toEntity(auteurDTO);
        return toDTO(auteurDAO.save(auteur));
    }

    @Override
    public List<AuteurDTO> getAllAuthors() {
        return auteurDAO.findAll().stream().map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public AuteurDTO getAuthorDetails(Long id) {
        Auteur auteur = auteurDAO.findById(id).orElseThrow(() -> new RuntimeException("auteur pas trouvé"));
        AuteurDTO auteurDTO = toDTO(auteur);
        List<LivreDTO> livres = auteur.getLivres().stream().map(this::toLivreDTO).collect(Collectors.toList());
        auteurDTO.setLivres(livres);
        return auteurDTO;
    }

    private AuteurDTO toDTO(Auteur auteur) {
        AuteurDTO dto = new AuteurDTO();
        dto.setId(auteur.getId());
        dto.setNom(auteur.getNom());
        dto.setPrenom(auteur.getPrenom());
        return dto;
    }

    private Auteur toEntity(AuteurDTO dto) {
        Auteur auteur = new Auteur();
        auteur.setId(dto.getId());
        auteur.setNom(dto.getNom());
        auteur.setPrenom(dto.getPrenom());
        return auteur;
    }

    private LivreDTO toLivreDTO(Livre livre) {
        LivreDTO dto = new LivreDTO();
        dto.setId(livre.getId());
        dto.setTitre(livre.getTitre());
        dto.setGenre(livre.getGenre());
        return dto;
    }
}
