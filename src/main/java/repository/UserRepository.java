/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;


import DataUtil.Converter;
import entity.User;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author AnNguyen
 */
public class UserRepository implements RepositoryInterface{
    private static Connection connection= Conector.getConnection();
    
    public ArrayList<User> getNormalUser(){
    ArrayList<User> users=new ArrayList<User>();
     try {
      
           String sqlString= "SELECT * FROM `user`";
           PreparedStatement getStatement= connection.prepareStatement(sqlString);
           ResultSet rs= getStatement.executeQuery();
             while (rs.next()) {                 
                 User user= new User(rs.getInt("u_id"), rs.getString("username"),
                         rs.getString("password"), rs.getString("fullName"),
                         rs.getString("address"), rs.getString("phone"),
                         rs.getString("email"), rs.getDate("age"),
                         rs.getDate("date_created"),rs.getInt("role"));
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
      
           String sqlString= "SELECT * FROM `user` WHERE userName= ? and password=?";
           PreparedStatement getStatement= connection.prepareStatement(sqlString);
                        getStatement.setString(1,username);
                        getStatement.setString(2,password);
           ResultSet rs= getStatement.executeQuery();
           
             while (rs.next()) {                 
                 User user= new User(rs.getInt("u_id"), rs.getString("username"),
                         rs.getString("password"), rs.getString("fullName"),
                         rs.getString("address"), rs.getString("phone"),
                         rs.getString("email"), rs.getDate("age"),
                         rs.getDate("date_created"),rs.getInt("role"));
                 return user;
             }
       } catch (Exception e) {
       }
    return null;
    
    }

    public boolean save(Object ob) {
       User user=(User) ob; 
       try {  
         
           String sqlString= "INSERT INTO `user`"
                   + " (`userName`, `password`, `fullName`, `address`, `phone`, `email`, `age`, `date_created`, `role`)"
                   + " VALUES (?,?,?,?,?,?,?,?,?)";
           PreparedStatement insertStatement= connection.prepareStatement(sqlString);
           insertStatement.setString(1,user.getUsername());
           insertStatement.setString(2,user.getPassword());
           insertStatement.setString(3, user.getFullname());
           insertStatement.setString(4, user.getAddress());
           insertStatement.setString(5, user.getPhone());
           insertStatement.setString(6, user.getEmail());
           insertStatement.setDate(7, user.getAge());
           insertStatement.setDate(8, user.getDate_created());
           insertStatement.setInt(9,user.getRole());
           int result=insertStatement.executeUpdate();
          
           if (result==0) {
               System.out.println("insert failed");
             return false;
               
             
         } else {
              return true; 
         }
       } catch (Exception e) {
           e.printStackTrace();
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
      
           String sqlString= "SELECT * FROM `user`";
           PreparedStatement getStatement= connection.prepareStatement(sqlString);
           ResultSet rs= getStatement.executeQuery();
             while (rs.next()) {    
            
                  User user= new User(rs.getInt("u_id"), rs.getString("username"),
                         rs.getString("password"), rs.getString("fullName"),
                         rs.getString("address"), rs.getString("phone"),
                         rs.getString("email"), rs.getDate("age"),
                         rs.getDate("date_created"),rs.getInt("role"));
                 users.add(user);
             }
       } catch (Exception e) {
       }
    return  users;
    }
     
    public static void main(String[] args) throws ParseException {
        String dateStr="05/05/1994";
        SimpleDateFormat format= new SimpleDateFormat("mm/dd/yyyy");
        java.util.Date date= format.parse(dateStr);
        java.util.Date currentDate= new java.util.Date();
        User user= new User(0, "admin", "admin",
                "Nguyễn Admin", "QN", "0976679753","adcm.edu@gmail",
                Converter.toSQLDATE(date), Converter.toSQLDATE(currentDate), 0);
        UserRepository uRepository= new UserRepository();
//        System.out.println(uRepository.getAll());
        User us= uRepository.getUserByInput("user01","aad415a73c4cef1ef94a5c00b2642b571a3e5494536328ad960db61889bd9368");
        System.out.println(us.getFullname());
    }
}
