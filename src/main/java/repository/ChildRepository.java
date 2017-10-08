/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import entity.Child;
import entity.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author AnNguyen
 */
public class ChildRepository implements RepositoryInterface{
    private static Connection connection= Conector.getConnection();

    public boolean save(Object ob) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean update(Object ob) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
