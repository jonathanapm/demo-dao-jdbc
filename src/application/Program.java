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

      Department department = new Department();
      department.setId(1);
      department.setName("Computers");

      List<Seller> seller = sellerDAO.findByDepartment(department);

      System.out.println(seller.toArray());

      for (Seller item : seller) {
          System.out.print(item);
          System.out.println("");
      }

    }
}
