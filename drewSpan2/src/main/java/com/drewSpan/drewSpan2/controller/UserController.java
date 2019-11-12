package com.drewSpan.drewSpan2.controller;

import com.drewSpan.drewSpan2.model.IndexOp;
import com.drewSpan.drewSpan2.model.Role;
import com.drewSpan.drewSpan2.model.User;
import com.drewSpan.drewSpan2.repository.RoleRepository;
import com.drewSpan.drewSpan2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    RoleRepository roleRepository;

    @RequestMapping(value="/lista_pracownikow" , method = RequestMethod.GET)
    public ModelAndView listaPracownikow(ModelAndView model) throws IOException {
        List<User> listUsers = userService.findAllUsers();
        model.addObject("listUsers", listUsers);
        model.setViewName("admin/lista_pracownikow");

        return model;
    }

    @RequestMapping(value="/dodawanie_pracownika", method = RequestMethod.GET)
    public ModelAndView dodawaniePracownika(){
        ModelAndView modelAndView = new ModelAndView();
        User user = new User();
        modelAndView.addObject("user",user);
        modelAndView.setViewName("admin/dodawanie_pracownika");
        return modelAndView;
    }

    @RequestMapping(value="/dodawanie_pracownika_tech", method = RequestMethod.GET)
    public ModelAndView dodawaniePracownikaTech(){
        ModelAndView modelAndView = new ModelAndView();
        User user = new User();
        modelAndView.addObject("user",user);
        modelAndView.setViewName("admin/dodawanie_pracownika_tech");
        return modelAndView;
    }

    @RequestMapping(value = "/edit_user", method = RequestMethod.GET)
    public ModelAndView updateUser(HttpServletRequest request) {
        int userId = Integer.parseInt(request.getParameter("id"));
        User user=userService.findById(userId);
        ModelAndView model = new ModelAndView("admin/dodawanie_pracownika");
        model.addObject("user",user);


        return model;
    }

    @RequestMapping(value = "/edit_user_tech", method = RequestMethod.GET)
    public ModelAndView updateUserTech(HttpServletRequest request) {
        int userId = Integer.parseInt(request.getParameter("id"));
        User user=userService.findById(userId);
        ModelAndView model = new ModelAndView("admin/dodawanie_pracownika_tech");
        model.addObject("user",user);

        return model;
    }


    @PostMapping("/zapisz_pracownika")
    public ModelAndView saveuser(@ModelAttribute User user, BindingResult result) {
        ModelAndView modelAndView = new ModelAndView();
        List<User> listUsers= userService.findAllUsers();
        modelAndView.addObject("listUsers", listUsers);

        User userInDatabase = userService.findUserByLogin(user.getLogin());
        if(userInDatabase != null){
            result.addError(new ObjectError("userExists","Login juz istnieje"));
        }
        if(result.hasErrors()){
            modelAndView.addObject("user",user);
            modelAndView.setViewName("admin/lista_pracownikow");
            return modelAndView;
        }

        user.setRoles(roleRepository.findRoleById(2));
        userService.save(user);
        return modelAndView;
    }

    @PostMapping("/zapisz_pracownika_tech")
    public ModelAndView saveusertech(@ModelAttribute User user,BindingResult result) {
        ModelAndView modelAndView = new ModelAndView();
        List<User> listUsers= userService.findAllUsers();
        modelAndView.addObject("listUsers", listUsers);



        User userInDatabase = userService.findUserByLogin(user.getLogin());
        if(userInDatabase != null){
            result.addError(new ObjectError("userExists","Login juz istnieje"));
        }
        if(result.hasErrors()){
            modelAndView.addObject("user",user);
            modelAndView.setViewName("admin/lista_pracownikow");
            return modelAndView;
        }


        user.setRoles(roleRepository.findRoleById(1));
        userService.save(user);
        return modelAndView;
    }

    @RequestMapping(value = "/delete_user", method = RequestMethod.GET)
    public ModelAndView deleteUser(HttpServletRequest request) {
        int userId = Integer.parseInt(request.getParameter("id"));
        userService.removeUserById((long) userId);
        ModelAndView modelAndView = new ModelAndView();
        List<User> listUsers= userService.findAllUsers();
        modelAndView.addObject("listUsers", listUsers);
        modelAndView.setViewName("admin/lista_pracownikow");
        return modelAndView;
    }

    @RequestMapping(value="delete_user/admin/home", method = RequestMethod.GET)
    public ModelAndView start(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("admin/home");
        return modelAndView;
    }





}
