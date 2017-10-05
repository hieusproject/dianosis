/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;


import entity.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author AnNguyen
 */
public class UserRepository {
    private static Connection connection= Conector.getConnection();
    public ArrayList<User> getAllUser(){
    ArrayList<User> users=new ArrayList<User>();
     try {
      
           String sqlString= "SELECT * FROM `usertb`";
           PreparedStatement getStatement= connection.prepareStatement(sqlString);
           ResultSet rs= getStatement.executeQuery();
             while (rs.next()) {                 
                 User user= new User(rs.getInt("u_id"), rs.getString("_username"),
                         rs.getString("_password"), rs.getString("fullName"),
                         rs.getString("address"), rs.getString("phone"),
                         rs.getString("email"), rs.getString("birthdate"), rs.getInt("role"));
                 users.add(user);
             }
       } catch (Exception e) {
       }
    return users;
    
    }
     public User getUserByInput(String username,String password){
     try {
      
           String sqlString= "SELECT * FROM `usertb` WHERE _username= ? and _password=?";
           PreparedStatement getStatement= connection.prepareStatement(sqlString);
                        getStatement.setString(1,username);
                        getStatement.setString(2,password);
           ResultSet rs= getStatement.executeQuery();
           
             while (rs.next()) {                 
                 User user= new User(rs.getInt("u_id"), rs.getString("_username"),
                         rs.getString("_password"), rs.getString("fullName"),
                         rs.getString("address"), rs.getString("phone"),
                         rs.getString("email"), rs.getString("birthdate"), rs.getInt("role"));
                 return user;
             }
       } catch (Exception e) {
       }
    return null;
    
    }
    
}
