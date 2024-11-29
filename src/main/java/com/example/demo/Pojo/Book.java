package com.example.demo.Pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    private int id;
    private String BookName;
    private String Author;
    private String Category;//类别
    private String Publisher;//出版社
    private String ISBN;
    private double Price;//价格
    private int Stock;//存量
    private double score;//评分
    private LocalDate PublishDate;//出版时间 年月日
}
