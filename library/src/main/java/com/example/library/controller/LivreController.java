package com.example.library.controller;

import com.example.library.dto.LivreDTO;
import com.example.library.service.ILivreService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/livres")
public class LivreController {

    @Autowired
    private ILivreService livreService;

    @PostMapping
    public ResponseEntity<LivreDTO> addBook(@RequestBody LivreDTO livreDTO) {
        return ResponseEntity.ok(livreService.addBook(livreDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<LivreDTO> updatePlayer(@PathVariable Long id, @RequestBody LivreDTO livreDetails) {
        LivreDTO updatedBook = livreService.updateBook(id, livreDetails);
        return updatedBook != null ? ResponseEntity.ok(updatedBook) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
        livreService.deleteBook(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public List<LivreDTO> getAllBooks() {
        return livreService.getAllBooks();
    }

    @GetMapping("/{id}")
    public ResponseEntity<LivreDTO> getBookById(@PathVariable Long id) {
        LivreDTO livre = livreService.getBookById(id);
        return livre != null ? ResponseEntity.ok(livre) : ResponseEntity.notFound().build();
    }
}
