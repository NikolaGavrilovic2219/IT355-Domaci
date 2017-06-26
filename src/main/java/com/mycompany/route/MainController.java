package com.mycompany.route;

import com.mycompany.route.data.Proizvod;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class MainController {

    @RequestMapping(method = RequestMethod.GET, path = "/")
    public String printHello(ModelMap model) {
        return "index";
    }

    @RequestMapping(method = RequestMethod.GET, path = "/proizvod")
    public String dodavanjeProizvoda(ModelMap model) {
        model.addAttribute("proizvod", new Proizvod());
        return "proizvod";
    }

    @RequestMapping(value = "/dodavanjeProizvoda", method
            = RequestMethod.POST)
    public String addProizvod(@ModelAttribute Proizvod proizvod,
            ModelMap model) {
        model.addAttribute("ime", proizvod.getIme());
        model.addAttribute("cena", proizvod.getCena());
        model.addAttribute("opis", proizvod.getOpis());
        return "dodavanjeProizvoda";
    }

}
