package com.ashcollege.utils;

;

import com.ashcollege.entities.User;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


@Component
public class DbUtils {//         חיבור ל   mysql      database
    private Connection connection = null;
    private User user;


//    @PostConstruct// מיד שהאובייקט נוצר אז הפונקציה תפעל
//    public Connection createConnection() {
//        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/yt", "root", "Omeriko#1");
//            System.out.println("ok");
//        } catch (ClassNotFoundException e) {
//            throw new RuntimeException(e);
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//        return connection;
//    }

//    public boolean registerUser(User user) {// הכנסת ערכים לתוך שאילתה ב sql
//        try {
//            PreparedStatement preparedStatement = connection.prepareStatement("INSERT into useres(username, password)VALUE( ?, ?)");
//            preparedStatement.setString(1, user.getUsername());
//            preparedStatement.setString(2, user.getPassword());
//            preparedStatement.executeUpdate();
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//        return true;
//    }

//    public boolean signIn(String username, String password) {
//        try {
//            PreparedStatement preparedStatement = connection.prepareStatement("SELECT  useres.Username FROM useres WHERE Username=? AND Password=?");
//            preparedStatement.setString(1, username);
//            preparedStatement.setString(2, password);
//            ResultSet resultSet = preparedStatement.executeQuery();
//            return resultSet.next();
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//    }
//    public boolean freeUsername(String username) {
//        try {
//            PreparedStatement preparedStatement = connection.prepareStatement("SELECT  useres.Username FROM useres WHERE Username=?");
//            preparedStatement.setString(1, username);
//            ResultSet resultSet = preparedStatement.executeQuery();
//            return !resultSet.next();
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//    }
//    public List<User> getAllUsers(){
//        List<User>allUsers=new ArrayList<>();
//       try{
//           PreparedStatement preparedStatement=connection.prepareStatement("SELECT * FROM users");
//           ResultSet resultSet= preparedStatement.executeQuery();
//           while (resultSet.next()){
//               User user1=new User();
//               user1.setId(resultSet.getInt("id"));
//               user1.setUsername(resultSet.getString("Username"));
//               user1.setPassword(resultSet.getString("Password"));
//               allUsers.add(user1);
//           }
//       }catch (SQLException e){
//           throw new RuntimeException(e);
//       }
//        return allUsers;
//    }
}
