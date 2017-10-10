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
public class ExaminationRepository implements RepositoryInterface{
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

    @Override
   public boolean save(Object ob) {
        try {
            Examination ex= (Examination) ob;
             String sqlString= "INSERT INTO `examination` (`c_id`,`test_rule_id`,`exam_result`,`date`) VALUES (?,?,?,?)";
           PreparedStatement insertStatement= connection.prepareStatement(sqlString);
           insertStatement.setInt(1,ex.getC_id());
           insertStatement.setInt(2,ex.getTest_rule_id());
           insertStatement.setString(3,ex.getExam_result());
           insertStatement.setDate(4,ex.getDate());
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
