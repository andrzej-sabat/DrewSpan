package com.drewSpan.drewSpan2.controller;

import com.drewSpan.drewSpan2.model.OpTech;
import com.drewSpan.drewSpan2.service.OpTechService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
public class OpTechController {

    public static final Logger logger = LoggerFactory.getLogger(OpTechController.class);

    @Autowired
    private OpTechService OpTechService;

    @RequestMapping(value="/lista_operacji" , method = RequestMethod.GET)
    public ModelAndView ListOpTechs(ModelAndView model) throws IOException {
        List<OpTech> listOpTechs = OpTechService.getAllOpTechs();
        model.addObject("listOpTechs", listOpTechs);
        model.setViewName("admin/lista_operacji");

        return model;
    }

    @RequestMapping(value="/dodawanie_operacji", method = RequestMethod.GET)
    public ModelAndView dodawanieOperacji(){
        ModelAndView modelAndView = new ModelAndView();
        OpTech opTech = new OpTech();
        modelAndView.addObject("opTech",opTech);
        modelAndView.setViewName("admin/dodawanie_operacji");
        return modelAndView;
    }


    @RequestMapping(value = "/edit_opTech", method = RequestMethod.GET)
    public ModelAndView updateOpTech(HttpServletRequest request) {
        int opTechId = Integer.parseInt(request.getParameter("opt_id"));

        OpTech opTech=OpTechService.getOpTech(opTechId);
        ModelAndView model = new ModelAndView("admin/dodawanie_operacji");
        model.addObject("opTech",opTech);

        return model;
    }



    @PostMapping("/save_op_tech")
    public ModelAndView saveOpTechh(@ModelAttribute OpTech opTech) {

        OpTechService.save(opTech);
        ModelAndView modelAndView = new ModelAndView();
        List<OpTech> listOpTechs = OpTechService.getAllOpTechs();
        modelAndView.addObject("listOpTechs", listOpTechs);
        modelAndView.addObject("opTech",opTech);
        modelAndView.setViewName("admin/lista_operacji");
        return modelAndView;
    }


    @RequestMapping(value = "/delete_opTech", method = RequestMethod.GET)
    public ModelAndView deleteOpTech(HttpServletRequest request) {
        long opTechId = Integer.parseInt(request.getParameter("opt_id"));
        OpTechService.deleteOpTech(opTechId);
        ModelAndView modelAndView = new ModelAndView();
        List<OpTech> listOpTechs = OpTechService.getAllOpTechs();
        modelAndView.addObject("listOpTechs", listOpTechs);
        modelAndView.setViewName("admin/lista_operacji");
        return modelAndView;
    }

    @RequestMapping(value="delete_opTech/admin/home", method = RequestMethod.GET)
    public ModelAndView start(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("admin/home");
        return modelAndView;
    }







}
