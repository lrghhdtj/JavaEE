package com.example.demo.Utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result {
    private Integer code;
    private Object message;
    private Object data;
    public static Result success(){
        return new Result(1,"success",null);
    }
    public static Result success(String message){
        return new Result(1,message,null);
    }
    public static Result success(Object data){
        return new Result(1,"success",data);
    }
    public static Result success(Object data,Object message){
        return new Result(1,data,message);
    }
    public static Result error(String message){
        return new Result(0,message,null);
    }
}

