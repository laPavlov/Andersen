package Controller;

import Models.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Controller {
    /**
     *
     * @param resultSet - данные из SQL запроса.
     *
     * Внутри вынимаются данные пользователя и создаются по шаблону (User)
     *
     * @return - обьект User.
     */
    public User createUser(ResultSet resultSet) throws SQLException {
        Integer id = resultSet.getInt("id");
        String name = resultSet.getString("name");
        Integer age = resultSet.getInt("age");
        return new User(id, name, age);
    }

}
