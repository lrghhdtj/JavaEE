package com.example.demo.Mapper;

import com.example.demo.Pojo.Comment;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.Date;
import java.util.List;

@Mapper
public interface CommentMapper {
    @Select("select * from comment where bookname = #{bookname}")
    List<Comment> selectAll(String bookname);

    @Insert("insert into comment (username,bookname,comment,goal,createtime,userid,bookid) " +
            "values (#{username},#{bookname},#{comment},#{goal},#{createtime},#{userid},#{bookid})")
    void addcomment(String username, String bookname, String comment, int goal, Date createtime,int bookid,int userid);

    @Delete("delete from comment where username = #{username} and bookname = #{bookname}")
    void deletecomment(String username, String bookname);

    @Select("select * from comment where  username = #{username} and bookname = #{bookname}")
    Comment get(String username,String bookname);
}
