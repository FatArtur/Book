package com.example.demo.controller;


import com.example.demo.dto.BookDto;
import com.example.demo.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class Controller {

    private Service service;

    @Autowired
    public Controller(Service service) {
        this.service = service;
    }

    @GetMapping("/books")
    public List<BookDto> getBooks() {
        return service.getBooks();
    }

    @GetMapping("/bookMap")
    public Map<String, List<BookDto>> getBookMap() {
        return service.getMapBooks();
    }

    @GetMapping("/book/{symbol}")
    public List<BookDto> getBook(@PathVariable String symbol) {
        return service.getBookByChar(symbol);
    }


}
