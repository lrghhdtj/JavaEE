package com.example.demo.Mapper;

import com.example.demo.Pojo.Collect;
import lombok.Data;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CollectMapper {
    @Select("select bookid from collection where userid = #{userid} ")
    List<Integer> getby(int userid);

    @Select("select * from collection where userid = #{userid} and bookid = #{bookid}")
    Collect get(int userid, int bookid);

    @Insert("insert into collection(username,bookname,userid,bookid) values (#{username},#{bookname},#{userid},#{bookid})")
    void add(String username, String bookname, int userid, int bookid);

    @Delete("delete from collection where userid = #{userid} and bookid = #{bookid}")
    void delete(int userid, int bookid);
}
