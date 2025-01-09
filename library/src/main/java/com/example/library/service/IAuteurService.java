package com.example.library.service;

import com.example.library.dto.AuteurDTO;
import java.util.List;

public interface IAuteurService {
    AuteurDTO addAuthor(AuteurDTO auteurDTO);

    List<AuteurDTO> getAllAuthors();

    AuteurDTO getAuthorDetails(Long id);

}