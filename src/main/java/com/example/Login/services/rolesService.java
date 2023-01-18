/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.Login.services;

import org.springframework.beans.factory.annotation.Autowired;
import com.example.Login.dto.RoleDto;
import com.example.Login.models.Roles;
import com.example.Login.repositories.rolesRepo;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

/**
 *
 * @author samsms
 */
@Service
public class rolesService {

    @Autowired
    rolesRepo rolesRepo;

    public Boolean create_role(RoleDto roleDto) {
        Roles roles = new Roles();
        roles.setRolename(roleDto.getRolename());
        try {
            rolesRepo.save(roles);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    public List list_roles(){
      return  rolesRepo.findAll();
    }
    public Boolean delete_role(Long id){
       try{
           rolesRepo.deleteById(id);
       return true;
       }
       catch(Exception e){
           return false;
       }
    }
    public Boolean update_role(Long id,RoleDto roleDto){
       Optional<Roles> rolesObj=rolesRepo.findById(id);
       if(rolesObj.isPresent()){
           Roles role=rolesObj.get();
           role.setRolename(roleDto.getRolename());
           try{
           rolesRepo.save(role);
           return true;
           }
           catch(Exception e){
               return false;
           }
       }else{
           return false;
       }
       
    }
    public Boolean exist(Long id){
         Optional<Roles> rolesObj=rolesRepo.findById(id); 
         return rolesObj.isPresent();
    }
    public String  getRole(Long id){
       Optional<Roles> rolesObj=rolesRepo.findById(id);
       if(rolesObj.isPresent()){
          
           try{
           
           return rolesObj.get().getRolename() ;
           }
           catch(Exception e){
               return "error";
           }
       }else{
           return "error";
       }
       
    }
}
