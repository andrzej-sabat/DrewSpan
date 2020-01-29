package com.drewSpan.drewSpan2.controller;

import com.drewSpan.drewSpan2.model.*;
import com.drewSpan.drewSpan2.service.IndexOpElementyService;
import com.drewSpan.drewSpan2.service.WydajnoscService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.sql.*;
import java.util.List;

@Controller
public class WydajnoscController {

    @Autowired
    private WydajnoscService wydajnoscService;
    @Autowired
    private IndexOpElementyService indexOpElementyService;
    @Autowired
    private IndexOpController indexOpController;
    @Autowired
    private OpTechController opTechController;

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


    @RequestMapping(value="/wydajnosc_element" , method = RequestMethod.GET)
    public ModelAndView wydajnoscElement(ModelAndView model) throws IOException {
        IndexOpElementy indexOpElementy = new IndexOpElementy();
        List<IndexOpElementy> listIndexOpElementy= indexOpElementyService.getAllIndexOpElementy();

        model.addObject("listIndexOpElementy", listIndexOpElementy);
        model.addObject("indexOpElementy",indexOpElementy);
        model.setViewName("admin/wydajnosc_element");
        return model;
    }

    @PostMapping("/test")
    public List<Object> wy(){
        List<Object> list = wydajnoscService.listWydajnoscSearchIndex();
        return list;
    }

    @PostMapping("/wydajnosc_po_elemencie")
    public ModelAndView wydajnoscElement(@ModelAttribute IndexOpElementy indexOpElementy) throws SQLException {
        ModelAndView modelAndView = new ModelAndView();


            Long indexOpElementyId = indexOpElementy.getId();

            IndexOpElementy index = indexOpElementyService.getIndexOpElementy(Math.toIntExact(indexOpElementyId));
            String nazwaOperacji = index.getOpTech().getOpt_nazwa();
            String nazwaIndeksu = index.getIndexOp().getI_nazwa();
            String nazwaElementu = "Wydajność dla elementu: " + nazwaIndeksu + " ----- " + nazwaOperacji;
            Integer id_indeksu = Math.toIntExact(index.getIndexOp().getId_indeksu());
            Integer id_operacji = Math.toIntExact(index.getOpTech().getOpt_id());
            String nazwa_indeksu = index.getIndexOp().getI_nazwa();
            String nazwa_operacji = index.getOpTech().getOpt_nazwa();
            System.out.println(indexOpElementyId +"\n" + nazwa_indeksu +"\n"+ nazwa_operacji);



        wydajnoscService.dropTempTables();
        wydajnoscService.createXxx();
        wydajnoscService.createWykonanieNormySearchIndex(id_indeksu,id_operacji);
        wydajnoscService.createCzasCalkowitySearchIndex();
        wydajnoscService.createSumowanieSearchIndex();
        wydajnoscService.createWydajnoscSearchIndex();
        List <Object> lista = wydajnoscService.listWydajnoscSearchIndex();


        System.out.println("Rozmiar listy OBJECT: " + lista.size());

        List<WydajnoscElement> listaWydajnosciElement = wydajnoscService.findWydajnoscSearchIndex();

        System.out.println("Rozmiar listy WYDAJNOSC ELEMENT: " + listaWydajnosciElement.size());


/*
        Connection con= DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/drewspan","root","admin");
        Statement stmt = null;
        String query = "select * from wydajnosc";
        stmt = con.createStatement();
        System.out.println("-1-1-1-1-1--1-1-1--1-1-");
        ResultSet rs = stmt.executeQuery(query);
        System.out.println("00000000000000000000000000");*/
        /*ResultSet rs = wydajnoscService.findWydajnoscSearchIndex();
        while(rs.next()){
            Long opt_id = rs.getLong(0);
            Long id_indeks = rs.getLong(1);
            Double wydajnosc = rs.getDouble(2);
            System.out.println("111111111111111111111111");
            WydajnoscElement wydajnoscElement = new WydajnoscElement(opt_id,id_indeks,wydajnosc);
            System.out.println("222222222222222222222222");
            listaWydajnosciElement.add(wydajnoscElement);
            System.out.println("333333333333333333333333");
        }*/

        modelAndView.addObject("nazwaElementu",nazwaElementu);
        modelAndView.addObject("listaWydajnosciElement",listaWydajnosciElement);
        modelAndView.setViewName("admin/lista_wydajnosciElement");


        return modelAndView;
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
