/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.route;

import com.mycompany.dao.ProizvodDao;
import com.mycompany.model.Proizvod;
import java.awt.PageAttributes;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
public class MotoShopRestController {
    
    @Autowired
    ProizvodDao proizvodDao;
    
    //metoda koja prikazuje sve produkte, tipa get, a proizvode prikazuje u JSON formatu
    @RequestMapping(value = "/proizvodi", method = RequestMethod.GET)
    public ResponseEntity<List<Proizvod>> getProizvodi() {
        System.out.println("Fetching products");
        List<Proizvod> proizvod = proizvodDao.getAllProizvodi();
        if (proizvod.isEmpty()) {
            System.out.println("Lista proizvoda prazna");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<List<Proizvod>>(proizvod, HttpStatus.OK);
    }
    
    //metoda koja po id-ju prikazuje jedan produkt. 
    //na adresi http://localhost:8080/HibernateCRUD/product/4 pozivamo ovu metodu
    //
    @RequestMapping(value = "/proizvod/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Proizvod> getProizvod(@PathVariable("id") int id) {
        System.out.println("Povezivanje proizvoda sa ID-em " + id);
        Proizvod proizvod = proizvodDao.getProizvodById(id);
        if (proizvod == null) {
            System.out.println("Proizvod sa " + id + " nije pronadjen");
            return new ResponseEntity<Proizvod>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Proizvod>(proizvod, HttpStatus.OK);
    }
    
    
    //metoda koja cuva proizvod u bazu
    @RequestMapping(value = "/proizvod/", method = RequestMethod.POST)
    public ResponseEntity<Void> addProizvod(@RequestBody Proizvod proizvod) {
        System.out.println("Dodavanje proizvoda " + proizvod.toString());
        proizvodDao.addProizvodd(proizvod);
 
        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
      
    //metoda koja po id-u nalazi i brise produkt iz baze
    @RequestMapping(value = "/proizvod/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Proizvod> deleteProizvod(@PathVariable("id") int id) {
        System.out.println("Povezivanje i brisanje proizvoda sa id-em " + id);
 
        Proizvod proizvod = proizvodDao.getProizvodById(id);
        if (proizvod == null) {
            System.out.println("Nemoguce je obrisati proizvod sa" + id + " id-em");
            return new ResponseEntity<Proizvod>(HttpStatus.NOT_FOUND);
        }
 
        proizvodDao.delete(proizvod);
        return new ResponseEntity<Proizvod>(HttpStatus.OK);
    }
 
  
 
    
}
