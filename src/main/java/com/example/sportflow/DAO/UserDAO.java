package com.example.sportflow.DAO;

import com.example.sportflow.config.myDB;
import com.example.sportflow.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

   public List<User> getAllUser() {
   ArrayList<User> users = new ArrayList<>();
   try (Connection connection = myDB.getConnection()){
      if (connection != null){
         String sql = "select * from users";
         try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
               User user = new User();
               user.setId(resultSet.getInt("id"));
               user.setName(resultSet.getString("name"));
               user.setPrenom(resultSet.getString("prenom"));
               user.setEmail(resultSet.getString("email"));
               user.setPassword(resultSet.getString("password"));
               user.setRole(resultSet.getString("role"));
               users.add(user);
            }
         } catch (SQLException e) {
            throw new RuntimeException(e);
         }
      }

   } catch (SQLException e) {
       throw new RuntimeException(e);
   }
   return users;
   }

   public void updateUser(User user) throws SQLException {
   try (Connection connection = myDB.getConnection()) {  // we use try to close the connection after use and preventing resource leaks
      if (connection != null) {
         String query = "UPDATE user SET nom = ?, prenom = ?, email = ?, password = ? WHERE id = ?";
         try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getPrenom());
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.setString(4, user.getPassword());
            preparedStatement.setInt(5, user.getId());
            preparedStatement.executeUpdate();
         } catch (SQLException e) {
            System.err.println("Error updating user: "+e.getMessage());
         }
      }

   } catch (SQLException e) {
      throw new RuntimeException(e);
   }
   }


   public void deleteUser(int id) throws SQLException {  // the parameter id is used to identify which user to delete from the database.

   try (Connection connection = myDB.getConnection()) {
      if (connection != null) {
         String query = "DELETE FROM users WHERE id = ?";
         try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
         } catch (SQLException e) {
            System.err.println("Error deleting user: "+e.getMessage());
            e.printStackTrace(); // is used to print the stack trace of an exception (represented by e), which is helpful for debugging.
         }
      }
   } catch (SQLException e) {
      throw new RuntimeException(e); //throw: This keyword is used to explicitly throw an exception in Java.
      //RuntimeException is a type of unchecked exception in Java. It is a subclass of Exception, but it does not need to be declared or caught explicitly (unlike checked exceptions).
      //The argument e represents the original exception that was caught earlier (in a catch block). By passing e to the constructor of RuntimeException, you are wrapping the original exception inside a new RuntimeException.
   }

   }






}


