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

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@Controller
public class EwidencjaController {

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
    @Autowired
    private EwidencjaElementyService ewidencjaElementyService;

    @RequestMapping(value="/lista_ewidencji" , method = RequestMethod.GET)
    public ModelAndView listaEwidencji(ModelAndView model) throws IOException {
        List<Ewidencja> ewidencjaList = ewidencjaService.findAllEwidencja();
        model.addObject("ewidencjaList",ewidencjaList);
        model.setViewName("admin/lista_ewidencji");

        return model;
    }

    @RequestMapping(value="/lista_elementow" , method = RequestMethod.GET)
    public ModelAndView listaElementow(ModelAndView model) throws IOException {
        List<EwidencjaElementy> ewidencjaElementyList = ewidencjaElementyService.findAllEwidencjaElementy();
        model.addObject("ewidencjaElementyList",ewidencjaElementyList);
        model.setViewName("admin/lista_elementow");

        return model;
    }

    @RequestMapping(value="/dodawanie_ewidencji", method = RequestMethod.GET)
    public ModelAndView dodawanieEwidencji(){
        ModelAndView modelAndView = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Ewidencja ewidencja = new Ewidencja();
        EwidencjaElementy ewidencjaElementy = new EwidencjaElementy();
        List<Ewidencja> listEwidencja = ewidencjaService.findAllEwidencja();
        User user = userService.findUserByLogin(auth.getName());
        long user_id = userService.findUserByLogin(auth.getName()).getId();
        List<KrMaszyny> listKrMaszynys = krMaszynyService.getAllKrMaszynys();
        List<IndexOp> listIndexOps = indexOpService.getAllIndexOp();
        List<OpTech> listOpTechs = opTechService.getAllOpTechs();
        long id_maszyny = krMaszynyService.getKrMaszyny(1).getKrm_id();
        Integer rozmiar_listy = listKrMaszynys.size();
        Integer rozmiar_listy_indeksow = listIndexOps.size();
        Integer rozmiar_listy_operacji = listOpTechs.size();


        modelAndView.addObject("ewidencjaElementy",ewidencjaElementy);
        modelAndView.addObject("user_id",user_id);
        modelAndView.addObject("id_maszyny",id_maszyny);
        modelAndView.addObject("ewidencja",ewidencja);
        modelAndView.addObject("listEwidencja",listEwidencja);
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
        int ewidencjaId = Integer.parseInt(request.getParameter("id"));

        Ewidencja ewidencja= ewidencjaService.findById(ewidencjaId);
        ModelAndView model = new ModelAndView("admin/ewidencja");
        List<Ewidencja> ewidencjaList= ewidencjaService.findAllEwidencja();
        model.addObject("ewidencjaList",ewidencjaList);


        return model;
    }

    @RequestMapping(value = "/delete_ewidencja", method = RequestMethod.GET)
    public ModelAndView deleteEwidencja(HttpServletRequest request) {
        int ewidencjaId = Integer.parseInt(request.getParameter("id"));
        ewidencjaService.removeEwidencjaById(ewidencjaId);
        ModelAndView modelAndView = new ModelAndView();
        List<Ewidencja> ewidencjaList= ewidencjaService.findAllEwidencja();
        modelAndView.addObject("ewidencjaList",ewidencjaList);
        modelAndView.setViewName("admin/lista_ewidencji");
        return modelAndView;
    }

    @PostMapping("/save_ewidencja")
    public ModelAndView saveEwidencja(@ModelAttribute Ewidencja ewidencja) {

        ewidencjaService.save(ewidencja);
        ModelAndView modelAndView = new ModelAndView();
        List<Ewidencja> ewidencjaList = ewidencjaService.findAllEwidencja();
        modelAndView.addObject("listIndexOp", ewidencjaList);
        modelAndView.setViewName("admin/home");
        return modelAndView;
    }
}
