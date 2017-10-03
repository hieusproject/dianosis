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
public class TestType {
    private int type_id;
    private String type_name;
    private String question_src;

    public TestType() {
    }

    public TestType(int type_id, String type_name, String question_src) {
        this.type_id = type_id;
        this.type_name = type_name;
        this.question_src = question_src;
    }

    public int getType_id() {
        return type_id;
    }

    public void setType_id(int type_id) {
        this.type_id = type_id;
    }

    public String getType_name() {
        return type_name;
    }

    public void setType_name(String type_name) {
        this.type_name = type_name;
    }

    public String getQuestion_src() {
        return question_src;
    }

    public void setQuestion_src(String question_src) {
        this.question_src = question_src;
    }
    
    
}
