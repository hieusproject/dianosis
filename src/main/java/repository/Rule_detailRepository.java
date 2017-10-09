/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import entity.Rule_Detail;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author AnNguyen
 */
public class Rule_detailRepository {
     private static Connection connection= Conector.getConnection();
     public ArrayList<Object> getAll() {
        ArrayList<Object> rule_details= new ArrayList<Object>();
        try {
            String getSQL="SELECT * FROM `test_ruler_detail`";
            PreparedStatement getST= connection.prepareStatement(getSQL);
            ResultSet rs=getST.executeQuery();
            while (rs.next()) {      
              
                Rule_Detail rule_detail= new Rule_Detail(rs.getInt("detail_id"), rs.getInt("rule_id"), rs.getString("test_type_id"),rs.getInt("level"));
              rule_details.add(rule_detail);
            }
            
        } catch (Exception e) {
        }
        return rule_details;
    }
}
