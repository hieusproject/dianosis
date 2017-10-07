/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import entity.User;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author AnNguyen
 */
public class Conector {
    public static Connection getConnection(){
        Connection connection = null;
         try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Where is your MySQL JDBC Driver?");
            e.printStackTrace();
            return null;
        }
        
        try {
            connection =  DriverManager.getConnection("jdbc:mysql://localhost:3306/autism_diagnosis_service", "root","");
            System.out.println("connect successfull");
           
        } catch (Exception e) {
            System.out.println("conection failed");
            connection = null;
        }
        return connection;
    }
    
    public static void main(String[] args) throws SQLException {
        UserRepository usreRepository= new UserRepository();
        User us= (User) usreRepository.getAll().get(0);
        User user= new User(0,"user01","user01","user01","Quang Nam","0976679753","annguyen.dev0594@gmail.com","05/05/94",2);
        usreRepository.save(user);
        System.out.println(us.getFullname());
    }
}
