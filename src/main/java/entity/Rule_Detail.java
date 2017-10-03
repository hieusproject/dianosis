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
public class Rule_Detail {
    private int detail_id;
    private int rule_id;
    private String test_type_id;
    private int level;

    public Rule_Detail() {
    }

    public Rule_Detail(int detail_id, int rule_id, String test_type_id, int level) {
        this.detail_id = detail_id;
        this.rule_id = rule_id;
        this.test_type_id = test_type_id;
        this.level = level;
    }

    public int getDetail_id() {
        return detail_id;
    }

    public void setDetail_id(int detail_id) {
        this.detail_id = detail_id;
    }

    public int getRule_id() {
        return rule_id;
    }

    public void setRule_id(int rule_id) {
        this.rule_id = rule_id;
    }

    public String getTest_type_id() {
        return test_type_id;
    }

    public void setTest_type_id(String test_type_id) {
        this.test_type_id = test_type_id;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
    
    
}
