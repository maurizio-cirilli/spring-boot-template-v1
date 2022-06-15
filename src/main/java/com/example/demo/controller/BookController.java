package com.example.demo.controller;

import com.example.demo.dto.BaseResponse;
import com.example.demo.dto.BookDto;
import com.example.demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.ResponseEntity.ok;


@RestController
@RequestMapping(value = "/api/v1/book", produces = {MediaType.APPLICATION_JSON_VALUE})
public class BookController {

    @Autowired
    private BookService service;

    @RequestMapping("/{id}")
    public ResponseEntity<BookDto> getBookById(@PathVariable Long id) throws Exception {
        return ok(service.findById(id));
    }

    @PostMapping()
    public ResponseEntity<BookDto> createBook(@RequestBody BookDto dto) throws Exception {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.createBook(dto));
    }

    @PutMapping()
    public ResponseEntity<BookDto> updateBook(@RequestBody BookDto dto) {
        return ResponseEntity.status(HttpStatus.OK).body(service.updateBook(dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteBook(@PathVariable Long id) {
        service.deleteBookById(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
