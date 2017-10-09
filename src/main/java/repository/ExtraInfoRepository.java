/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import entity.ExtraInfo;
import entity.TestType;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author VanHau
 */
public class ExtraInfoRepository implements RepositoryInterface{
    private static Connection connection= Conector.getConnection();
     @Override
    public ArrayList<Object> getAll() {
        ArrayList<Object> extra_infos= new ArrayList<Object>();
        try {
            String getSQL="SELECT * FROM `extra_info`";
            PreparedStatement getST= connection.prepareStatement(getSQL);
            ResultSet rs=getST.executeQuery();
            while (rs.next()) {     
                ExtraInfo extra_info= new ExtraInfo(rs.getInt("c_id"), rs.getInt("father_career_id"),rs.getInt("divorce_status")
                ,rs.getInt("mother_career_id"),rs.getInt("monthly_income"),rs.getFloat("height"),
                rs.getFloat("weight"),rs.getInt("sex"),rs.getInt("group"));
                extra_infos.add(extra_info);
            }
            
        } catch (Exception e) {
        }
        return extra_infos;
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
