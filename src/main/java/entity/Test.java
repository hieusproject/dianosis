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
public class Test {
    private int test_id;
    private int type_id;
    private int ex_id;
    private String test_result_String;
    private String conclude_test;
    private int deleted;

    public Test() {
    }

    public Test(int test_id, int type_id, int ex_id, String test_result_String, String conclude_test, int deleted) {
        this.test_id = test_id;
        this.type_id = type_id;
        this.ex_id = ex_id;
        this.test_result_String = test_result_String;
        this.conclude_test = conclude_test;
        this.deleted = deleted;
    }

    public int getTest_id() {
        return test_id;
    }

    public void setTest_id(int test_id) {
        this.test_id = test_id;
    }

    public int getType_id() {
        return type_id;
    }

    public void setType_id(int type_id) {
        this.type_id = type_id;
    }

    public int getEx_id() {
        return ex_id;
    }

    public void setEx_id(int ex_id) {
        this.ex_id = ex_id;
    }

    public String getTest_result_String() {
        return test_result_String;
    }

    public void setTest_result_String(String test_result_String) {
        this.test_result_String = test_result_String;
    }

    public String getConclude_test() {
        return conclude_test;
    }

    public void setConclude_test(String conclude_test) {
        this.conclude_test = conclude_test;
    }

    public int getDeleted() {
        return deleted;
    }

    public void setDeleted(int deleted) {
        this.deleted = deleted;
    }
    
    
}
