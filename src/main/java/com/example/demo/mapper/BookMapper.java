package com.example.demo.mapper;

import com.example.demo.dto.BookDto;
import com.example.demo.model.Book;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface BookMapper {

    @Mapping(target = "releaseDate", source = "releaseDate", dateFormat = "dd-MM-yyyy")
    BookDto bookToBookDto(Book entity);

    @Mapping(target = "releaseDate", source = "releaseDate", dateFormat = "dd-MM-yyyy")
    @Mapping(target = "id", ignore = true)
    Book bookDtoToBook(BookDto dto);

    @Mapping(target = "releaseDate", source = "releaseDate", dateFormat = "dd-MM-yyyy")
    Book bookDtoToBookForUpdate(BookDto dto);

}
