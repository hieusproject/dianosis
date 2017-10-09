/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author VanHau
 */
public class ExtraInfo {
   private int c_id,father_career_id,divorce_status,mother_career_id,monthly_income,sex,froup;
   private float height,weight;

    public ExtraInfo(int c_id, int father_career_id, int divorce_status, int mother_career_id, int monthly_income, int sex, int froup, float height, float weight) {
        this.c_id = c_id;
        this.father_career_id = father_career_id;
        this.divorce_status = divorce_status;
        this.mother_career_id = mother_career_id;
        this.monthly_income = monthly_income;
        this.sex = sex;
        this.froup = froup;
        this.height = height;
        this.weight = weight;
    }

    public int getC_id() {
        return c_id;
    }

    public int getFather_career_id() {
        return father_career_id;
    }

    public int getDivorce_status() {
        return divorce_status;
    }

    public int getMother_career_id() {
        return mother_career_id;
    }

    public int getMonthly_income() {
        return monthly_income;
    }

    public int getSex() {
        return sex;
    }

    public int getFroup() {
        return froup;
    }

    public float getHeight() {
        return height;
    }

    public float getWeight() {
        return weight;
    }

    public void setC_id(int c_id) {
        this.c_id = c_id;
    }

    public void setFather_career_id(int father_career_id) {
        this.father_career_id = father_career_id;
    }

    public void setDivorce_status(int divorce_status) {
        this.divorce_status = divorce_status;
    }

    public void setMother_career_id(int mother_career_id) {
        this.mother_career_id = mother_career_id;
    }

    public void setMonthly_income(int monthly_income) {
        this.monthly_income = monthly_income;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public void setFroup(int froup) {
        this.froup = froup;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }
   
}
