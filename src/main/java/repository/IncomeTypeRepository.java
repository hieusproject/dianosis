/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import entity.ExtraInfo;
import entity.IncomeType;
import entity.TestType;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author VanHau
 */
public class IncomeTypeRepository implements RepositoryInterface{
    private static Connection connection= Conector.getConnection();
     @Override
    public ArrayList<Object> getAll() {
        ArrayList<Object> imcome_types= new ArrayList<Object>();
        try {
            String getSQL="SELECT * FROM `imcome_type`";
            PreparedStatement getST= connection.prepareStatement(getSQL);
            ResultSet rs=getST.executeQuery();
            while (rs.next()) {     
                IncomeType imcome_type= new IncomeType(rs.getInt("income_id"), rs.getString("range"));
                imcome_types.add(imcome_type);
            }
            
        } catch (Exception e) {
        }
        return imcome_types;
    }

       @Override
     public boolean save(Object ob) {
        try {
            IncomeType it= (IncomeType) ob;
             String sqlString= "INSERT INTO `imcome_type` (`range`)"
                     + " VALUES (?)";
           PreparedStatement insertStatement= connection.prepareStatement(sqlString);
           insertStatement.setString(1,it.getRange());
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
