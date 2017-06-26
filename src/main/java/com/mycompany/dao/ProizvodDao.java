package com.mycompany.dao;

import com.mycompany.model.Proizvod;
import java.util.List;

public interface ProizvodDao {

    public void addProizvod();

    public String addProizvodRet();

    public void addProizvodThrowException() throws Exception;

    public int getCount();

    public List<Proizvod> getAllProizvodi();

    public Proizvod addProizvodd(Proizvod proizvod);
    
    public boolean updateProizvod(Proizvod proizvod);
    
    public Proizvod getProizvodById(int id);
    
    public void delete(Proizvod proizvod);
    
    
}
