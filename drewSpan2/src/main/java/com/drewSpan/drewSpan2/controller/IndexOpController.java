package com.drewSpan.drewSpan2.controller;

import com.drewSpan.drewSpan2.model.IndexOp;
import com.drewSpan.drewSpan2.model.OpTech;
import com.drewSpan.drewSpan2.service.IndexOpService;
import com.drewSpan.drewSpan2.service.OpTechService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexOpController {
    @Autowired
    private IndexOpService indexOpService;

    @RequestMapping(value="/dodawanie_indeksu", method = RequestMethod.GET)
    public ModelAndView dodawanieIndeksu(){
        ModelAndView modelAndView = new ModelAndView();
        IndexOp indexOp = new IndexOp();
        modelAndView.addObject("indexOp",indexOp);
        modelAndView.setViewName("admin/dodawanie_indeksu");
        return modelAndView;
    }



    @PostMapping("/save_indeks")
    public String saveOpTech(@ModelAttribute IndexOp indexOp) {

        indexOpService.save(indexOp);

        return "redirect:/admin/dodawanie_operacji";
    }
}

