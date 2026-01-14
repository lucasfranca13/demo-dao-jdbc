import model.Department;
import model.Seller;
import model.dao.DaoFactory;
import model.dao.SellerDao;

import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        SellerDao sellerDao = DaoFactory.createSellerDao();
        Seller seller = sellerDao.findById(3);
        System.out.println(seller);

        System.out.println("\n==== TEST 2: seller findByDepartment ====");
        Department department = new Department(2, null);
        List<Seller> list = sellerDao.findByDepartment(department);
        for (Seller obj : list){
            System.out.println(obj);
        }

        System.out.println("\n==== TEST 3: seller findAll ====");
        List<Seller> listAll = sellerDao.findAll();
        for (Seller obj : listAll){
            System.out.println(obj);
        }

        System.out.println("\n==== TEST 3: seller findAll ====");
        Seller newSeller = new Seller(null, "Lucas", "teste@email.com", new Date(), 3000.0, department);
        sellerDao.inset(newSeller);
        System.out.println("Insert! New id = " + newSeller.getId());

        System.out.println("==== TEST 4: Update Seller");

        Seller sellerTest = sellerDao.findById(2);
        sellerTest.setName("Ricardo Junior");
        sellerDao.update(sellerTest);
        System.out.println("Update Completed!");
    }
}