/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import entity.SolutionLike;
import entity.SolutionRecommend;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author VanHau
 */
public class SolutionRecommendRepository implements RepositoryInterface{
            private static Connection connection= Conector.getConnection();
     @Override
    public ArrayList<Object> getAll() {
        ArrayList<Object> sols= new ArrayList<Object>();
        try {
            String getSQL="SELECT * FROM `child_solution_recommend`";
            PreparedStatement getST= connection.prepareStatement(getSQL);
            ResultSet rs=getST.executeQuery();
            while (rs.next()) {     
                SolutionRecommend solu= new SolutionRecommend(rs.getInt("c_id"),rs.getInt("s_id"),rs.getInt("rating"));
                sols.add(solu);
            }
            
        } catch (Exception e) {
        }
        return sols;
    }

    @Override
    public boolean save(Object ob) {
       SolutionRecommend sol=(SolutionRecommend) ob; 
       try {  
         
           String sqlString= "INSERT INTO `child_solution_recommend`"
                   + " (`s_id`,`rating` )"
                   + " VALUES (?,?)";
           PreparedStatement insertStatement= connection.prepareStatement(sqlString);
           insertStatement.setFloat(1,sol.getS_id());
           insertStatement.setFloat(2,sol.getRating());
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
    SolutionRecommend sol=(SolutionRecommend) ob; 
       try {  
         
           String sqlString= "UPDATE `child_solution_recommend` SET" 
                   + " `s_id`=?,`rating`=?"
                   + " WHERE `c_id`=?";
           PreparedStatement updateStatement= connection.prepareStatement(sqlString);
           updateStatement.setInt(1,sol.getS_id());
           updateStatement.setInt(2,sol.getRating());
           updateStatement.setInt(3,sol.getC_id());
           
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

