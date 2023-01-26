package ivandjoh.com.livecode.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ivandjoh.com.livecode.entity.ArtikelPost;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/v1")
public class ArtikelController {
    
    @GetMapping("/posts")
    public ResponseEntity<ArtikelPost> getAllPosts() {
        return new ResponseEntity<>(artikelPostService.getAllPosts(), HttpStatus.OK);
    }
    
}
