package com.drewSpan.drewSpan2.controller;

import com.drewSpan.drewSpan2.model.*;
import com.drewSpan.drewSpan2.service.*;
import com.sun.javafx.collections.MappingChange;
import jdk.internal.util.xml.impl.Input;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;


@Controller
public class IndexOpElementyController {
    @Autowired
    private IndexOpElementyService indexOpElementyService;
    @Autowired
    private UserService userService;

    @Autowired
    private IndexOpService indexOpService;
    @Autowired
    private OpTechService opTechService;





    @PostMapping("/save_index_op_tech")
    public ModelAndView saveIndexOpTech(@ModelAttribute IndexOpElementy indexOpElementy) {
        indexOpElementyService.save(indexOpElementy);
        ModelAndView modelAndView = new ModelAndView();
        List<IndexOpElementy> indexOpElementyList = indexOpElementyService.getAllIndexOpElementy();
        List<IndexOp> listIndexOps = indexOpService.getAllIndexOp();
        List<OpTech> listOpTechs = opTechService.getAllOpTechs();
        System.out.println(indexOpElementy.getCzas());
        System.out.println(indexOpElementy.getWspK());
        System.out.println(indexOpElementy.getIndexOp().getI_nazwa());
        System.out.println(indexOpElementy.getOpTech().getOpt_nazwa());
        modelAndView.addObject("listOpTechs", listOpTechs);
        modelAndView.addObject("listIndexOps", listIndexOps);
        modelAndView.addObject("indexOpElementyList", indexOpElementyList);
        modelAndView.addObject("indexOpElementy",indexOpElementy);
        modelAndView.setViewName("admin/indeks_operacje_technologiczne");
        return modelAndView;
    }


/*
    @RequestMapping(value = "/save_index_op_tech", method = RequestMethod.POST)
    public String saveIndexOpTech(@ModelAttribute("indexOpElementy")IndexOpElementy indexOpElementy, Model model){

        model.addAttribute("indexOp",indexOpElementy);
        model.addAttribute("opTech",indexOpElementy);
        model.addAttribute("czas",indexOpElementy);
        model.addAttribute("wspK",indexOpElementy);
        indexOpElementyService.save(indexOpElementy);

        return "redirect:/indeks_operacje_technologiczne";
    }

 */


/*
@RequestMapping(params = "save", value = "/save_index_op_tech", method = RequestMethod.POST)
public String save(
        @RequestParam Map<String,String> allRequestParams,
        @ModelAttribute(value="indexOpElementy") IndexOpElementy indexOpElementy, Model model)
{
    model.

}
*/













    @RequestMapping(value="/indeks_operacje_technologiczne_menu", method = RequestMethod.GET)
    public ModelAndView indeks_operacje_technologiczne_menu(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("admin/indeks_operacje_technologiczne_menu");
        return modelAndView;
    }

    @RequestMapping(value="/indeks_operacje_technologiczne", method = RequestMethod.GET)
    public ModelAndView indeks_operacje_technologiczne(){
        ModelAndView modelAndView = new ModelAndView();
        //Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        IndexOpElementy indexOpElementy = new IndexOpElementy();

        //User user = userService.findUserByLogin(auth.getName());
        List<IndexOpElementy> listIndexOpElementy =indexOpElementyService.getAllIndexOpElementy();

        List<IndexOp> listIndexOps = indexOpService.getAllIndexOp();
        List<OpTech> listOpTechs = opTechService.getAllOpTechs();
        //Integer rozmiar_listy = listKrMaszynys.size();
        //Integer rozmiar_listy_indeksow = listIndexOps.size();
        //Integer rozmiar_listy_operacji = listOpTechs.size();

        modelAndView.addObject("indexOpElementy",indexOpElementy);
        modelAndView.addObject("listIndexOpElementy",listIndexOpElementy);
        //modelAndView.addObject("rozmiar_listy", rozmiar_listy);
        modelAndView.addObject("listOpTechs", listOpTechs);
        //modelAndView.addObject("rozmiar_listy_operacji",rozmiar_listy_operacji);
        modelAndView.addObject("listIndexOps", listIndexOps);
        //modelAndView.addObject("rozmiar_listy_indeksow", rozmiar_listy_indeksow);
        modelAndView.addObject("standardDate", new Date());
        //modelAndView.addObject("user",user);
        //modelAndView.addObject("userName", "Witaj " +  user.getLastName() + " (" + user.getLogin() + ")");
        //modelAndView.addObject("userMessage","Content Available Only for Users with User Role");
        modelAndView.setViewName("admin/indeks_operacje_technologiczne");
        return modelAndView;
    }

    @RequestMapping(value="/indeks_operacje_technologiczne_lista" , method = RequestMethod.GET)
    public ModelAndView listaIndexow(ModelAndView model) throws IOException {
        List<IndexOpElementy> listIndexOpElementy= indexOpElementyService.getAllIndexOpElementy();
        model.addObject("listIndexOpElementy", listIndexOpElementy);
        model.setViewName("admin/indeks_operacje_technologiczne_lista");

        return model;
    }

}
