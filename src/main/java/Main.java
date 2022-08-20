

import Service.UserService.Impl.Dao;
import Service.UserService.Impl.UserServiceImpl;
import entity.User;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.Optional;

public class Main {
    public static void main(String args[]) throws SQLException {
        Dao dao = new Dao();
        Connection con = dao.getConnection();
        System.out.println(con);
        UserServiceImpl userService = UserServiceImpl.getInstance();

      /*  Date date = Date.valueOf("1999-12-01");
        User user = new User(1,"eva1", "123", date, "010");
        userService.addUser(user);*/

        /*  Date date = Date.valueOf("1999-12-01");
        User user = new User(1,"mo", "mo", date, "010");
        userService.updateUser("2",user);*/

        // userService.deleteUser("2");

        // System.out.println(userService.getUser("1"));

        /*List<User> users = userService.getAllUser();
        for (User user : users) {
            System.out.println(user);
        }*/

       /* Optional<User> user= userService.getUserByPhone("011");
        if (user.isPresent()) {
            System.out.println(user);
        } else {
            System.out.println("No user found!");
        }*/




    }
}
