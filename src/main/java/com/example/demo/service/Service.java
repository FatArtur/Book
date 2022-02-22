package com.example.demo.service;

import com.example.demo.dto.BookDto;
import com.example.demo.repository.BookRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

@org.springframework.stereotype.Service
@Data
public class Service {

    private BookRepository bookRepository;

    @Autowired
    public Service(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<BookDto> getBooks() {
        return bookRepository.findAll().stream().map(BookDto::toBookDto).collect(Collectors.toList());
    }

    public Map<String, List<BookDto>> getMapBooks() {
        List<BookDto> books = bookRepository.findAll().stream().map(BookDto::toBookDto).collect(Collectors.toList());
        return books.stream().collect(groupingBy(k -> k.getName().substring(0, 1).toUpperCase(), Collectors.toList()));
    }

    public List<BookDto> getBookByChar(String symbol) {
        return getMapBooks().get(symbol.toUpperCase());
    }
}
