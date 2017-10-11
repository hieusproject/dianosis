/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import entity.Child;
import entity.Token;
import entity.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ChildRepository implements RepositoryInterface{
    private static Connection connection= Conector.getConnection();

    public boolean save(Object ob) {
        try {
            Child child= (Child) ob;
             String sqlString= "INSERT INTO `child`(`u_id`,`fullName`,`date_of_birth`,`father_name`,"
                     + "`mother_name`,`extra_info_id`,`date_created`,`deleted`) VALUES (?,?,?,?,?,?,?,?)";
           PreparedStatement insertStatement= connection.prepareStatement(sqlString);
           insertStatement.setInt(1,child.getU_id());
           insertStatement.setString(2,child.getFullName());
           insertStatement.setDate(3,child.getDate_of_birth());
           insertStatement.setString(4,child.getFather_name());
           insertStatement.setString(5,child.getMother_name());
           insertStatement.setInt(6,child.getExtra_infor_id());
           insertStatement.setDate(7,child.getDate_created());
           insertStatement.setInt(8,child.getDeleted());
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

   public boolean update(Object ob) {
    Child childs=(Child) ob; 
       try {  
         
           String sqlString= "UPDATE `child` SET" 
                   + " `u_id`=?, `fullName`=?, `date_of_birth`=?, `father_name`=?, "
                   + "`mother_name`=?, `extra_info_id`=?, `date_created`=?, `deleted`=?"
                   + " WHERE `c_id`=?";
           PreparedStatement updateStatement= connection.prepareStatement(sqlString);
           updateStatement.setInt(1,childs.getU_id());
           updateStatement.setString(2,childs.getFullName());
           updateStatement.setDate(3, childs.getDate_of_birth());
           updateStatement.setString(4, childs.getFather_name());
           updateStatement.setString(5, childs.getMother_name());
           updateStatement.setInt(6, childs.getExtra_infor_id());
           updateStatement.setDate(7, childs.getDate_created());
           updateStatement.setInt(8, childs.getDeleted());
           updateStatement.setInt(9,childs.getC_id());
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

    public boolean deleteById(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public ArrayList<Object> getAll() {
        ArrayList<Object> childs= new ArrayList<Object>();
        try {
            String getSQL="SELECT * FROM `child`";
            PreparedStatement getST= connection.prepareStatement(getSQL);
            ResultSet rs=getST.executeQuery();
            while (rs.next()) {      
              
                Child child= new Child(rs.getInt("c_id"), rs.getInt("u_id"), rs.getString("fullName"), 
                        rs.getDate("date_of_birth"), rs.getString("father_name"), rs.getString("mother_name"),
                        rs.getInt("extra_info_id"), rs.getDate("date_created"), rs.getInt("deleted"));
              childs.add(child);
            }
            
        } catch (Exception e) {
        }
        return childs;
    }
    public ArrayList<Child> getChildsOfUser(int id) {
        ArrayList<Child> childs= new ArrayList<Child>();
        try {
            String getSQL="SELECT * FROM `child` WHERE u_id=?";
            PreparedStatement getST= connection.prepareStatement(getSQL);
            getST.setInt(1, id);
            ResultSet rs=getST.executeQuery();
            while (rs.next()) {      
              
                Child child= new Child(rs.getInt("c_id"), rs.getInt("u_id"), rs.getString("fullName"), 
                        rs.getDate("date_of_birth"), rs.getString("father_name"), rs.getString("mother_name"),
                        rs.getInt("extra_info_id"), rs.getDate("date_created"), rs.getInt("deleted"));
              childs.add(child);
            }
            
        } catch (Exception e) {
        }
        return childs;
    }
    
    public static void main(String[] args) {
       int size= new ChildRepository().getChildsOfUser(2).size();
        System.out.println(Integer.toString(size));
    }
}
