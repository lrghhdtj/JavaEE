package com.example.demo.Mapper;

import com.example.demo.Pojo.Book;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface BookMapper {

    @Select("select * from Book limit #{start},#{pageSize}")
    List<Book> Page( int start, int pageSize);

    @Select("select count(*)from Book")
    Long count();

    @Select("select * from Book")
    List<Book> GetAll();

    @Select("select * from Book where id = #{bookid}")
    Book GetBookById(int id);

    @Select("select * from Book where BookName = #{bookname}")
    Book GetBookByName(String bookname);

    @Select("select * from Book where bookname like #{similarName}")
    List<Book> search(String similarName);

    @Select("select stock from Book where bookname = #{bookname} ")
    int getStock(String bookname);
}
