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
public class Rule {
    private int rule_id;
    private Date date_define;
    private int active;

    public Rule() {
    }

    public Rule(int rule_id, Date date_define, int active) {
        this.rule_id = rule_id;
        this.date_define = date_define;
        this.active = active;
    }

    public int getRule_id() {
        return rule_id;
    }

    public void setRule_id(int rule_id) {
        this.rule_id = rule_id;
    }

    public Date getDate_define() {
        return date_define;
    }

    public void setDate_define(Date date_define) {
        this.date_define = date_define;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }
    
    
}
