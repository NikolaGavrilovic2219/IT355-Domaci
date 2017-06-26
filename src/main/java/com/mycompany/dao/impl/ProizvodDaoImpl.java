package com.mycompany.dao.impl;

import com.mycompany.dao.ProizvodDao;
import com.mycompany.model.Proizvod;
import com.mycompany.mapper.ProizvodMapper;
import java.util.List;
import javax.sql.DataSource;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository("artiklDao")
@Service
public class ProizvodDaoImpl implements ProizvodDao {

    private JdbcTemplate jdbcTemplate;
    @SuppressWarnings("unused")
    private DataSource dataSource;

    @SuppressWarnings("unused")
    private final Log logger = LogFactory.getLog(getClass());

    //Instanciramo sesiju
    @Autowired
    private SessionFactory sessionFactory;

    //kreiramo seter za sesiju
    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    //kreiramo geter za sesiju
    public Session getSession() {
        return sessionFactory.getCurrentSession();
    }

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
    @Transactional
    public int getCount() {
 //       String sql = "SELECT COUNT(*) FROM proizvodi";
 //       int count = jdbcTemplate.queryForObject(sql, Integer.class);
 //       System.out.println("ProizvodDaoImpl count rez: " + count);
 //       return count;
        Number result = (Number) getSession().createSQLQuery("SELECT COUNT(*) FROM knjige").uniqueResult();
        return Integer.parseInt(result.toString());

    }

    @Override
    @Transactional
    public List<Proizvod> getAllProizvodi() {
        List<Proizvod> results = (List<Proizvod>) getSession().createCriteria(Proizvod.class).list();
        return results;
    }

    @Override
    @Transactional
    public Proizvod addProizvodd(Proizvod proizvod) {
   //     String sql = "INSERT INTO proizvodi"
   //            + "(proizvod_id, proizvod_naziv, proizvod_cena, proizvod_opis, proizvod_slika) VALUES (?, ?, ?, ?, ?)";
   //    jdbcTemplate.update(sql, new Object[]{proizvod.getProizvod_id(), proizvod.getProizvod_naziv(), proizvod.getProizvod_cena(), proizvod.getProizvod_opis(), proizvod.getProizvod_slika()});
  //     return true;
        return (Proizvod) getSession().merge(proizvod);

    }

    @Override
    @Transactional
    public boolean updateProizvod(Proizvod proizvod) {
//        String sql = "UPDATE proizvodi SET proizvod_naziv='" + proizvod.getProizvod_naziv()
//                + "', proizvod_cena='" + proizvod.getProizvod_cena()
//               + "', proizvod_opis='" + proizvod.getProizvod_opis() + "' WHERE proizvod_id='" + proizvod.getProizvod_id() + "'";
//       jdbcTemplate.update(sql);
//        return true;
        getSession().saveOrUpdate(proizvod);
        return true;
    }

    @Override
    @Transactional
    public Proizvod getProizvodById(int proizvod_id) {
//        String sql = "SELECT * FROM proizvodi WHERE proizvod_id=?";
//        return jdbcTemplate.queryForObject(sql, new Object[]{proizvod_id}, new BeanPropertyRowMapper<Proizvod>(Proizvod.class));
        Proizvod proizvod = (Proizvod) getSession().createCriteria(Proizvod.class).add(Restrictions.eq("proizvod_id", proizvod_id)).uniqueResult();
        return proizvod;
    }

    @Override
    @Transactional
    public void delete(Proizvod proizvod) {
//        String sql = "DELETE FROM proizvodi WHERE proizvod_id=" + proizvod_id + "";
//       return jdbcTemplate.update(sql);
        getSession().delete(proizvod);

    }
}
