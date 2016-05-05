package com.springHibernate.controller;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
 
import com.springHibernate.model.User;
import com.springHibernate.service.UserService;
 
@Controller
public class UserController {
     
    private UserService userService;
     
    @Autowired(required=true)
    @Qualifier(value="userService")
    public void setUserService(UserService userService){
        this.userService = userService;
    }
     
    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String listUsers(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("listUsers", this.userService.getUsers());
        return "user";
    }
     
    //For add and update person both
    @RequestMapping(value= "/user/add", method = RequestMethod.POST)
    public String addPerson(@ModelAttribute("user") User u){
         
        if(u.getId() == 0){
            //new person, add it
            this.userService.addUser(u);
        }else{
            //existing person, call update
            this.userService.updateUser(u);
        }
         
        return "redirect:/users";
         
    }
     
    @RequestMapping("/remove/{id}")
    public String removePerson(@PathVariable("id") int id){
         
        this.userService.removeUser(id);
        return "redirect:/users";
    }
  
    @RequestMapping("/edit/{id}")
    public String editPerson(@PathVariable("id") int id, Model model){
        model.addAttribute("user", this.userService.getUser(id));
        model.addAttribute("listUsers", this.userService.getUsers());
        return "user";
    }
     
}