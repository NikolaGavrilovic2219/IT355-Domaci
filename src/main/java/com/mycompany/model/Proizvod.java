package com.mycompany.model;

import java.io.Serializable;


@SuppressWarnings("serial")
public class Proizvod implements Serializable {
    
    private int proizvod_id;
    private String proizvod_naziv;
    private int proizvod_cena;
    private String proizvod_opis;
    private String proizvod_slika;

    public int getProizvod_id() {
        return proizvod_id;
    }

    public void setProizvod_id(int proizvod_id) {
        this.proizvod_id = proizvod_id;
    }

    public String getProizvod_naziv() {
        return proizvod_naziv;
    }

    public void setProizvod_naziv(String proizvod_naziv) {
        this.proizvod_naziv = proizvod_naziv;
    }

    public int getProizvod_cena() {
        return proizvod_cena;
    }

    public void setProizvod_cena(int proizvod_cena) {
        this.proizvod_cena = proizvod_cena;
    }

    public String getProizvod_opis() {
        return proizvod_opis;
    }

    public void setProizvod_opis(String proizvod_opis) {
        this.proizvod_opis = proizvod_opis;
    }

    public String getProizvod_slika() {
        return proizvod_slika;
    }

    public void setProizvod_slika(String proizvod_slika) {
        this.proizvod_slika = proizvod_slika;
    }

    @Override
    public String toString() {
        return "Proizvod{" + "proizvod_id=" + proizvod_id + ", proizvod_naziv=" + proizvod_naziv 
             + ", proizvod_cena=" + proizvod_cena + ", proizvod_opis=" + proizvod_opis + ", proizvod_slika=" + proizvod_slika + '}';
    }

 
    
    
    
    
    
}
