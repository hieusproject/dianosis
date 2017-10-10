/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import entity.ExtraInfo;
import entity.Rule_Detail;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author AnNguyen
 */
public class Rule_detailRepository implements RepositoryInterface{
     private static Connection connection= Conector.getConnection();
     public ArrayList<Object> getAll() {
        ArrayList<Object> rule_details= new ArrayList<Object>();
        try {
            String getSQL="SELECT * FROM `test_ruler_detail`";
            PreparedStatement getST= connection.prepareStatement(getSQL);
            ResultSet rs=getST.executeQuery();
            while (rs.next()) {      
              
                Rule_Detail rule_detail= new Rule_Detail(rs.getInt("detail_id"), rs.getInt("rule_id"),
                        rs.getString("test_type_id"),rs.getInt("level"));
              rule_details.add(rule_detail);
            }
            
        } catch (Exception e) {
        }
        return rule_details;
    }
         @Override
     public boolean save(Object ob) {
        try {
            Rule_Detail rl_dt= (Rule_Detail) ob;
             String sqlString= "INSERT INTO `test_ruler_detail` (`rule_id`,`test_type_id`,`level`)"
                     + " VALUES (?,?,?)";
           PreparedStatement insertStatement= connection.prepareStatement(sqlString);
           insertStatement.setInt(1,rl_dt.getRule_id());
           insertStatement.setString(2,rl_dt.getTest_type_id());
           insertStatement.setInt(3,rl_dt.getLevel());
           
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
