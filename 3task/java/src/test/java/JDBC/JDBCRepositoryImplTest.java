package JDBC;

import Models.User;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class JDBCRepositoryImplTest {

    JDBCRepository jdbcRepository = new JDBCRepositoryImpl();

    @Test
    void getAllUsers() throws Exception{
        List<User> users = jdbcRepository.getAllUsers();
        assertNotNull(users);
    }


    void CRUD() throws Exception{
        Boolean add = jdbcRepository.addUser("User", 55);

        assertTrue(add);
        User user = jdbcRepository.getAllUsers().stream().filter(u -> u.getName().equals("User")).findAny().orElse(null);
        assertNotNull(user);
        Boolean update = jdbcRepository.updateUser(user.getId(), "User-1", 56);
        assertTrue(update);
        Boolean delete = jdbcRepository.deleteUser(user.getId());
        assertTrue(delete);

    }
}