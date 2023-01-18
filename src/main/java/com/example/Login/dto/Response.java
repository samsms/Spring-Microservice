package com.example.Login.dto;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor

@Setter
@Getter
public class Response {
//    String success;
//    String message;
//    Objects data;
    public static  Object ok(String success, String message,Object data){
        Map map=new HashMap();
        map.put("success", success);
        map.put("message", message);
        map.put("data", data);
        return map;
    }
      public static  Object error(String success, String message){
        Map map=new HashMap();
        map.put("success", success);
        map.put("message", message);
        return map;
    }
}
