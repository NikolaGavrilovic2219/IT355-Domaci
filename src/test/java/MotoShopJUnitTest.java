
import com.mycompany.dao.ProizvodDao;
import com.mycompany.model.Proizvod;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/MotoShop-servlet.xml"})
public class MotoShopJUnitTest {

    @Autowired
    protected ProizvodDao proizvodDao;

    @Before
    public void setUp() {

    }

//    @Test
    public void addProizvodTest() {
        Proizvod proizvod = new Proizvod();
        proizvod.setProizvod_naziv("Prvi test naziv proizvoda");
        proizvod.setProizvod_cena(222);
        proizvod.setProizvod_opis("test opis");
        proizvod.setProizvod_slika("nesto");
        Proizvod newArt = proizvodDao.addProizvodd(proizvod);
        proizvodDao.delete(newArt);
        Assert.assertNotNull(newArt);
    }

//    @Test
    public void getProizvodByIdTest() {
        Proizvod proizvod = new Proizvod();
        proizvod.setProizvod_naziv("Prvi test naziv proizvoda");
        proizvod.setProizvod_cena(222);
        proizvod.setProizvod_opis("test opis");
        proizvod.setProizvod_slika("nesto");
        Proizvod newArt = proizvodDao.addProizvodd(proizvod);
        Proizvod get = proizvodDao.getProizvodById(newArt.getProizvod_id());
        proizvodDao.delete(get);
        Assert.assertNotNull(get);
    }

//    @Test
    public void getCountTest() {
        int get = proizvodDao.getCount();
        Assert.assertNotNull(get);
    }

//    @Test
    public void deletProizvodTest() {
        Proizvod proizvod = new Proizvod();
        proizvod.setProizvod_naziv("Prvi test naziv proizvoda");
        proizvod.setProizvod_cena(222);
        proizvod.setProizvod_opis("test opis");
        proizvod.setProizvod_slika("nesto");
        Proizvod newArt = proizvodDao.addProizvodd(proizvod);
        Proizvod deletedArtikl = proizvodDao.getProizvodById(newArt.getProizvod_id());
        proizvodDao.delete(newArt);
        Assert.assertNotNull(deletedArtikl);
    }

//    @Test
    public void updateProizvodTest() {
        Proizvod proizvod = new Proizvod();
        proizvod.setProizvod_naziv("Prvi test naziv proizvoda");
        proizvod.setProizvod_cena(222);
        proizvod.setProizvod_opis("test opis");
        proizvod.setProizvod_slika("nesto");
        Proizvod newArt = proizvodDao.addProizvodd(proizvod);
        newArt.setProizvod_naziv("Izmenjen naziv");
        proizvodDao.updateProizvod(newArt);
        Assert.assertNotNull(newArt);
    }

    @Test
    public void getAllProizvodTest() {
//        List<Proizvod> proizvodi = Arrays.asList(
//                new Proizvod(1, "Naziv 1", 111, "Opis prve", "Slika prve"),
//                new Proizvod(2, "Naziv 2", 222, "Opis druge", "Slika druge"),
//                new Proizvod(3, "Naziv 3", 333, "Opis trece", "Slika trece")
//        );
//        List<Proizvod> dodatiProizvod = new ArrayList<>();
//        for (int i = 0; i < prozivodi.size(); i++) {
//            System.out.println(prozivodi.get(i).getProizvod_naziv());
//            dodatiProizvod.add(prozivodDao.addProizvodd(prozivodi.get(i)));
//        }
        
        List<Proizvod> proizvodi =  proizvodDao.getAllProizvodi();
        for (int i = 0; i < proizvodi.size(); i++){
            System.out.println("Proizvod: " + proizvodi.get(i).getProizvod_naziv());
             Assert.assertNotNull(proizvodi.get(i));
        }
        
    }

}
