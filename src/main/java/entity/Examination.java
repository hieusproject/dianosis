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
    private int test_rule_id;
    private String exam_result;
    private String date;

    public Examination() {
    }

    public Examination(int ex_id, int c_id, int test_rule_id, String exam_result, String date) {
        this.ex_id = ex_id;
        this.c_id = c_id;
        this.test_rule_id = test_rule_id;
        this.exam_result = exam_result;
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

    public int getTest_rule_id() {
        return test_rule_id;
    }

    public void setTest_rule_id(int test_rule_id) {
        this.test_rule_id = test_rule_id;
    }

    public String getExam_result() {
        return exam_result;
    }

    public void setExam_result(String exam_result) {
        this.exam_result = exam_result;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

   
    
}
