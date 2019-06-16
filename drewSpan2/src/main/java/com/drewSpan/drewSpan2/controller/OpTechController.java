package com.drewSpan.drewSpan2.controller;

import com.drewSpan.drewSpan2.model.OpTech;
import com.drewSpan.drewSpan2.service.OpTechService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class OpTechController {

    @Autowired
    private OpTechService opTechService;

    @RequestMapping(value="/dodawanie_operacji", method = RequestMethod.GET)
    public ModelAndView dodawanieOperacji(){
        ModelAndView modelAndView = new ModelAndView();
        OpTech opTech = new OpTech();
        modelAndView.addObject("opTech",opTech);
        modelAndView.setViewName("admin/dodawanie_operacji");
        return modelAndView;
    }



    @PostMapping("/save_op_tech")
    public String saveOpTech(@ModelAttribute OpTech opTech) {

        opTechService.save(opTech);

        return "redirect:/admin/dodawanie_operacji";
    }
}
