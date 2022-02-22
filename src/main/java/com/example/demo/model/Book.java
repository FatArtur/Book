package com.example.demo.model;

import lombok.Data;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
@Component
public class Book {
    @Id
    int id;
    @Column
    String name;
    @Column
    String author;
    @Column
    int isbn;
}