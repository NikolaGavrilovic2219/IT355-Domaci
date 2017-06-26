/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dao.impl;

import com.mycompany.dao.ProizvodDao;

public class ProizvodDaoImpl implements ProizvodDao {

    @Override
    public void addProizvod() {
        System.out.println("Dodajem proizvod..");
    }

    @Override
    public String addProizvodRet() {
        System.out.println("Dodajem proizvod i vracam vrednost..");
        return "Dodato";
    }

    @Override
    public void addProizvodThrowException() throws Exception {
        System.out.println("Dodajem proizvod, ali postoji greska");
        throw new Exception("Generic Error");
    }
    
}
