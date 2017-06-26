package com.mycompany.route;

import com.mycompany.dao.ProizvodDao;
import com.mycompany.data.Proizvod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
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

    @RequestMapping(value = "/dodavanjeProizvoda", method = RequestMethod.POST)
    public String addProizvod(@ModelAttribute Proizvod proizvod, ModelMap model) {
        model.addAttribute("ime", proizvod.getIme());
        model.addAttribute("cena", proizvod.getCena());
        model.addAttribute("opis", proizvod.getOpis());
        return "dodavanjeProizvoda";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login(@RequestParam(value = "error",
            required = false) String error,
            @RequestParam(value = "logout", required = false) String logout) {
        ModelAndView model = new ModelAndView();
        if (error != null) {
            model.addObject("error", "Losi login podaci!");
        }
        if (logout != null) {
            model.addObject("msg", "Izlogovani ste.");
        }
        model.setViewName("login");
        return model;
    }

    @RequestMapping(value = "/403", method = RequestMethod.GET)
    public ModelAndView accesssDenied() {
        ModelAndView model = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (!(auth instanceof AnonymousAuthenticationToken)) {
            UserDetails userDetail = (UserDetails) auth.getPrincipal();
            System.out.println(userDetail);
            model.addObject("username",
                    userDetail.getUsername());
        }
        model.setViewName("403");
        return model;
    }

    @RequestMapping(value = "/admin**", method
            = RequestMethod.GET)
    public ModelAndView adminPage() {
        ModelAndView model = new ModelAndView();
        model.addObject("message", "Ovo je strana za admine!");
        model.setViewName("admin");
        return model;
    }
}
