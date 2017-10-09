/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import entity.Token;
import entity.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author AnNguyen
 */
public class TokenRepository implements RepositoryInterface{
    private static Connection connection= Conector.getConnection();

    public boolean save(Object ob) {
        try {
            Token tk= (Token) ob;
             String sqlString= "INSERT INTO `token`(`u_id`, `token`) VALUES (?,?)";
           PreparedStatement insertStatement= connection.prepareStatement(sqlString);
           insertStatement.setInt(1,tk.getU_id());
           insertStatement.setString(2,tk.getToken_code());
           int result=insertStatement.executeUpdate();
          
             if (result==0) {
                    System.out.println("insert failed");
                    return false;
              } else {
              return true; 
                }
        } catch (Exception e) {
            return false;
        }
        
    }

    public boolean update(Object ob) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean deleteById(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public ArrayList<Object> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public Token getTokenByCode(String hashCode){
     try {
      
           String sqlString= "SELECT * FROM `token` WHERE token.token=?";
           PreparedStatement getStatement= connection.prepareStatement(sqlString);
                        getStatement.setString(1,hashCode);
           ResultSet rs= getStatement.executeQuery();
           
             while (rs.next()) {                 
                 Token token= new Token(rs.getInt("tk_id"), rs.getInt("u_id"),rs.getString("token"));
                 return token;
             }
       } catch (Exception e) {
           return null;
       }
    return null;
    
    }

    public int getMaxId(){
        int max_id=-1;
        try {
      
           String sqlString= "SELECT MAX(tk_id) as max_id FROM `token`";
           PreparedStatement getStatement= connection.prepareStatement(sqlString);
                      
           ResultSet rs= getStatement.executeQuery();
           
             while (rs.next()) {                 
                 
                 max_id= rs.getInt("max_id");
             }
       } catch (Exception e) {
           
       }
    return max_id; 
    
    }
    public static void main(String[] args) {
        System.out.println(new TokenRepository().getMaxId());
    }
}
