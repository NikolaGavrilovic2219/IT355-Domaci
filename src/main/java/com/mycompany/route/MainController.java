package com.mycompany.route;

import com.mycompany.dao.ProizvodDao;
import com.mycompany.route.data.Proizvod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {

    @Autowired
    private ProizvodDao proizvodDao;

    @RequestMapping(method = RequestMethod.GET, path = "/")
    public String printHello(ModelMap model) {
        return "index";
    }

    @RequestMapping(method = RequestMethod.GET, path = "/proizvod")
    public ModelAndView dodavanjeArtikla(ModelMap model) {
        
        proizvodDao.addProizvod();
        model.addAttribute("proizvod", new Proizvod());
        return new ModelAndView("proizvod", "command", new Proizvod());
    }

    @RequestMapping(value = "/dodavanjeProizvoda", method  = RequestMethod.POST)
    public String addProizvod(@ModelAttribute Proizvod proizvod, ModelMap model) {
        model.addAttribute("ime", proizvod.getIme());
        model.addAttribute("cena", proizvod.getCena());
        model.addAttribute("opis", proizvod.getOpis());
        return "dodavanjeProizvoda";
    }

}
