/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import entity.ChildChild;
import entity.SolutionLike;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author VanHau
 */
public class SolutionLikeRepository implements RepositoryInterface{
        private static Connection connection= Conector.getConnection();
     @Override
    public ArrayList<Object> getAll() {
        ArrayList<Object> sols= new ArrayList<Object>();
        try {
            String getSQL="SELECT * FROM `solution_like`";
            PreparedStatement getST= connection.prepareStatement(getSQL);
            ResultSet rs=getST.executeQuery();
            while (rs.next()) {     
                SolutionLike sol= new SolutionLike(rs.getInt("s_id"),rs.getInt("u_id"));
                sols.add(sol);
            }
            
        } catch (Exception e) {
        }
        return sols;
    }

    @Override
    public boolean save(Object ob) {
       SolutionLike sol=(SolutionLike) ob; 
       try {  
         
           String sqlString= "INSERT INTO `solution_like`"
                   + " (`u_id` )"
                   + " VALUES (?)";
           PreparedStatement insertStatement= connection.prepareStatement(sqlString);
           insertStatement.setFloat(1,sol.getU_id());
           int result=insertStatement.executeUpdate();
          
           if (result==0) {
               System.out.println("insert failed");
             return false;
               
             
         } else {
              return true; 
         }
       } catch (Exception e) {
           e.printStackTrace();
       }
    return false;  
    }

    @Override
    public boolean update(Object ob) {
    SolutionLike sol=(SolutionLike) ob; 
       try {  
         
           String sqlString= "UPDATE `solution_like` SET" 
                   + " `u_id`=?"
                   + " WHERE `s_id`=?";
           PreparedStatement updateStatement= connection.prepareStatement(sqlString);
           updateStatement.setInt(1,sol.getU_id());
           updateStatement.setInt(2,sol.getS_id());
           
           int result=updateStatement.executeUpdate();
          
           if (result==0) {
               System.out.println("update failed");
             return false;
               
             
         } else {
              return true; 
         }
       } catch (Exception e) {
           e.printStackTrace();
       }
    return false;      
    }

    @Override
    public boolean deleteById(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
