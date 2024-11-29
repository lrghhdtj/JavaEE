package com.example.demo.Mapper;

import com.example.demo.Pojo.Borrow;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;


import java.time.LocalDateTime;
import java.util.List;

@Mapper
public interface BorrowMapper {
    @Insert("insert into borrow (bookid,userid,BookName,initialtime,deadline) values " +
            "(#{bookid},#{userid},#{BookName},#{initialtime},#{deadline})")
    void lend(int bookid, int userid, String BookName,LocalDateTime initialtime, LocalDateTime deadline);

    @Select("select * from borrow where bookid =#{bookid} and userid =#{userid} and initialtime = #{initialtime}")
    Borrow get(int bookid, int userid, LocalDateTime initialtime);

    @Delete("delete from borrow where bookid =#{bookid} and userid =#{userid} and initialtime = #{initialtime}")
    void yet(int bookid, int userid,LocalDateTime initialtime);

    @Select("select * from borrow where userid = #{userid}")
    List<Borrow> getByuser(int userid);

    @Select("select * from borrow where deadline < #{now}")
    List<Borrow> outtime(LocalDateTime now);


}
