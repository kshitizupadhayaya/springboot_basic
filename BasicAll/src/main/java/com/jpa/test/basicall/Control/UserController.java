package com.jpa.test.basicall.Control;

import com.jpa.test.basicall.Entity.Card;
import com.jpa.test.basicall.Entity.User;
import com.jpa.test.basicall.Repo.UserRepo;
import com.jpa.test.basicall.Repo.cardRepo;
import com.jpa.test.basicall.Service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class UserController
{
    @Autowired
    public UserService userService;
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private cardRepo  cardrepo;

//    @PostMapping("/add")
//    public String addUser( @RequestBody  User user)
//    {
//        return userService.add(user);
//    }
//    @PostMapping("/bulkadd")
//    public String bulkAddUser(@RequestBody List<User> users)
//    {
//        return  userService.bulkadd(users);
//    }
//    @PutMapping("/update")
//    public  String Update( @RequestBody User user)
//    {
//        return userService.update(user);
//    }
//    @DeleteMapping("/delete/{id}")
//    public String Delete(@PathVariable int id)
//    {
//        return userService.delete(id);
//    }
//    @GetMapping("/get/{id}")
//    public User Get(@PathVariable int id)
//    {
//        return userService.getdata(id);
//    }

    /*----------------------------------------------  for thyme leaf-------------------------------------*/

    @RequestMapping("/home")
    public String home()
    {
        return "home";
    }
    @RequestMapping("/thanks")
    public String thanks()
    {
        return "thanks";
    }
    @PostMapping("/contact")
    public String Contact(@ModelAttribute User user, HttpSession session) {
        userRepo.save(user);
        session.setAttribute("user", user);
        return "thanks";
    }
@RequestMapping("/admin")
    public String admin()
{
    return "admin";
}
@GetMapping("/next")
    public String next()
{
    return "package";
}

@RequestMapping("/subs")
    public String subs()
{
    return "subs";
}
    @PostMapping("/card")
    public String card(@ModelAttribute Card card, HttpSession session)
    {
        cardrepo.save(card);
        return "subs";
    }
    @GetMapping("/admin")
    public String Viewpage(Model model)
    {
        model.addAttribute("users",userRepo.findAll());

        return "admin";
    }
}
