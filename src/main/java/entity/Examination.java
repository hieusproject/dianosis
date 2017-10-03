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
public class Examination {
    private int ex_id;
    private int c_id;
    private int rule_id;
    private String result_ex;
    private String date;

    public Examination() {
    }

    public Examination(int ex_id, int c_id, int rule_id, String result_ex, String date) {
        this.ex_id = ex_id;
        this.c_id = c_id;
        this.rule_id = rule_id;
        this.result_ex = result_ex;
        this.date = date;
    }

    public int getEx_id() {
        return ex_id;
    }

    public void setEx_id(int ex_id) {
        this.ex_id = ex_id;
    }

    public int getC_id() {
        return c_id;
    }

    public void setC_id(int c_id) {
        this.c_id = c_id;
    }

    public int getRule_id() {
        return rule_id;
    }

    public void setRule_id(int rule_id) {
        this.rule_id = rule_id;
    }

    public String getResult_ex() {
        return result_ex;
    }

    public void setResult_ex(String result_ex) {
        this.result_ex = result_ex;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
    
    
}
