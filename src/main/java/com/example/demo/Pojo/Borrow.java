package com.example.demo.Pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Borrow {
    private int id;
    private int userId;
    private int bookId;
    private String BookName;
    private Date initialtime;//借书开始时间
    private Date deadline;//归还截止时间
}
