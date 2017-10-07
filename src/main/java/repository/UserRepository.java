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
public class UserRepository implements RepositoryInterface{
    private static Connection connection= Conector.getConnection();
    
    public ArrayList<User> getNormalUser(){
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
                 if (user.getRole()==1) {
                     continue;
                 }
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

    public boolean save(Object ob) {
       User user=(User) ob; 
       try {  
           String password= PassWordUtil.hashPassword(user.getPassword());
           String sqlString= "INSERT INTO `usertb`"
                   + "(`_username`, `_password`, `fullName`, `address`, `phone`, `email`, `birthdate`, `role`)"
                   + " VALUES (?,?,?,?,?,?,?,?)";
           PreparedStatement insertStatement= connection.prepareStatement(sqlString);
           insertStatement.setString(1,user.getUsername());
           insertStatement.setString(2, password);
           insertStatement.setString(3, user.getFullname());
           insertStatement.setString(4, user.getAddress());
           insertStatement.setString(5, user.getPhone());
           insertStatement.setString(6, user.getEmail());
           insertStatement.setString(7, user.getBirthDate());
           insertStatement.setInt(8,user.getRole());
           int result=insertStatement.executeUpdate();
           if (result==0) {
             return false;
         } else {
              return true; 
         }
       } catch (Exception e) {
       }
    return false;  
    }

    public boolean update(Object ob) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean deleteById(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public ArrayList<Object> getAll() {
        ArrayList<Object> users=new ArrayList<Object>();
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
    return  users;
    }
     
    public static void main(String[] args) {
        new UserRepository().getAll();
    }
}
