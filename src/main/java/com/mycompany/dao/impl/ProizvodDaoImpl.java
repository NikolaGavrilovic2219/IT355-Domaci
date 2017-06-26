/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dao.impl;

import com.mycompany.dao.ProizvodDao;
import com.mycompany.model.Proizvod;
import com.mycompany.mapper.ProizvodMapper;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.jdbc.core.JdbcTemplate;

public class ProizvodDaoImpl implements ProizvodDao {

    private JdbcTemplate jdbcTemplate;
    @SuppressWarnings("unused")
    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
    
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
    
    @Override
    public int getCount() {
        String sql = "SELECT COUNT(*) FROM proizvodi";
        int count = jdbcTemplate.queryForObject(sql, Integer.class);
        System.out.println("ProizvodDaoImpl count rez: " + count);
        return count;
    }

    @Override
    public List<Proizvod> getAllProizvodi() {
        String sql = "SELECT * FROM proizvodi";
        List<Proizvod> proizvodi = jdbcTemplate.query(sql, new ProizvodMapper());
        return proizvodi;
    }

    @Override
    @Transactional
    public boolean addProizvodd(Proizvod proizvod) {
        String sql = "INSERT INTO proizvodi"
                + "(proizvod_id, proizvod_naziv, proizvod_cena, proizvod_opis, proizvod_slika) VALUES (?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, new Object[]{proizvod.getProizvod_id(), proizvod.getProizvod_naziv(), proizvod.getProizvod_cena(), proizvod.getProizvod_opis(), proizvod.getProizvod_slika()});
        return true;
    }

    @Override
    public boolean updateProizvod(Proizvod proizvod) {
        String sql = "UPDATE proizvodi SET proizvod_naziv='" + proizvod.getProizvod_naziv()
                + "', proizvod_cena='" + proizvod.getProizvod_cena()
                + "', proizvod_opis='" + proizvod.getProizvod_opis() + "' WHERE proizvod_id='" + proizvod.getProizvod_id() + "'";
        jdbcTemplate.update(sql);
        return true;
    }

    @Override
    public Proizvod getProizvodById(int proizvod_id) {
        String sql = "SELECT * FROM proizvodi WHERE proizvod_id=?";
        return jdbcTemplate.queryForObject(sql, new Object[]{proizvod_id}, new BeanPropertyRowMapper<Proizvod>(Proizvod.class));
    }

    @Override
    public int delete(int proizvod_id) {
        String sql = "DELETE FROM proizvodi WHERE proizvod_id=" + proizvod_id + "";
        return jdbcTemplate.update(sql);
    }
    
}
