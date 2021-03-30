package model.dao.impl;

import db.DbException;
import model.dao.DepartmentDAO;
import model.entities.Department;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DepartmentDAOJDBCImpl implements DepartmentDAO {

    private Connection connection;

    public DepartmentDAOJDBCImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void insert(Department department) {
        PreparedStatement statement = null;

        try {
            statement = connection.prepareStatement(
                    "INSERT INTO department " +
                            "(Name) " +
                            "VALUES (?)"
            );

            statement.setString(1, department.getName());

            statement.executeUpdate();

        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
    }

    @Override
    public void update(Department department) {
        PreparedStatement statement = null;

        try {
            statement = connection.prepareStatement(
              "UPDATE department SET Name = ? " +
              "WHERE Id = ?"
            );

            statement.setString(1, department.getName());
            statement.setInt(2, department.getId());
            statement.executeUpdate();
        }catch (SQLException e) {
           throw new DbException(e.getMessage());
        }
    }

    @Override
    public void deleteById(Integer id) {
        PreparedStatement statement = null;

        try {
            statement = connection.prepareStatement(
              "DELETE FROM department WHERE Id = ?"
            );

            statement.setInt(1, id);
            statement.executeUpdate();

        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
    }

    @Override
    public Department findById(Integer id) {
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Department department = null;

         try {
             statement = connection.prepareStatement(
                     "SELECT *FROM department WHERE Id = ?"
             );

             statement.setInt(1, id);
             resultSet = statement.executeQuery();

             if(resultSet.next()) {
                department = mapDepartment(resultSet);
             }

             return department;
         }catch (SQLException e) {
             throw new DbException(e.getMessage());
         }
    }

    @Override
    public List<Department> findAll() {
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Department> list = new ArrayList();

        try {
            statement = connection.prepareStatement(
                    "SELECT *FROM department"
            );

            resultSet = statement.executeQuery();

            while(resultSet.next()) {
                list.add(mapDepartment(resultSet));
            }

            return list;
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
    }

    private Department mapDepartment(ResultSet resultSet) throws SQLException {
        Department department = new Department();
        department.setId(resultSet.getInt("Id"));
        department.setName(resultSet.getString("Name"));
        return department;
    }
}
