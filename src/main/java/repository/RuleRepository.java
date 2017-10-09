/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import entity.Child;
import entity.Rule;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author AnNguyen
 */
public class RuleRepository {
    private static Connection connection= Conector.getConnection();
     public ArrayList<Object> getAll() {
        ArrayList<Object> rules= new ArrayList<Object>();
        try {
            String getSQL="SELECT * FROM `test_rule`";
            PreparedStatement getST= connection.prepareStatement(getSQL);
            ResultSet rs=getST.executeQuery();
            while (rs.next()) {      
              
                Rule rule= new Rule(rs.getInt("rule_id"), rs.getString("date_define"), rs.getInt("active"));
              rules.add(rule);
            }
            
        } catch (Exception e) {
        }
        return rules;
    }
}
