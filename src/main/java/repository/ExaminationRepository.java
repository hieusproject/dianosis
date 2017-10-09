/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import entity.Child;
import entity.Examination;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author AnNguyen
 */
public class ExaminationRepository {
     private static Connection connection= Conector.getConnection();
    public ArrayList<Object> getAll() {
        ArrayList<Object> childs= new ArrayList<Object>();
        try {
            String getSQL="SELECT * FROM `examination`";
            PreparedStatement getST= connection.prepareStatement(getSQL);
            ResultSet rs=getST.executeQuery();
            while (rs.next()) {      
              
                Examination exam= new Examination(rs.getInt("ex_id"), rs.getInt("c_id"), rs.getInt("test_rule_id"),rs.getString("exam_result"),
                        rs.getDate("date"));
              childs.add(exam);
            }
            
        } catch (Exception e) {
        }
        return childs;
    }
}
