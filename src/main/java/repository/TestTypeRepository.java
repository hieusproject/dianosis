/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import entity.Test;
import entity.TestType;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author AnNguyen
 */
public class TestTypeRepository implements RepositoryInterface { 
    private static Connection connection= Conector.getConnection();
     @Override
    public ArrayList<Object> getAll() {
        ArrayList<Object> test_types= new ArrayList<Object>();
        try {
            String getSQL="SELECT * FROM `test_type`";
            PreparedStatement getST= connection.prepareStatement(getSQL);
            ResultSet rs=getST.executeQuery();
            while (rs.next()) {     
                TestType test_type= new TestType(rs.getInt("type_id"), rs.getString("type_name")
                        ,rs.getString("question_src"));
                test_types.add(test_type);
            }
            
        } catch (Exception e) {
        }
        return test_types;
    }
       
    @Override
     public boolean save(Object ob) {
        try {
            TestType test= (TestType) ob;
             String sqlString= "INSERT INTO `test_type` (`type_name`,`question_src`)"
                     + " VALUES (?,?)";
           PreparedStatement insertStatement= connection.prepareStatement(sqlString);
           insertStatement.setString(1,test.getType_name());
           insertStatement.setString(2,test.getQuestion_src());
           
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
