package application;

import model.dao.DaoFactory;
import model.dao.DepartmentDAO;
import model.dao.SellerDAO;
import model.entities.Department;
import model.entities.Seller;

import java.util.Date;
import java.util.List;

public class Program {

    public static void main(String[] args) {

        DepartmentDAO departmentDAO = DaoFactory.createDepartmentDao();

        Department department = new Department();
        department.setName("Sports");
        department.setId(6);

        List<Department> result = departmentDAO.findAll();

        for (Department item : result) {
            System.out.println(item.getName());
            System.out.println();
        }
    }
}
