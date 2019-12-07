package com.drewSpan.drewSpan2.controller;

import com.drewSpan.drewSpan2.model.Wydajnosc;
import com.drewSpan.drewSpan2.service.WydajnoscService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.List;

@Controller
public class WydajnoscController {

    @Autowired
    private WydajnoscService wydajnoscService;

   /* @RequestMapping(value="/test", method= RequestMethod.GET)
    @ResponseBody
    public List<Wydajnosc> test()
    {
        wydajnoscService.dropTempTables();
        wydajnoscService.createXxx();
        wydajnoscService.createWykonanieNormy();
        wydajnoscService.createCzasCalkowity();
        wydajnoscService.createWydajnosc();
        List<Wydajnosc> listaWydajnosci = wydajnoscService.findWydajnosc();

        return listaWydajnosci;
    }*/

    @RequestMapping(value="/lista_wydajnosci" , method = RequestMethod.GET)
    public ModelAndView listaWydajnosco(ModelAndView model) throws IOException {

        wydajnoscService.dropTempTables();
        wydajnoscService.createXxx();
        wydajnoscService.createWykonanieNormy();
        wydajnoscService.createCzasCalkowity();
        wydajnoscService.createWydajnosc();
        List<Wydajnosc> listaWydajnosci = wydajnoscService.findWydajnosc();
        model.addObject("listaWydajnosci",listaWydajnosci);
        model.setViewName("admin/lista_wydajnosci");

        return model;
    }
}
