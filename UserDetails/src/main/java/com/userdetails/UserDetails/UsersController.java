package com.userdetails.UserDetails;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("users")
public class UsersController {
@Autowired
RestTemplate restTemplate;
    @GetMapping
    public Map users(){
        Map map =new HashMap();
        map.put("id","1");
        map.put("name","kelvin");
        return map;
    }
 @GetMapping("/resttemp")
    public String resttemp() {
        Map map = restTemplate.getForObject("lb://PRODUCTS-SERVICE/products",Map.class);
        return map.get("name").toString();
    }
    @GetMapping("/resttemp1")
    public String resttemp1() {
        return restTemplate.getForObject("http://localhost:8003",String.class);
    }
    @GetMapping("/resttemp3")
    public Object resttemp3() {
        Products products = restTemplate.getForObject("lb://PRODUCTS-SERVICE/products",Products.class);
        Map map =new HashMap();
        map.put("id","1");
        map.put("name","kelvin");
        map.put("product",products);
        return map;
    }
}
