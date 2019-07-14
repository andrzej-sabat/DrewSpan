package com.drewSpan.drewSpan2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MenuAdmin {
    @RequestMapping(value="/produkcja", method = RequestMethod.GET)
    public ModelAndView produkcja(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("admin/produkcja");
        return modelAndView;
    }
    @RequestMapping(value="/dodawanie_ewidencji", method = RequestMethod.GET)
    public ModelAndView dodawanieEwidencji(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("admin/ewidencja");
        return modelAndView;
    }



    @RequestMapping(value="/kartoteki", method = RequestMethod.GET)
    public ModelAndView kartoteki(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("admin/kartoteki");
        return modelAndView;
    }

    @RequestMapping(value="/operacje_technologiczne", method = RequestMethod.GET)
    public ModelAndView operacjeTechnologiczne(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("admin/operacje_technologiczne");
        return modelAndView;
    }

    @RequestMapping(value="/kartoteka_pracownikow", method = RequestMethod.GET)
    public ModelAndView kartotekaPracownikow(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("admin/kartoteka_pracownikow");
        return modelAndView;
    }

    @RequestMapping(value="/kartoteka_maszyn", method = RequestMethod.GET)
    public ModelAndView kartotekaMaszyn(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("admin/kartoteka_maszyn");
        return modelAndView;
    }

    @RequestMapping(value="/operacje_indeks", method = RequestMethod.GET)
    public ModelAndView operacjeIndeks(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("admin/operacje_indeks");
        return modelAndView;
    }

    @RequestMapping(value="/indeks_operacje_technologiczne", method = RequestMethod.GET)
    public ModelAndView indeks_operacje_technologiczne(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("admin/indeks_operacje_technologiczne");
        return modelAndView;
    }



}
