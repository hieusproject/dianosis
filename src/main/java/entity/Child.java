/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author AnNguyen
 */
public class Child {
    private int c_id;
    private int u_id;
    private String c_fullname;
    private String birhtdate;
    private double height; 
    private double weight;
    private String farther_name;
    private String morther_name;
    private int deleted;

    public Child() {
    }

    public Child(int c_id, int u_id, String c_fullname, String birhtdate, double height, double weight, String farther_name, String morther_name, int deleted) {
        this.c_id = c_id;
        this.u_id = u_id;
        this.c_fullname = c_fullname;
        this.birhtdate = birhtdate;
        this.height = height;
        this.weight = weight;
        this.farther_name = farther_name;
        this.morther_name = morther_name;
        this.deleted = deleted;
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

    public String getC_fullname() {
        return c_fullname;
    }

    public void setC_fullname(String c_fullname) {
        this.c_fullname = c_fullname;
    }

    public String getBirhtdate() {
        return birhtdate;
    }

    public void setBirhtdate(String birhtdate) {
        this.birhtdate = birhtdate;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getFarther_name() {
        return farther_name;
    }

    public void setFarther_name(String farther_name) {
        this.farther_name = farther_name;
    }

    public String getMorther_name() {
        return morther_name;
    }

    public void setMorther_name(String morther_name) {
        this.morther_name = morther_name;
    }

    public int getDeleted() {
        return deleted;
    }

    public void setDeleted(int deleted) {
        this.deleted = deleted;
    }
    
  
}
