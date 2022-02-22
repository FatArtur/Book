package com.example.demo.dto;


import com.example.demo.model.Book;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BookDto {

    String name;
    String author;
    int isbn;

    public static BookDto toBookDto(Book book) {
        return builder()
                .name(book.getName())
                .author(book.getAuthor())
                .isbn(book.getIsbn())
                .build();
    }
}
