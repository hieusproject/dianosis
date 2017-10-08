/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.sql.Date;

/**
 *
 * @author AnNguyen
 */
public class Child {
    private int c_id;
    private int u_id;
    private String fullName;
    private Date date_of_birth;
    private String father_name;
    private String mother_name;
    private int extra_infor_id;
    private Date date_created;
    private int deleted;
    public Child() {
    }

    public Child(int c_id, int u_id, String fullName, Date date_of_birth, String father_name, String mother_name,  int extra_infor_id, Date date_created,int deleted) {
        this.c_id = c_id;
        this.u_id = u_id;
        this.fullName = fullName;
        this.date_of_birth = date_of_birth;
        this.father_name = father_name;
        this.mother_name = mother_name;
        this.deleted = deleted;
        this.extra_infor_id = extra_infor_id;
        this.date_created = date_created;
    }

    public int getC_id() {
        return c_id;
    }

    public void setC_id(int c_id) {
        this.c_id = c_id;
    }

    public int getU_id() {
        return u_id;
    }

    public void setU_id(int u_id) {
        this.u_id = u_id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Date getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(Date date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    public String getFather_name() {
        return father_name;
    }

    public void setFather_name(String father_name) {
        this.father_name = father_name;
    }

    public String getMother_name() {
        return mother_name;
    }

    public void setMother_name(String mother_name) {
        this.mother_name = mother_name;
    }

    public int getDeleted() {
        return deleted;
    }

    public void setDeleted(int deleted) {
        this.deleted = deleted;
    }

    public int getExtra_infor_id() {
        return extra_infor_id;
    }

    public void setExtra_infor_id(int extra_infor_id) {
        this.extra_infor_id = extra_infor_id;
    }

    public Date getDate_created() {
        return date_created;
    }

    public void setDate_created(Date date_created) {
        this.date_created = date_created;
    }

    
   
  
}
