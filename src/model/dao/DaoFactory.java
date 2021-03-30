package model.dao;

import db.DBConnection;
import model.dao.impl.DepartmentDAOJDBCImpl;
import model.dao.impl.SellerDAOJDBCImpl;

public class DaoFactory {

    public static SellerDAO createSellerDao() {
        return new SellerDAOJDBCImpl(DBConnection.getConnection());
    }

    public static DepartmentDAO createDepartmentDao() { return new DepartmentDAOJDBCImpl(DBConnection.getConnection()); }
}
