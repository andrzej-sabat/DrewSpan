package com.drewSpan.drewSpan2.controller;

import com.drewSpan.drewSpan2.model.*;
import com.drewSpan.drewSpan2.service.*;
import jdk.internal.util.xml.impl.Input;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@Controller
public class IndexOpElementyController {
    @Autowired
    private IndexOpElementyService indexOpElementyService;
    @Autowired
    private UserService userService;
    @Autowired
    private KrMaszynyService krMaszynyService;
    @Autowired
    private IndexOpService indexOpService;
    @Autowired
    private OpTechService opTechService;





    @PostMapping("/save_index_op_tech")
    public ModelAndView saveIndexOpTech(@ModelAttribute IndexOpElementy indexOpElementy) {

        ModelAndView modelAndView = new ModelAndView();
        List<IndexOpElementy> indexOpElementyList = indexOpElementyService.getAllIndexOpElementy();
        List<KrMaszyny> listKrMaszynys = krMaszynyService.getAllKrMaszynys();
        List<IndexOp> listIndexOps = indexOpService.getAllIndexOp();
        List<OpTech> listOpTechs = opTechService.getAllOpTechs();
        Integer rozmiar_listy = listKrMaszynys.size();
        Integer rozmiar_listy_indeksow = listIndexOps.size();
        Integer rozmiar_listy_operacji = listOpTechs.size();

        modelAndView.addObject("rozmiar_listy", rozmiar_listy);
        modelAndView.addObject("listOpTechs", listOpTechs);
        modelAndView.addObject("listKrMaszynys", listKrMaszynys);
        modelAndView.addObject("rozmiar_listy_operacji",rozmiar_listy_operacji);
        modelAndView.addObject("listIndexOps", listIndexOps);
        modelAndView.addObject("rozmiar_listy_indeksow", rozmiar_listy_indeksow);
        modelAndView.addObject("wspK",indexOpElementy.getWspK());
        modelAndView.addObject("czas",indexOpElementy.getCzas());
        modelAndView.addObject("opTech",indexOpElementy.getOpTech());
        modelAndView.addObject("indexOpElementyList", indexOpElementyList);
        modelAndView.addObject("indexOp",indexOpElementy.getIndexOp());
        modelAndView.addObject("indexOpElementy",indexOpElementy);
        indexOpElementyService.save(indexOpElementy);
        modelAndView.setViewName("admin/indeks_operacje_technologiczne");
        return modelAndView;
    }






    @RequestMapping(value="/indeks_operacje_technologiczne", method = RequestMethod.GET)
    public ModelAndView indeks_operacje_technologiczne(HttpServletRequest request){
        ModelAndView modelAndView = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        IndexOpElementy indexOpElementy = new IndexOpElementy();

        User user = userService.findUserByLogin(auth.getName());
        List<IndexOpElementy> listIndexOpElementy =indexOpElementyService.getAllIndexOpElementy();
        List<KrMaszyny> listKrMaszynys = krMaszynyService.getAllKrMaszynys();
        List<IndexOp> listIndexOps = indexOpService.getAllIndexOp();
        List<OpTech> listOpTechs = opTechService.getAllOpTechs();
        Integer rozmiar_listy = listKrMaszynys.size();
        Integer rozmiar_listy_indeksow = listIndexOps.size();
        Integer rozmiar_listy_operacji = listOpTechs.size();

        modelAndView.addObject("indexOpElementy",indexOpElementy);
        modelAndView.addObject("listIndexOpElementy",listIndexOpElementy);
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
        modelAndView.setViewName("admin/indeks_operacje_technologiczne");
        return modelAndView;
    }
}
