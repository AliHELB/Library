package com.example.library.service;

import com.example.library.dto.LivreDTO;

import java.util.List;

public interface ILivreService {
    LivreDTO addBook(LivreDTO livreDTO);

    LivreDTO updateBook(Long id, LivreDTO LivreDetails);

    void deleteBook(Long id);

    List<LivreDTO> getAllBooks();

    LivreDTO getBookById(Long id);

}