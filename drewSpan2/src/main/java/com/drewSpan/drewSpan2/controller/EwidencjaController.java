package com.drewSpan.drewSpan2.controller;

import com.drewSpan.drewSpan2.model.Ewidencja;
import com.drewSpan.drewSpan2.model.User;
import com.drewSpan.drewSpan2.service.EwidencjaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

@Controller
public class EwidencjaController {

    @Autowired
    private EwidencjaService ewidencjaService;

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
}
