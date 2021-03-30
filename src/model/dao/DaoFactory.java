package model.dao;

import db.DBConnection;
import model.dao.impl.SellerDAOJDBCImpl;

public class DaoFactory {

    public static SellerDAO createSellerDao() {
        return new SellerDAOJDBCImpl(DBConnection.getConnection());
    }
}
