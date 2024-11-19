package com.example.demo.Pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    private int id;
    private String BookName;
    private String Author;
    private String Publisher;
    private String ISBN;
    private double Price;
    private Date PublishDate;
}
