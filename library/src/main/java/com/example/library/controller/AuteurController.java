package com.example.library.controller;

import com.example.library.dto.AuteurDTO;
import com.example.library.service.IAuteurService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auteurs")
public class AuteurController {

    @Autowired
    private IAuteurService auteurService;

    @PostMapping
    public ResponseEntity<AuteurDTO> addAuthor(@RequestBody AuteurDTO auteurDTO) {
        return ResponseEntity.ok(auteurService.addAuthor(auteurDTO));
    }

    @GetMapping
    public List<AuteurDTO> getAllAuthors() {
        return auteurService.getAllAuthors();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AuteurDTO> getAuthorDetails(@PathVariable Long id) {
        return ResponseEntity.ok(auteurService.getAuthorDetails(id));
    }

}
