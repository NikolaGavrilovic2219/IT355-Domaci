package com.mycompany.dao;

import com.mycompany.model.Proizvod;
import java.util.List;

public interface ProizvodDao {

    public void addProizvod();

    public String addProizvodRet();

    public void addProizvodThrowException() throws Exception;

    public int getCount();

    public List<Proizvod> getAllProizvodi();

    public boolean addProizvodd(Proizvod proizvod);
    
    public boolean updateProizvod(Proizvod proizvod);
    
    public Proizvod getProizvodById(int id);
    
    public int delete(int id);
    
    
}
