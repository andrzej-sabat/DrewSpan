package com.drewSpan.drewSpan2.controller;

import com.drewSpan.drewSpan2.model.*;
import com.drewSpan.drewSpan2.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
        ModelAndView modelAndView = new ModelAndView();
        try {
            indexOpElementyService.save(indexOpElementy);
            List<IndexOpElementy> indexOpElementyList = indexOpElementyService.getAllIndexOpElementy();
            List<IndexOp> listIndexOps = indexOpService.getAllIndexOp();
            List<OpTech> listOpTechs = opTechService.getAllOpTechs();
            modelAndView.addObject("listOpTechs", listOpTechs);
            modelAndView.addObject("listIndexOps", listIndexOps);
            modelAndView.addObject("indexOpElementyList", indexOpElementyList);
            modelAndView.addObject("indexOpElementy", indexOpElementy);
            modelAndView.addObject("succes","Pomyślnie dodano indeks-operacje technologiczną");
            modelAndView.setViewName("admin/indeks_operacje_technologiczne");
        }
        catch (Exception e){



            List<IndexOpElementy> indexOpElementyList = indexOpElementyService.getAllIndexOpElementy();
            List<IndexOp> listIndexOps = indexOpService.getAllIndexOp();
            List<OpTech> listOpTechs = opTechService.getAllOpTechs();
            modelAndView.addObject("listOpTechs", listOpTechs);
            modelAndView.addObject("listIndexOps", listIndexOps);
            modelAndView.addObject("indexOpElementyList", indexOpElementyList);
            modelAndView.addObject("indexOpElementy", indexOpElementy);
            modelAndView.addObject("succes","Pomyślnie dodano indeks-operacje technologiczną");
            modelAndView.setViewName("admin/indeks_operacje_technologiczne");

        }
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

        IndexOpElementy indexOpElementy = new IndexOpElementy();

        List<IndexOpElementy> listIndexOpElementy =indexOpElementyService.getAllIndexOpElementy();

        List<IndexOp> listIndexOps = indexOpService.getAllIndexOp();
        List<OpTech> listOpTechs = opTechService.getAllOpTechs();
        modelAndView.addObject("indexOpElementy",indexOpElementy);
        modelAndView.addObject("listIndexOpElementy",listIndexOpElementy);
        modelAndView.addObject("listOpTechs", listOpTechs);
        modelAndView.addObject("listIndexOps", listIndexOps);
        modelAndView.addObject("standardDate", new Date());
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

    @RequestMapping(value = "/edit_indeks_operacje_technologiczne", method = RequestMethod.GET)
    public ModelAndView editIndeksOpElem(HttpServletRequest request) {
        int indexOpElementyId = Integer.parseInt(request.getParameter("id"));

        IndexOpElementy indexOpElementy = indexOpElementyService.getIndexOpElementy(indexOpElementyId);
        ModelAndView model = new ModelAndView("admin/indeks_operacje_technologiczne");
        List<IndexOp> listIndexOps = indexOpService.getAllIndexOp();
        List<OpTech> listOpTechs = opTechService.getAllOpTechs();
        model.addObject("listIndexOps",listIndexOps);
        model.addObject("listOpTechs",listOpTechs);

        return model;
    }

    @RequestMapping(value = "/delete_indeks_operacje_technologiczne", method = RequestMethod.GET)
    public ModelAndView deleteIndexOpElementy(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();

        try {
            long indexOpElementyId = Integer.parseInt(request.getParameter("id"));
            indexOpElementyService.deleteIndexOpElementy(indexOpElementyId);
            List<IndexOpElementy> listIndexOpElementy = indexOpElementyService.getAllIndexOpElementy();
            modelAndView.addObject("listIndexOpElementy", listIndexOpElementy);
            modelAndView.setViewName("admin/indeks_operacje_technologiczne_lista");
            modelAndView.addObject("deleted","Pomyślnie usunięto indeks-operacje technologiczną");
        } catch (Exception e){

            List<IndexOpElementy> listIndexOpElementy = indexOpElementyService.getAllIndexOpElementy();
            modelAndView.addObject("listIndexOpElementy", listIndexOpElementy);
            modelAndView.setViewName("admin/indeks_operacje_technologiczne_lista");
        }
        return modelAndView;
    }

    @RequestMapping(value = "delete_indeks_operacje_technologiczne/admin/home", method = RequestMethod.GET)
    public String backToAdminMenuAfterDeleteopTech(){

        return "admin/home";
    }


}
