package com.drewSpan.drewSpan2.controller;

import com.drewSpan.drewSpan2.model.*;
import com.drewSpan.drewSpan2.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;
    @Autowired
    private KrMaszynyService krMaszynyService;
    @Autowired
    private IndexOpService indexOpService;
    @Autowired
    private OpTechService opTechService;
    @Autowired
    private EwidencjaService ewidencjaService;
    @Autowired
    private EwidencjaElementyService ewidencjaElementyService;

    @RequestMapping(value={"/", "/login"}, method = RequestMethod.GET)
    public ModelAndView login(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        return modelAndView;
    }

    /*
    @RequestMapping(value="/registration", method = RequestMethod.GET)
    public ModelAndView registration(){
        ModelAndView modelAndView = new ModelAndView();
        User user = new User();
        modelAndView.addObject("user", user);
        modelAndView.setViewName("registration");
        return modelAndView;
    }



    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public ModelAndView createNewUser(@Valid User user, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView();
        User userExists = userService.findUserByEmail(user.getEmail());
        if (userExists != null) {
            bindingResult
                    .rejectValue("email", "error.user",
                            "There is already a user registered with the email provided");
        }
        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("registration");
        } else {
            userService.saveUser(user);
            modelAndView.addObject("successMessage", "User has been registered successfully");
            modelAndView.addObject("user", new User());
            modelAndView.setViewName("registration");

        }
        return modelAndView;
    }
       */

    @RequestMapping(value="/user/home", method = RequestMethod.GET)
    public ModelAndView userHome(){
        ModelAndView modelAndView = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findUserByLogin(auth.getName());
        modelAndView.addObject("userName", "Witaj " + user.getLastName() + " (" + user.getLogin() + ")");
        modelAndView.addObject("adminMessage","Content Available Only for Users with Admin Role");
        modelAndView.setViewName("user/home");
        return modelAndView;
    }


    @RequestMapping(value="/admin/home", method = RequestMethod.GET)
    public ModelAndView home(){
        ModelAndView modelAndView = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findUserByLogin(auth.getName());
        modelAndView.addObject("userName", "Witaj " + user.getLastName() + " (" + user.getLogin() + ")");
        modelAndView.addObject("adminMessage","Content Available Only for Users with Admin Role");
        modelAndView.setViewName("admin/home");
        return modelAndView;
    }

    @RequestMapping(value="/delete_ewidencja/admin/home", method = RequestMethod.GET)
    public ModelAndView homeAfterDeleteEwidencja(){
        ModelAndView modelAndView = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findUserByLogin(auth.getName());
        modelAndView.addObject("userName", "Witaj " + user.getLastName() + " (" + user.getLogin() + ")");
        modelAndView.addObject("adminMessage","Content Available Only for Users with Admin Role");
        modelAndView.setViewName("admin/home");
        return modelAndView;
    }

    @RequestMapping(value="/delete_ewidencja_elementy/admin/home", method = RequestMethod.GET)
    public ModelAndView homeAfterDeleteEwidencjaElementy(){
        ModelAndView modelAndView = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findUserByLogin(auth.getName());
        modelAndView.addObject("userName", "Witaj " + user.getLastName() + " (" + user.getLogin() + ")");
        modelAndView.addObject("adminMessage","Content Available Only for Users with Admin Role");
        modelAndView.setViewName("admin/home");
        return modelAndView;
    }

    @RequestMapping(value="/dodaj_do_ewidencji", method = RequestMethod.GET)
    public ModelAndView produkcja(){
        ModelAndView modelAndView = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        User user = userService.findUserByLogin(auth.getName());
        long user_id = user.getId();
        String user_code = user.getCode();
        String user_lastName = user.getLastName();
        String user_section = user.getSection();
        String user_login = user.getLogin();

        List<KrMaszyny> listKrMaszynys = krMaszynyService.getAllKrMaszynys();
        List<IndexOp> listIndexOps = indexOpService.getAllIndexOp();
        List<OpTech> listOpTechs = opTechService.getAllOpTechs();
        long id_maszyny = krMaszynyService.getKrMaszyny(1).getKrm_id();
        Integer rozmiar_listy = listKrMaszynys.size();
        Integer rozmiar_listy_indeksow = listIndexOps.size();
        Integer rozmiar_listy_operacji = listOpTechs.size();

        modelAndView.addObject("localDate", LocalDate.now());
        modelAndView.addObject("user_id",user_id);
        modelAndView.addObject("user_code",user_code);
        modelAndView.addObject("user_lastName",user_lastName);
        modelAndView.addObject("user_section",user_section);
        modelAndView.addObject("user_login",user_login);
        modelAndView.addObject("id_maszyny",id_maszyny);
        modelAndView.addObject("listKrMaszynys", listKrMaszynys);
        modelAndView.addObject("rozmiar_listy", rozmiar_listy);
        modelAndView.addObject("listOpTechs", listOpTechs);
        modelAndView.addObject("rozmiar_listy_operacji",rozmiar_listy_operacji);
        modelAndView.addObject("listIndexOps", listIndexOps);
        modelAndView.addObject("rozmiar_listy_indeksow", rozmiar_listy_indeksow);
        modelAndView.addObject("standardDate", new Date());
        modelAndView.addObject("user",user);
        modelAndView.addObject("userName", "Witaj " + user.getLastName() + " (" + user.getLogin() + ")");
        modelAndView.addObject("userMessage","Content Available Only for Users with User Role");
        modelAndView.setViewName("user/user_home");
        return modelAndView;
    }


    @RequestMapping(value="/lista_dodanych", method = RequestMethod.GET)
    public ModelAndView kartoteki(){
        ModelAndView modelAndView = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        long user_id = userService.findUserByLogin(auth.getName()).getId();
        Date date = userService.convertToDate((LocalDate.now()));
        System.out.println(date);
        List<EwidencjaElementy> ewidencjaElementyList = ewidencjaElementyService.findAllByUserAndData(user_id,date);
        modelAndView.addObject("ewidencjaElementyList",ewidencjaElementyList);
        modelAndView.setViewName("user/lista_dodanych");
        return modelAndView;
    }




    @RequestMapping(value="/user/user_home", method = RequestMethod.GET)
    public ModelAndView userHome(HttpServletRequest request){
        ModelAndView modelAndView = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        User user = userService.findUserByLogin(auth.getName());
        long user_id = user.getId();
        String user_code = user.getCode();
        String user_lastName = user.getLastName();
        String user_section = user.getSection();
        String user_login = user.getLogin();

        List<KrMaszyny> listKrMaszynys = krMaszynyService.getAllKrMaszynys();
        List<IndexOp> listIndexOps = indexOpService.getAllIndexOp();
        List<OpTech> listOpTechs = opTechService.getAllOpTechs();
        long id_maszyny = krMaszynyService.getKrMaszyny(1).getKrm_id();
        Integer rozmiar_listy = listKrMaszynys.size();
        Integer rozmiar_listy_indeksow = listIndexOps.size();
        Integer rozmiar_listy_operacji = listOpTechs.size();

        modelAndView.addObject("user_id",user_id);
        modelAndView.addObject("user_code",user_code);
        modelAndView.addObject("user_lastName",user_lastName);
        modelAndView.addObject("user_section",user_section);
        modelAndView.addObject("user_login",user_login);
        modelAndView.addObject("id_maszyny",id_maszyny);
        modelAndView.addObject("listKrMaszynys", listKrMaszynys);
        modelAndView.addObject("rozmiar_listy", rozmiar_listy);
        modelAndView.addObject("listOpTechs", listOpTechs);
        modelAndView.addObject("rozmiar_listy_operacji",rozmiar_listy_operacji);
        modelAndView.addObject("listIndexOps", listIndexOps);
        modelAndView.addObject("rozmiar_listy_indeksow", rozmiar_listy_indeksow);
        modelAndView.addObject("standardDate", new Date());
        modelAndView.addObject("user",user);
        modelAndView.addObject("userName", "Witaj " + user.getLastName() + " (" + user.getLogin() + ")");
        modelAndView.addObject("userMessage","Content Available Only for Users with User Role");
        modelAndView.setViewName("user/user_home");
        return modelAndView;
    }

    @RequestMapping(value = "/edit_ewidencja_user", method = RequestMethod.GET)
    public ModelAndView editEwidencjaUser(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        User user = userService.findUserByLogin(auth.getName());
        long user_id = user.getId();
        String user_code = user.getCode();
        String user_lastName = user.getLastName();
        String user_section = user.getSection();
        String user_login = user.getLogin();

        List<KrMaszyny> listKrMaszynys = krMaszynyService.getAllKrMaszynys();
        List<IndexOp> listIndexOps = indexOpService.getAllIndexOp();
        List<OpTech> listOpTechs = opTechService.getAllOpTechs();
        long id_maszyny = krMaszynyService.getKrMaszyny(1).getKrm_id();
        Integer rozmiar_listy = listKrMaszynys.size();
        Integer rozmiar_listy_indeksow = listIndexOps.size();
        Integer rozmiar_listy_operacji = listOpTechs.size();

        modelAndView.addObject("user_id",user_id);
        modelAndView.addObject("user_code",user_code);
        modelAndView.addObject("user_lastName",user_lastName);
        modelAndView.addObject("user_section",user_section);
        modelAndView.addObject("user_login",user_login);
        modelAndView.addObject("id_maszyny",id_maszyny);
        modelAndView.addObject("listKrMaszynys", listKrMaszynys);
        modelAndView.addObject("rozmiar_listy", rozmiar_listy);
        modelAndView.addObject("listOpTechs", listOpTechs);
        modelAndView.addObject("rozmiar_listy_operacji",rozmiar_listy_operacji);
        modelAndView.addObject("listIndexOps", listIndexOps);
        modelAndView.addObject("rozmiar_listy_indeksow", rozmiar_listy_indeksow);
        modelAndView.addObject("standardDate", new Date());
        modelAndView.addObject("user",user);
        modelAndView.addObject("userName", "Witaj " + user.getLastName() + " (" + user.getLogin() + ")");
        modelAndView.addObject("userMessage","Content Available Only for Users with User Role");
        modelAndView.setViewName("user/user_home");
        return modelAndView;
    }

    @RequestMapping(value = "/delete_ewidencjaElementy_user", method = RequestMethod.GET)
    public ModelAndView deleteEwidencjaElementyUser(HttpServletRequest request) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        int ewidencjaElementyId = Integer.parseInt(request.getParameter("id"));
        ewidencjaElementyService.removeEwidencjaElementyById(ewidencjaElementyId);
        ModelAndView modelAndView = new ModelAndView();

        long user_id = userService.findUserByLogin(auth.getName()).getId();
        Date date = userService.convertToDate((LocalDate.now()));
        System.out.println(date);
        List<EwidencjaElementy> ewidencjaElementyList = ewidencjaElementyService.findAllByUserAndData(user_id,date);
        modelAndView.addObject("ewidencjaElementyList",ewidencjaElementyList);
        modelAndView.setViewName("user/lista_dodanych");
        return modelAndView;

    }

}
