package com.example.Login.services;

import com.example.Login.dto.LoginDto;
import com.example.Login.dto.UserRegDto;
import com.example.Login.models.Users;
import com.example.Login.repositories.usersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UsersService implements UserDetailsService {
    @Autowired
    usersRepo repo;
    @Autowired
    PasswordEncoder passwordEncoder;
    public Boolean createUser(UserRegDto userRegDto){
        Users users=new Users();
        users.setFirstname(userRegDto.getFirstname());
        users.setLastname(userRegDto.getLastname());
        users.setUsername(userRegDto.getUsername());
        users.setPassword(passwordEncoder.encode(userRegDto.getPassword()));
        try{
        repo.save(users);
            return true;
        }
        catch(Exception e){
              return false;
        }
      
    }
//    public  Users getuser(String username){
//
//    }
    public List<Users> usersList(){

        return repo.findAll();
    }
    public  Boolean Login(LoginDto loginDto){
        Optional<Users> user=  repo.findByUsernameAndPassword(loginDto.getUsername(),loginDto.getPassword());
        if(user.isPresent()){
            return true;
        }
        else{
            return false;
        }
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       Users user= repo.findByUsername(username).get();
        return new User(user.getUsername(),user.getPassword(),new ArrayList<>());
    }
}
