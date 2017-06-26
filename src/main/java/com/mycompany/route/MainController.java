package com.mycompany.route;

import com.mycompany.dao.ProizvodDao;
import com.mycompany.model.Proizvod;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {

    @Autowired
    ProizvodDao proizvodDao;

    @RequestMapping(method = RequestMethod.GET, path = "/")
     public ModelAndView printHello(ModelAndView modelAndView) {
        List<Proizvod> proizvodi = proizvodDao.getAllProizvodi();
        modelAndView.addObject("proizvodi", proizvodi);
        modelAndView.setViewName("index");
        return modelAndView;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/proizvod")
    public ModelAndView dodavanjeArtikla(ModelMap model) {

        proizvodDao.addProizvod();
        model.addAttribute("proizvod", new Proizvod());
        return new ModelAndView("proizvod", "command", new Proizvod());
    }

    @RequestMapping(value = "/proizvod", method = RequestMethod.POST)
    public ModelAndView addProizvod(@ModelAttribute("proizvod") Proizvod p, ModelAndView model,
            @RequestParam("file") MultipartFile file, HttpSession session) throws Exception {

        ServletContext context = session.getServletContext();
        String path = context.getInitParameter("upload.location");
        String filename = file.getOriginalFilename();

        byte[] bytes = file.getBytes();
        try (BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(
                new File(path + File.separator + filename)))) {
            stream.write(bytes);
            stream.flush();
        }

        System.out.println("Bajtovi iz kontrolera: " + bytes);
        p.setProizvod_slika("/MotoShop/img/" + filename);
        model.addObject("object", p);
        p.setProizvod_id(proizvodDao.getCount() + 1);
        System.out.println("Proizvod iz MainControllera: " + p);
        proizvodDao.addProizvodd(p);
        model.setViewName("index");
        return model;
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login(@RequestParam(value = "error", required = false) String error,
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
    @RequestMapping(value = "/dodavanjeProizvoda", method = RequestMethod.GET)
    public ModelAndView students(ModelAndView modelAndView) {
        List<Proizvod> proizvodi = proizvodDao.getAllProizvodi();
        modelAndView.addObject("proizvodi", proizvodi);
        modelAndView.setViewName("dodavanjeProizvoda");
        return modelAndView;
    }

    @RequestMapping(value = "/editproizvod/{proizvod_id}")
    public ModelAndView edit(@PathVariable int proizvod_id) {
        Proizvod proizvod = proizvodDao.getProizvodById(proizvod_id);
        return new ModelAndView("editproizvod", "command", proizvod);
    }

    @RequestMapping(value = "/editsave", method = RequestMethod.POST)
    public ModelAndView editsave(@ModelAttribute("proizvod") Proizvod proizvod, ModelAndView model) {
        proizvodDao.updateProizvod(proizvod);
        return new ModelAndView("redirect:/");
    }

    @RequestMapping(value = "/deleteproizvod/{proizvod_id}", method = RequestMethod.GET)
    public ModelAndView delete(@PathVariable int proizvod_id, ModelAndView model) {
        Proizvod proizvod = proizvodDao.getProizvodById(proizvod_id);
        proizvodDao.delete(proizvod);
        return new ModelAndView("redirect:/");
    }
}
