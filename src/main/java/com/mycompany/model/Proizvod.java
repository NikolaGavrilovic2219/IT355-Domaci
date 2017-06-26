package com.mycompany.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "proizvodi")
public class Proizvod implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "proizvod_id")
    private int proizvod_id;
    
    @Column(name = "proizvod_naziv")
    private String proizvod_naziv;
    
    @Column(name = "proizvod_cena")
    private int proizvod_cena;
    
    @Column(name = "knjiga_opis")
    private String proizvod_opis;
    
    @Column(name = "proizvod_slika")
    private String proizvod_slika;

    public Proizvod() {
    }

    public Proizvod(int proizvod_id, String proizvod_naziv, int proizvod_cena, String proizvod_opis, String proizvod_slika) {
        this.proizvod_id = proizvod_id;
        this.proizvod_naziv = proizvod_naziv;
        this.proizvod_cena = proizvod_cena;
        this.proizvod_opis = proizvod_opis;
        this.proizvod_slika = proizvod_slika;
    }
    
    
    
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