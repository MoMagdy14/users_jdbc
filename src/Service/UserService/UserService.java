package Service.UserService;

import entity.User;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface UserService {

    User addUser(User user) throws SQLException;
    User updateUser(String id ,User user) throws SQLException;
    boolean deleteUser(String id) throws SQLException;
    User getUser(String id) throws SQLException;
    List<User> getAllUser() throws SQLException;
    Optional<User> getUserByPhone(String phone) throws SQLException;

}
