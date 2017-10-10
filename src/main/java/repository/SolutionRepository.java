/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import entity.Examination;
import entity.Solution;
import entity.TestType;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author VanHau
 */
public class SolutionRepository implements  RepositoryInterface{
    private static Connection connection= Conector.getConnection();
     @Override
    public ArrayList<Object> getAll() {
        ArrayList<Object> solutions= new ArrayList<Object>();
        try {
            String getSQL="SELECT * FROM `solution`";
            PreparedStatement getST= connection.prepareStatement(getSQL);
            ResultSet rs=getST.executeQuery();
            while (rs.next()) {     
                Solution solution= new Solution(rs.getInt("s_id"), rs.getInt("u_id"),rs.getString("s_title"),
                        rs.getString("s_content"),rs.getString("s_picture"),rs.getDate("date_created"));
                solutions.add(solution);
            }
            
        } catch (Exception e) {
        }
        return solutions;
    }

    @Override
     public boolean save(Object ob) {
        try {
            Solution sl= (Solution) ob;
             String sqlString= "INSERT INTO `solution` (`u_id`,`s_title`,`s_content`,`s_picture`,`date_created`) VALUES (?,?,?,?,?)";
           PreparedStatement insertStatement= connection.prepareStatement(sqlString);
           insertStatement.setInt(1,sl.getU_id());
           insertStatement.setString(2,sl.getS_title());
           insertStatement.setString(3,sl.getS_content());
           insertStatement.setString(4,sl.getS_picture());
           insertStatement.setDate(5,sl.getDate_created());
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
