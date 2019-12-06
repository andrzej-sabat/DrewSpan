package com.drewSpan.drewSpan2.controller;

import com.drewSpan.drewSpan2.model.IndexOp;
import com.drewSpan.drewSpan2.model.OpTech;
import com.drewSpan.drewSpan2.service.IndexOpService;
import com.drewSpan.drewSpan2.service.OpTechService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@Controller
public class IndexOpController {

    public static final Logger logger = LoggerFactory.getLogger(IndexOpController.class);

    @Autowired
    private IndexOpService indexOpService;

    @RequestMapping(value="/lista_indeksow" , method = RequestMethod.GET)
    public ModelAndView ListIndexOp(ModelAndView model) throws IOException {
        List<IndexOp> listIndexOp= indexOpService.getAllIndexOp();
        model.addObject("listIndexOp", listIndexOp);
        model.setViewName("admin/lista_indeksow");

        return model;
    }

    @RequestMapping(value="/dodawanie_indeksu", method = RequestMethod.GET)
    public ModelAndView dodawanieIndeksu(){
        ModelAndView modelAndView = new ModelAndView();
        IndexOp indexOp = new IndexOp();
        modelAndView.addObject("indexOp",indexOp);
        modelAndView.setViewName("admin/dodawanie_indeksu");
        return modelAndView;
    }



    @RequestMapping(value = "/edit_indexOp", method = RequestMethod.GET)
    public ModelAndView updateIndexOp(HttpServletRequest request) {
        int indexId = Integer.parseInt(request.getParameter("id_indeksu"));

        IndexOp indexOp = indexOpService.getIndexOp(indexId);
        ModelAndView model = new ModelAndView("admin/dodawanie_indeksu");
        model.addObject("indexOp",indexOp);

        return model;
    }



    @PostMapping("/save_indexOp")
    public ModelAndView saveIndexOp(@ModelAttribute IndexOp indexOp) {
        ModelAndView modelAndView = new ModelAndView();


        try {
            indexOpService.save(indexOp);
            modelAndView.addObject("succes","Dodano operacje");
            modelAndView.setViewName("/admin/dodawanie_indeksu");
            return  modelAndView;
        }
        catch (Exception ex){
            modelAndView.addObject("error","Błąd, operacja już istnieje.");
            modelAndView.setViewName("/admin/dodawanie_indeksu");
            return modelAndView;
        }

    }


    @RequestMapping(value = "/delete_indexOp", method = RequestMethod.GET)
    public ModelAndView deleteIndexOp(HttpServletRequest request) {
        long id_indeksu = Integer.parseInt(request.getParameter("id_indeksu"));
        indexOpService.deleteIndexOp(id_indeksu);
        ModelAndView modelAndView = new ModelAndView();
        List<IndexOp> listIndexOp= indexOpService.getAllIndexOp();
        modelAndView.addObject("listIndexOp", listIndexOp);
        modelAndView.setViewName("admin/lista_indeksow");
        return modelAndView;
    }

    @RequestMapping(value="delete_indexOp/admin/home", method = RequestMethod.GET)
    public ModelAndView start(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("admin/home");
        return modelAndView;
    }

}

