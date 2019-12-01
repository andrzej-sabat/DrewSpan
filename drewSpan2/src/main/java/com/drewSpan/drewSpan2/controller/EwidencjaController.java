package com.drewSpan.drewSpan2.controller;

import com.drewSpan.drewSpan2.model.*;
import com.drewSpan.drewSpan2.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;
import javax.sound.sampled.Line;
import javax.xml.crypto.Data;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Controller
public class EwidencjaController {

    @Autowired
    private  EwidencjaElementyService ewidencjaElementyService;
    @Autowired
    private EwidencjaService ewidencjaService;
    @Autowired
    private UserService userService;
    @Autowired
    private KrMaszynyService krMaszynyService;
    @Autowired
    private IndexOpService indexOpService;
    @Autowired
    private OpTechService opTechService;

    @RequestMapping(value="/lista_ewidencji" , method = RequestMethod.GET)
    public ModelAndView listaEwidencji(ModelAndView model) throws IOException {
        List<Ewidencja> ewidencjaList = ewidencjaService.findAllEwidencja();
        model.addObject("ewidencjaList",ewidencjaList);
        model.setViewName("admin/lista_ewidencji");

        return model;
    }

    @RequestMapping(value="/dodawanie_ewidencji", method = RequestMethod.GET)
    public ModelAndView dodawanieEwidencji(){
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
        modelAndView.setViewName("admin/ewidencja");
        return modelAndView;
    }

    @RequestMapping(value = "/edit_ewidencja", method = RequestMethod.GET)
    public ModelAndView editEwidencja(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        int ewidencjaId = Integer.parseInt(request.getParameter("id"));
        Ewidencja ewidencja = ewidencjaService.findById(ewidencjaId);
        EwidencjaElementy ewidencjaElementy = ewidencjaElementyService.findByEwidencja(ewidencja);

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        User user = userService.findUserByLogin(auth.getName());
        long user_id = user.getId();
        String user_code = user.getCode();
        String user_lastName = user.getLastName();
        String user_section = user.getSection();
        String user_name = user.getName();
        List<Ewidencja> ewidencjaList= ewidencjaService.findAllEwidencja();
        List<KrMaszyny> listKrMaszynys = krMaszynyService.getAllKrMaszynys();
        List<IndexOp> listIndexOps = indexOpService.getAllIndexOp();
        List<OpTech> listOpTechs = opTechService.getAllOpTechs();
        List<User> userList = userService.findAllUsers();

        long id_maszyny = krMaszynyService.getKrMaszyny(1).getKrm_id();
        Integer rozmiar_listy = listKrMaszynys.size();
        Integer rozmiar_listy_indeksow = listIndexOps.size();
        Integer rozmiar_listy_operacji = listOpTechs.size();
        modelAndView.addObject("ewidencja",ewidencja);
        modelAndView.addObject("ewidencjaElementy",ewidencjaElementy);
        modelAndView.addObject("ewidencjaList",ewidencjaList);
        modelAndView.addObject("listKrMaszynys", listKrMaszynys);
        modelAndView.addObject("userList",userList);
        modelAndView.addObject("rozmiar_listy", rozmiar_listy);
        modelAndView.addObject("listOpTechs", listOpTechs);
        modelAndView.addObject("rozmiar_listy_operacji",rozmiar_listy_operacji);
        modelAndView.addObject("listIndexOps", listIndexOps);
        modelAndView.addObject("rozmiar_listy_indeksow", rozmiar_listy_indeksow);
        modelAndView.addObject("id_maszyny",id_maszyny);
        modelAndView.addObject("user_id",user_id);
        modelAndView.addObject("user_code",user_code);
        modelAndView.addObject("user_lastName",user_lastName);
        modelAndView.addObject("user_section",user_section);
        modelAndView.addObject("user_name",user_name);

        modelAndView.setViewName("admin/ewidencja");
        return modelAndView;
    }

    @RequestMapping(value = "/delete_ewidencja", method = RequestMethod.GET)
    public ModelAndView deleteEwidencja(HttpServletRequest request) {
        int ewidencjaId = Integer.parseInt(request.getParameter("id"));
        Ewidencja ewidencja = ewidencjaService.findById(ewidencjaId);
        ewidencjaService.removeEwidencjaById(ewidencjaId);

        ModelAndView modelAndView = new ModelAndView();
        List<Ewidencja> ewidencjaList= ewidencjaService.findAllEwidencja();
        modelAndView.addObject("ewidencjaList",ewidencjaList);
        modelAndView.setViewName("admin/lista_ewidencji");
        return modelAndView;
    }
    @RequestMapping(value = "/delete_ewidencja_elementy", method = RequestMethod.GET)
    public ModelAndView deleteEwidencjaElementy(HttpServletRequest request) {
        int ewidencjaElementyId = Integer.parseInt(request.getParameter("id"));
        ewidencjaElementyService.removeEwidencjaElementyById(ewidencjaElementyId);
        ModelAndView modelAndView = new ModelAndView();
        List<EwidencjaElementy> ewidencjaElementyList= ewidencjaElementyService.findAllEwidencjaElementy();
        modelAndView.addObject("ewidencjaElementyList",ewidencjaElementyList);
        modelAndView.setViewName("admin/lista_ewidencji_elementy");
        return modelAndView;
    }

    @PostMapping("/save_ewidencja")
    public ModelAndView saveEwidencja(@ModelAttribute Ewidencja ewidencja, @ModelAttribute EwidencjaElementy ewidencjaElementy) {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        long user_id = userService.findUserByLogin(auth.getName()).getId();
        Date date = userService.convertToDate((LocalDate.now()));

        List<Ewidencja> ewidencjaListByDate = ewidencjaService.findAllByUserAndData(user_id,date);
        if(ewidencjaListByDate.size()<1){

            ewidencjaService.save(ewidencja);
            ewidencjaElementy.setEwidencja(ewidencja);
            ewidencjaElementyService.save(ewidencjaElementy);
        }
        else {

            Ewidencja istniejaca_ewidencja = ewidencjaListByDate.get(0);
            ewidencjaElementy.setEwidencja(istniejaca_ewidencja);
            ewidencjaElementyService.save(ewidencjaElementy);

        };

        ModelAndView modelAndView = new ModelAndView();
        List<Ewidencja> ewidencjaList = ewidencjaService.findAllEwidencja();
        List<EwidencjaElementy> ewidencjaElementyList = ewidencjaElementyService.findAllEwidencjaElementy();
        User user = userService.findUserByLogin(auth.getName());
        String user_code = user.getCode();
        String user_lastName = user.getLastName();
        String user_section = user.getSection();
        String user_name = user.getName();
        String user_login = user.getLogin();

        List<KrMaszyny> listKrMaszynys = krMaszynyService.getAllKrMaszynys();
        List<IndexOp> listIndexOps = indexOpService.getAllIndexOp();
        List<OpTech> listOpTechs = opTechService.getAllOpTechs();
        List<User> userList = userService.findAllUsers();

        long id_maszyny = krMaszynyService.getKrMaszyny(1).getKrm_id();
        Integer rozmiar_listy = listKrMaszynys.size();
        Integer rozmiar_listy_indeksow = listIndexOps.size();
        Integer rozmiar_listy_operacji = listOpTechs.size();
        modelAndView.addObject("ewidencjaList", ewidencjaList);
        modelAndView.addObject("ewidencjaElementyList", ewidencjaElementyList);
        modelAndView.addObject("ewidencja",ewidencja);
        modelAndView.addObject("ewidencjaElementy",ewidencjaElementy);
        modelAndView.addObject("ewidencjaList",ewidencjaList);
        modelAndView.addObject("listKrMaszynys", listKrMaszynys);
        modelAndView.addObject("userList",userList);
        modelAndView.addObject("rozmiar_listy", rozmiar_listy);
        modelAndView.addObject("listOpTechs", listOpTechs);
        modelAndView.addObject("rozmiar_listy_operacji",rozmiar_listy_operacji);
        modelAndView.addObject("listIndexOps", listIndexOps);
        modelAndView.addObject("rozmiar_listy_indeksow", rozmiar_listy_indeksow);
        modelAndView.addObject("id_maszyny",id_maszyny);
        modelAndView.addObject("user_id",user_id);
        modelAndView.addObject("user_code",user_code);
        modelAndView.addObject("user_login",user_login);
        modelAndView.addObject("user_lastName",user_lastName);
        modelAndView.addObject("user_section",user_section);
        modelAndView.addObject("user_name",user_name);
        modelAndView.addObject("standardDate", new Date());

        modelAndView.setViewName("admin/ewidencja");
        return modelAndView;
    }

    @PostMapping("/save_ewidencja_user")
    public ModelAndView saveEwidencjaUser(@ModelAttribute Ewidencja ewidencja, @ModelAttribute EwidencjaElementy ewidencjaElementy) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        long user_id = userService.findUserByLogin(auth.getName()).getId();
        Date date = userService.convertToDate((LocalDate.now()));

        List<Ewidencja> ewidencjaListByDate = ewidencjaService.findAllByUserAndData(user_id,date);
        if(ewidencjaListByDate.size()<1){

            ewidencjaService.save(ewidencja);
            ewidencjaElementy.setEwidencja(ewidencja);
            ewidencjaElementyService.save(ewidencjaElementy);
        }
        else {

            Ewidencja istniejaca_ewidencja = ewidencjaListByDate.get(0);
            ewidencjaElementy.setEwidencja(istniejaca_ewidencja);
            ewidencjaElementyService.save(ewidencjaElementy);

        };


        ModelAndView modelAndView = new ModelAndView();

        User user = userService.findUserByLogin(auth.getName());
        /*long user_id = user.getId();*/
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

    @RequestMapping(value="/lista_ewidencji_elementy" , method = RequestMethod.GET)
    public ModelAndView listaEwidencjiElementy(ModelAndView model) throws IOException {
        List<EwidencjaElementy> ewidencjaElementyList = ewidencjaElementyService.findAllEwidencjaElementy();
        model.addObject("ewidencjaElementyList",ewidencjaElementyList);
        model.setViewName("admin/lista_ewidencji_elementy");
        return model;
    }
}
