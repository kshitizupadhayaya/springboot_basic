package com.jpa.test.basicall.Service;

import com.jpa.test.basicall.Entity.User;
import com.jpa.test.basicall.Repo.UserRepo;
import com.jpa.test.basicall.Repo.cardRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserService
{
    @Autowired

    private UserRepo userRepo;
    private cardRepo  cardrepo;

 public String add(User user)
 {
     userRepo.save(user);
     return "success --- user has been added";
 }
 public String bulkadd(List<User> users)
 {
     userRepo.saveAll(users);
     return "success --- users has been added";
 }
 public String update(User user)
 {
     userRepo.save(user);
     return "success --- user has been updated";
 }
 public String delete(int id)
 {
     User user=userRepo.getById(id);
     userRepo.delete(user);
     return "success --- user has been deleted";
 }
 public User getdata(int id)
 {
     return userRepo.findById(id).get();
 }



}
