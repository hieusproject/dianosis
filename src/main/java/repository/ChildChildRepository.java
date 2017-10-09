/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import entity.ChildChild;
import entity.TestType;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author VanHau
 */
public class ChildChildRepository implements RepositoryInterface{
    private static Connection connection= Conector.getConnection();
     @Override
    public ArrayList<Object> getAll() {
        ArrayList<Object> child_childs= new ArrayList<Object>();
        try {
            String getSQL="SELECT * FROM `chile_child`";
            PreparedStatement getST= connection.prepareStatement(getSQL);
            ResultSet rs=getST.executeQuery();
            while (rs.next()) {     
                ChildChild child_child= new ChildChild(rs.getInt("c_id1"), rs.getFloat("similarity"),rs.getInt("c_id2"));
                child_childs.add(child_child);
            }
            
        } catch (Exception e) {
        }
        return child_childs;
    }

    @Override
    public boolean save(Object ob) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Object ob) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean deleteById(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
