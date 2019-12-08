package com.drewSpan.drewSpan2.controller;

import com.drewSpan.drewSpan2.model.SomeBean;
import com.drewSpan.drewSpan2.model.Wydajnosc;
import com.drewSpan.drewSpan2.service.WydajnoscService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.List;

@Controller
public class WydajnoscController {

    @Autowired
    private WydajnoscService wydajnoscService;

    int year,month;

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
/*
    @RequestMapping(value="/wydajnosc_data",method = RequestMethod.GET)
    public ModelAndView wydajnoscData(ModelAndView modelAndView){
        modelAndView.setViewName("/admin/wydajnosc_data");
        return modelAndView;

    }


    @RequestMapping(value="/wydajnosc_szukaj",method = RequestMethod.GET)
    public String showPage(Model model){



        return "/admin/lista_wydajnosci_po_dacie";
    }

 */

    @RequestMapping(value="/wydajnosc_data",method = RequestMethod.GET)
    public ModelAndView wydajnoscData(ModelAndView modelAndView){
        modelAndView.setViewName("/admin/wydajnosc_data");
        return modelAndView;

    }

    @GetMapping("/wydajnosc_szukaj")
    public String ShowPage(Model model){
        model.addAttribute("someBean", new SomeBean());
        return "wydajnosc_szukaj";
    }

    @PostMapping("/wydajnosc_szukaj")
    public ModelAndView showPage(@ModelAttribute("someBean")SomeBean someBean){
        ModelAndView model = new ModelAndView();
        year = someBean.getYear();
        month = someBean.getMonth();
        //System.out.println("y:"+year + "m: "+month);
        wydajnoscService.dropTempTables();
        wydajnoscService.createXxx();
        wydajnoscService.createWykonanieNormy();
        wydajnoscService.createCzasCalkowity();
        wydajnoscService.createWydajnosc();
        List<Wydajnosc> listaWydajnosci = wydajnoscService.findWydajnoscByDate(year,month);
        model.addObject("listaWydajnosci",listaWydajnosci);
        model.setViewName("admin/lista_wydajnosci_po_dacie");
        return model;
    }

    @RequestMapping(value="/admin/lista_wydajnosci_po_dacie" , method = RequestMethod.GET)
    public ModelAndView listaWydajnosciByDate(ModelAndView model ){
        System.out.println("test!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");

        model.setViewName("admin/lista_wydajnosci_po_dacie");
        return model;
    }

/*
    @RequestMapping(value="/lista_wydajnosci_po_dacie" , method = RequestMethod.GET)
    public ModelAndView listaWydajnosciByDate2(ModelAndView model, @ModelAttribute("someBean") SomeBean someBean) throws IOException {

        System.out.println("y:"+someBean.getYear()  + "m: "+ someBean.getMonth());

        wydajnoscService.dropTempTables();
        wydajnoscService.createXxx();
        wydajnoscService.createWykonanieNormy();
        wydajnoscService.createCzasCalkowity();
        wydajnoscService.createWydajnosc();
        List<Wydajnosc> listaWydajnosci = wydajnoscService.findWydajnoscByDate(year,month);
        model.addObject("listaWydajnosci",listaWydajnosci);
        model.setViewName("admin/lista_wydajnosci_po_dacie");

        return model;
    }
    */


    /*
    @RequestMapping(value="/lista_wydajnosci" , method = RequestMethod.GET)
    public ModelAndView listaWydajnoscoByDate(ModelAndView model) throws IOException {

        wydajnoscService.dropTempTables();
        wydajnoscService.createXxx();
        wydajnoscService.createWykonanieNormy();
        wydajnoscService.createCzasCalkowity();
        wydajnoscService.createWydajnosc();

        List<Wydajnosc> listaWydajnosci = wydajnoscService.findWydajnoscByDate(date);
        model.addObject("listaWydajnosci",listaWydajnosci);
        model.setViewName("admin/lista_wydajnosci");

        return model;
    }

     */


}
