package com.example.demo.service;

import com.example.demo.dto.BookDto;
import com.example.demo.execption.BookNotFoundExecption;
import com.example.demo.mapper.BookMapper;
import com.example.demo.model.Book;
import com.example.demo.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepository repository;

    @Autowired
    private BookMapper mapper;

    public BookDto findById(Long id) throws Exception {
        Optional<Book> result = repository.findById(id);
        if (result.isPresent()) {
            return mapper.bookToBookDto(result.get());
        } else {
            throw new BookNotFoundExecption("Book not found");
        }
    }

    public BookDto createBook(BookDto dto) throws Exception {
        return mapper.bookToBookDto(repository.save(mapper.bookDtoToBook(dto)));
    }

    public BookDto updateBook(BookDto dto) {
        return mapper.bookToBookDto(repository.save(mapper.bookDtoToBookForUpdate(dto)));
    }

    public void deleteBookById(Long id) {
        repository.deleteById(id);
    }
}
