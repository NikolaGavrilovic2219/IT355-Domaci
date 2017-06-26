package com.mycompany.mapper;

import com.mycompany.model.Proizvod;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class ProizvodMapper implements RowMapper<Proizvod> {

    @Override
    public Proizvod mapRow(ResultSet rs, int i) throws SQLException {
        Proizvod proizvod = new Proizvod();
        proizvod.setProizvod_id(rs.getInt("proizvod_id"));
        proizvod.setProizvod_naziv(rs.getString("proizvod_naziv"));
        proizvod.setProizvod_cena(rs.getInt("proizvod_cena"));
        proizvod.setProizvod_opis(rs.getString("proizvod_opis"));
        proizvod.setProizvod_slika(rs.getString("proizvod_slika"));
        return proizvod;
    }
    
}
