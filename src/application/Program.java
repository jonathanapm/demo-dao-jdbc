package application;

import model.entities.Department;
import model.entities.Seller;

import java.util.Date;

public class Program {

    public static void main(String[] args) {

        Department department = new Department(1, "Books");
        Seller seller = new Seller(2, "João", "joao@gmail.com", new Date(), 6000.0, department);

    }
}
