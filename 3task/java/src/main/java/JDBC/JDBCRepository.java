package JDBC;

import Models.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface JDBCRepository {

    List<User> getAllUsers() throws ClassNotFoundException, SQLException;
    Boolean addUser(String name, Integer age) throws SQLException, ClassNotFoundException;
    Boolean updateUser(Integer id, String name, Integer age) throws SQLException, ClassNotFoundException;
    Boolean deleteUser(Integer id) throws SQLException, ClassNotFoundException;

}
