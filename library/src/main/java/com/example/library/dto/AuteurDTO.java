package com.example.library.dto;

import java.util.List;

import lombok.Data;

@Data
public class AuteurDTO {
    private Long id;
    private String nom;
    private String prenom;
    private List<LivreDTO> livres;
}