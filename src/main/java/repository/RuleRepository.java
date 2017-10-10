/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import entity.Child;
import entity.Examination;
import entity.Rule;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author AnNguyen
 */
public class RuleRepository implements RepositoryInterface{
    private static Connection connection= Conector.getConnection();
     public ArrayList<Object> getAll() {
        ArrayList<Object> rules= new ArrayList<Object>();
        try {
            String getSQL="SELECT * FROM `test_rule`";
            PreparedStatement getST= connection.prepareStatement(getSQL);
            ResultSet rs=getST.executeQuery();
            while (rs.next()) {      
              
                Rule rule= new Rule(rs.getInt("rule_id"), rs.getDate("date_define"), rs.getInt("active"));
              rules.add(rule);
            }
            
        } catch (Exception e) {
        }
        return rules;
    }
      @Override
      public boolean save(Object ob) {
        try {
            Rule rl= (Rule) ob;
             String sqlString= "INSERT INTO `test_rule` (`date_define`,`active`) VALUES (?,?)";
           PreparedStatement insertStatement= connection.prepareStatement(sqlString);
           insertStatement.setDate(1,rl.getDate_define());
           insertStatement.setInt(2,rl.getActive());
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
