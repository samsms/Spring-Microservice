/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.Login.controllers;

import static com.example.Login.dto.Response.error;
import static com.example.Login.dto.Response.ok;
import com.example.Login.dto.RoleDto;
import com.example.Login.services.rolesService;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author samsms
 */
@RestController
@RequestMapping("/roles")
public class RolesController {
    @Autowired
    rolesService rservice;
    @PostMapping("/create")
    public Object create_role(@RequestBody RoleDto roleDto){
       if(rservice.create_role(roleDto)){
         return   ok("true","Role Created Successful",roleDto);
       }else{
          return error("false","Failed to Create role");
       }
        
    }
    @GetMapping("/list")
    public Object list_roles(){
       
         return   ok("true","Role Retrieved Successful",rservice.list_roles());
      
        
    }
    @PutMapping("/{id}")
    public Object create_role(@RequestBody RoleDto roleDto,@PathVariable Long id){
       if(rservice.update_role(id, roleDto)){
         return   ok("true","Role updated Successfully",roleDto);
       }else{
          return error("false","Failed to update role");
       }
        
    }
    @DeleteMapping("/{id}")
    public Object Delete(@PathVariable Long id){
       
           if(rservice.exist(id)){
               String rolename=rservice.getRole(id);
               RoleDto role =new RoleDto();
               role.setRolename(rolename);
                if(rservice.delete_role(id)){
                return ok("true","Role Deleted Successful",role);
                }else{
                    return error("false","Unknown occured while deleting the role");
                }
           }else{
               return error("false","role doesn't exist");
           }
//            map.put(, id)
           
        
       
        
    }
    
}
