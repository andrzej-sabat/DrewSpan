package com.drewSpan.drewSpan2.controller;

import com.drewSpan.drewSpan2.model.User;
import com.drewSpan.drewSpan2.repository.RoleRepository;
import com.drewSpan.drewSpan2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    RoleRepository roleRepository;

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
    @RequestMapping(value="/lista_pracownikow", method = RequestMethod.GET)
    public ModelAndView listaPracownikow(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("admin/lista_pracownikow");
        return modelAndView;
    }

    @PostMapping("/zapisz_pracownika")
    public String saveUser(@ModelAttribute User user){
        user.setRoles(roleRepository.findRoleById(2));
        userService.save(user);

        return "redirect:/admin/lista_pracownikow";
    }

    @PostMapping("/zapisz_pracownika_tech")
    public String saveUserTech(@ModelAttribute User user){
        user.setRoles(roleRepository.findRoleById(1));
        userService.save(user);

        return "redirect:/admin/lista_pracownikow";
    }

}
