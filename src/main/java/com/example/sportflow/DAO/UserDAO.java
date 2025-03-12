package com.example.sportflow.DAO;

import com.example.sportflow.config.myDB;
import com.example.sportflow.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserDAO {
public void createUser(User user) throws SQLException {
   String sql = "insert into users (name, prenom, email, password, role) values (?,?,?,?,?)";
   Connection connection = myDB.getConnection();
   PreparedStatement preparedStatement = connection.prepareStatement(sql);
   preparedStatement.setString(1, user.getName());
   preparedStatement.setString(2, user.getPrenom());
   preparedStatement.setString(3, user.getEmail());
   preparedStatement.setString(4, user.getPassword());
   preparedStatement.setString(5, user.getRole());
   preparedStatement.executeUpdate();
}
}
