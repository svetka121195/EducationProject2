package app.controller;

import app.model.User;
import app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.naming.Context;
import java.security.Principal;

/**
 * Created by Светлана on 30.07.2018.
 */

@SessionAttributes("roles")
@Controller
public class UserController {
    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/error", method = RequestMethod.GET)
    public String error(Model model){
        return "error";
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public String user(Model model){
        model.addAttribute("currentUser", getPrincipal());
        return "user";
    }

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String usersList(Model model){
        model.addAttribute("usersList", userService.getAllUsers());
        return "admin";
    }

    @RequestMapping(value = "/admin", method = RequestMethod.POST)
    public String addUser(@ModelAttribute("user") User user){
        userService.addUser(user);
        return "redirect:/admin";
    }

    @RequestMapping(value = "/admin/delete", method = RequestMethod.POST)
    public String deleteUser(long id){
        userService.deleteUser(id);
        return "redirect:/admin";
    }

    @RequestMapping(value = "/admin/edit", method = RequestMethod.POST)
    public String updateUser(@ModelAttribute("user") User user){
        userService.updateUser(user);
        return "redirect:/admin";
    }

    @RequestMapping(value = "/admin/edit", method = RequestMethod.GET)
    public String userData(@ModelAttribute("user") User user, Model model){
        model.addAttribute("user", userService.getUser(user.getId()));
        return "edit";
    }


    private User getPrincipal(){
        User principal = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return principal;
    }
}
