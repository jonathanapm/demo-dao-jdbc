package application;

import model.dao.DaoFactory;
import model.dao.SellerDAO;
import model.entities.Department;
import model.entities.Seller;

import java.util.Date;

public class Program {

    public static void main(String[] args) {

        SellerDAO sellerDAO = DaoFactory.createSellerDao();

        Department department = new Department(1, "");
        Seller seller = new Seller(9, "Arnold", "arnold@gmail.com", new Date(), 7000.0, department);

        sellerDAO.deleteById(100);

        System.out.println("Delete Success");
    }
}
