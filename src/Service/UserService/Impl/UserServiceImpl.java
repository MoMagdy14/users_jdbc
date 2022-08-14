package Service.UserService.Impl;

import Service.UserService.UserService;
import entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserServiceImpl extends Dao implements UserService {
    private static UserServiceImpl userService;

    private UserServiceImpl() {};

    public static UserServiceImpl getInstance() {
        if (userService == null) {
            return new UserServiceImpl();
        }
        return userService;
    }
    @Override
    public User addUser(User user) throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        boolean executed = false;
        try {
            con = getConnection();
            String query = "INSERT INTO users (username, password, birthdate, phone) VALUES (?, ?, ?, ?)";
            ps = con.prepareStatement(query);
            ps.setString(1, user.getUserName());
            ps.setString(2, user.getPassword());
            ps.setDate(3, user.getBirthDate());
            ps.setString(4, user.getPhone());
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            con.close();
        }
        if (executed) {
            return user;
        }
        return null;
    }

    @Override
    public User updateUser(String id, User user) throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        boolean executed = false;
        try {
            con = getConnection();
            String query = "UPDATE USERS SET username = ?, password = ?, birthdate = ?, phone = ? WHERE id = ?";
            ps = con.prepareStatement(query);
            ps.setString(1, user.getUserName());
            ps.setString(2, user.getPassword());
            ps.setDate(3, user.getBirthDate());
            ps.setString(4, user.getPhone());
            ps.setInt(5, Integer.parseInt(id));
            ps.execute();
            executed = true;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            con.close();
        }
        if (executed) {
            return user;
        }
        return null;
    }

    @Override
    public boolean deleteUser(String id)  throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        boolean executed = false;
        try {
            con = getConnection();
            String query = "DELETE FROM users WHERE id = ?";
            ps = con.prepareStatement(query);
            ps.setInt(1, Integer.parseInt(id));
            ps.execute();
            executed = true;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            con.close();
        }
        if (executed) {
            return true;
        }
        return false;
    }

    @Override
    public User getUser(String id) throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        User user = null;
        try {
            con = getConnection();
            String query = "SELECT * FROM users WHERE id = ?";
            ps = con.prepareStatement(query);
            ps.setInt(1, Integer.parseInt(id));
            rs = ps.executeQuery();
            if (rs.next()) {
                user = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDate(4), rs.getString(5));
            }
            } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            con.close();
        }
        if (user != null) {
            return user;
        }
        return null;
    }

    @Override
    public List<User> getAllUser() throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<User> users= new ArrayList<User>();
        try {
            con = getConnection();
            String query = "SELECT * FROM users";
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                User user = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDate(4), rs.getString(5));
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            con.close();
        }
        return users;
    }

    @Override
    public Optional<User> getUserByPhone(String phone) throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        User user = null;
        try {
            con = getConnection();
            String query = "SELECT * FROM users WHERE phone = ?";
            ps = con.prepareStatement(query);
            ps.setString(1, phone);
            rs = ps.executeQuery();
            if (rs.next()) {
                user = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDate(4), rs.getString(5));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            con.close();
        }
        Optional<User> result = Optional.ofNullable(user);
        if (result.isPresent()) {
            return result;
        }

        return Optional.empty();
    }
}
