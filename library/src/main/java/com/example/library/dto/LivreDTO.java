package com.example.library.dto;

import lombok.Data;

@Data
public class LivreDTO {
    private Long id;
    private String titre;
    private String genre;
    private Long idAuteur;
}