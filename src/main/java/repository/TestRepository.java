/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import entity.Examination;
import entity.Solution;
import entity.Test;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author AnNguyen
 */
public class TestRepository implements RepositoryInterface {
     private static Connection connection= Conector.getConnection();
     @Override
    public ArrayList<Object> getAll() {
        ArrayList<Object> tests= new ArrayList<Object>();
        try {
            String getSQL="SELECT * FROM `test`";
            PreparedStatement getST= connection.prepareStatement(getSQL);
            ResultSet rs=getST.executeQuery();
            while (rs.next()) {      
              
                Test test= new Test(rs.getInt("test_id"), rs.getInt("type_id"), rs.getInt("ex_id")
                        ,rs.getString("result_test"),
                        rs.getInt("deleted"));
              tests.add(test);
            }
            
        } catch (Exception e) {
        }
        return tests;
    }
   @Override
     public boolean save(Object ob) {
        try {
            Test test= (Test) ob;
             String sqlString= "INSERT INTO `test` (`type_id`,`ex_id`,`result_test`,`deleted`)"
                     + " VALUES (?,?,?,?)";
           PreparedStatement insertStatement= connection.prepareStatement(sqlString);
           insertStatement.setInt(1,test.getType_id());
           insertStatement.setInt(2,test.getEx_id());
           insertStatement.setString(3,test.getResult_test());
           insertStatement.setInt(4,test.getDeleted());
           int result=insertStatement.executeUpdate();
          
             if (result==0) {
                    System.out.println("insert failed");
                    return false;
              } else {
              return true; 
                }
        } catch (Exception e) {
            return false;
        }}


    @Override
    public boolean update(Object ob) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean deleteById(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   

    
}
