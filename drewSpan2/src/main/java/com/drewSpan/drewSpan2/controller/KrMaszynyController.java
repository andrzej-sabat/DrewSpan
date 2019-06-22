package com.drewSpan.drewSpan2.controller;

import com.drewSpan.drewSpan2.model.KrMaszyny;
import com.drewSpan.drewSpan2.service.KrMaszynyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

@Controller
public class KrMaszynyController {

    @Autowired
    private KrMaszynyService krMaszynyService;

    @RequestMapping(value="/lista_maszyn" , method = RequestMethod.GET)
    public ModelAndView ListKrMaszyny(ModelAndView model) throws IOException {
        List<KrMaszyny> listKrMaszynys = krMaszynyService.getAllKrMaszynys();
        model.addObject("listKrMaszynys", listKrMaszynys);
        model.setViewName("admin/lista_maszyn");

        return model;
    }

    @RequestMapping(value="/dodawanie_maszyny", method = RequestMethod.GET)
    public ModelAndView dodawanieKrMaszyny(){
        ModelAndView modelAndView = new ModelAndView();
        KrMaszyny krMaszyny = new KrMaszyny();
        modelAndView.addObject("krMaszyny",krMaszyny);
        modelAndView.setViewName("admin/dodawanie_maszyny");
        return modelAndView;
    }


    @RequestMapping(value = "/edit_krmaszyny", method = RequestMethod.GET)
    public ModelAndView updateKrMaszyny(HttpServletRequest request) {
        int krm_id = Integer.parseInt(request.getParameter("krm_id"));

        KrMaszyny krMaszyny=krMaszynyService.getKrMaszyny(krm_id);
        ModelAndView model = new ModelAndView("admin/dodawanie_maszyny");
        model.addObject("krMaszyny",krMaszyny);

        return model;
    }



    @PostMapping("/save_krmaszyny")
    public ModelAndView saveKrMaszynyh(@ModelAttribute KrMaszyny krMaszyny) {

        krMaszynyService.save(krMaszyny);
        ModelAndView modelAndView = new ModelAndView();
        List<KrMaszyny> listKrMaszynys = krMaszynyService.getAllKrMaszynys();
        modelAndView.addObject("listKrMaszynys", listKrMaszynys);
        modelAndView.addObject("krMaszyny",krMaszyny);
        modelAndView.setViewName("admin/lista_maszyn");
        return modelAndView;
    }


    @RequestMapping(value = "/delete_krmaszyny", method = RequestMethod.GET)
    public ModelAndView deleteKrMaszyny(HttpServletRequest request) {
        long krm_id = Integer.parseInt(request.getParameter("krm_id"));
        krMaszynyService.deleteKrMaszyny(krm_id);
        ModelAndView modelAndView = new ModelAndView();
        List<KrMaszyny> listKrMaszynys = krMaszynyService.getAllKrMaszynys();
        modelAndView.addObject("listKrMaszynys", listKrMaszynys);
        modelAndView.setViewName("admin/lista_maszyn");
        return modelAndView;
    }

    @RequestMapping(value="delete_krmaszyny/admin/home", method = RequestMethod.GET)
    public ModelAndView start(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("admin/home");
        return modelAndView;
    }







}

