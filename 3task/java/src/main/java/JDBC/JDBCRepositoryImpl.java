package JDBC;

import Controller.Controller;
import Models.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JDBCRepositoryImpl implements JDBCRepository {

    //Language SQL
    private static final String SQL_FIND_ALL = "select * from users";
    //Language SQL
    private static final String SQL_CREATE_USER = "insert into users(name, age) values (?, ?)";
    //Language SQL
    private static final String SQL_UPDATE_USER = "update users set name =?, age=? where id = ?";
    //Language SQL
    private static final String SQL_DELETE_USER = "delete from users where id = ?";
    //Language SQL
    private static final String SQL_DELETE_USERSCOURSES = "delete from \"UsCors\" where people=?";

    Controller controller = new Controller();

    /**
     * Метод подключения к БД.
     *
     * Исходя из данных полученных из ConnectionData происходит установка драйвера для БД и подключение к самой БД
     * по URL, UserName и Password.
     *
     * @return - connection, объект подключения к БД.
     */
    private Connection connectToDB() throws ClassNotFoundException, SQLException {
        ConnectionData connectionData = new ConnectionData();
        Connection connection;

        System.out.println("Registering JDBC driver...");
        Class.forName(connectionData.getDriver());

        System.out.println("Creating database connection...");
        connection = DriverManager.getConnection(connectionData.getUrl(), connectionData.getUserName(), connectionData.getPassword());

        return connection;
    }

    /**
     * Получение всех пользователей из БТ таблицы users.
     *
     * Внутри вызывается метод подключения к БД (connectToDB), далее выполняется SQL statement запрос (SQL_FIND_ALL).
     * Полученные данные передаются в Controller, который возвращает список пользователей.
     *
     * @return - список пользователей.
     */
    @Override
    public List<User> getAllUsers() throws ClassNotFoundException, SQLException {

        List<User> users = new ArrayList<>();

        Connection connection = connectToDB();
        connection.setAutoCommit(false);
        connection.setTransactionIsolation(Connection.TRANSACTION_REPEATABLE_READ);

        Statement statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery(SQL_FIND_ALL);

        while (resultSet.next()) {
            users.add(controller.createUser(resultSet));
        }
        connection.commit();
        return users;
    }

    /**
     * Добавление пользователя.
     *
     * @param name - имя добавляемого пользователя.
     * @param age - возраст добавляемого пользователя.
     *
     * Внутри вызывается метод подключения к БД (connectToDB), далее выполняется SQL PreparedStatement запрос (SQL_CREATE_USER).
     *
     * @return - true, если запрос прошел успешно.
     */
    @Override
    public Boolean addUser(String name, Integer age) throws SQLException, ClassNotFoundException {

        Connection connection = connectToDB();
        connection.setAutoCommit(false);
        connection.setTransactionIsolation(Connection.TRANSACTION_REPEATABLE_READ);

        PreparedStatement preparedStatement = connection.prepareStatement(SQL_CREATE_USER);
        preparedStatement.setString(1, name);
        preparedStatement.setInt(2, age);
        preparedStatement.executeUpdate();
        connection.commit();
        return true;
    }

    /**
     * Обновление данных пользователя.
     *
     * @param id - ID изменяемого пользователя.
     * @param name - изменяемое имя.
     * @param age - изменяемый возраст.
     *
     * Внутри вызывается метод подключения к БД (connectToDB), после выполняется SQL PreparedStatement запрос.
     *
     * @return - true, если запрос прошел успешно.
     */
    @Override
    public Boolean updateUser(Integer id, String name, Integer age) throws SQLException, ClassNotFoundException {

        Connection connection = connectToDB();
        connection.setAutoCommit(false);
        connection.setTransactionIsolation(Connection.TRANSACTION_REPEATABLE_READ);
        PreparedStatement preparedStatement = connection.prepareStatement(SQL_UPDATE_USER);
        preparedStatement.setInt(3, id);
        preparedStatement.setString(1, name);
        preparedStatement.setInt(2, age);
        preparedStatement.executeUpdate();
        connection.commit();
        return true;
    }

    /**
     * Удаление пользователя.
     *
     * @param id - ID удаляемого пользователя.
     *
     * Внутри вызывается метод подключения к БД (connectToDB), далее удаляется строка из таблицы курсов,
     * только после этого удаляется пользователь из таблицы пользователей.
     *
     * @return - true, если запрос прошел успешно.
     */
    @Override
    public Boolean deleteUser(Integer id) throws SQLException, ClassNotFoundException {

        Connection connection1 = connectToDB();
        connection1.setAutoCommit(false);
        connection1.setTransactionIsolation(Connection.TRANSACTION_REPEATABLE_READ);
        Connection connection2 = connectToDB();
        connection2.setAutoCommit(false);
        connection2.setTransactionIsolation(Connection.TRANSACTION_REPEATABLE_READ);

        PreparedStatement preparedStatement1 = connection1.prepareStatement(SQL_DELETE_USER);
        PreparedStatement preparedStatement2 = connection2.prepareStatement(SQL_DELETE_USERSCOURSES);
        preparedStatement1.setInt(1, id);
        preparedStatement2.setInt(1, id);
        preparedStatement2.executeUpdate();
        preparedStatement1.executeUpdate();
        connection2.commit();
        connection1.commit();
        return true;
    }
}

