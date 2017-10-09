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
public class IncomeType {
    private int income_id;
    private String range;

    public IncomeType(int income_id, String range) {
        this.income_id = income_id;
        this.range = range;
    }

    public int getIncome_id() {
        return income_id;
    }

    public String getRange() {
        return range;
    }

    public void setIncome_id(int income_id) {
        this.income_id = income_id;
    }

    public void setRange(String range) {
        this.range = range;
    }
    
}
