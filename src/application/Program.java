package application;

import model.dao.DaoFactory;
import model.dao.SellerDAO;
import model.entities.Department;
import model.entities.Seller;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {

        SellerDAO sellerDAO = DaoFactory.createSellerDao();

        Department department = new Department(1, "");
        Seller seller = new Seller(null, "Greg", "greg@gmail.com", new Date(), 4000.0, department);

        sellerDAO.insert(seller);

        System.out.println("New seller Id " + seller.getId());
    }
}
