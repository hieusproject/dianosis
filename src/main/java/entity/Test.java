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
    private String result_test;
    private int deleted;

    public Test() {
    }

    public Test(int test_id, int type_id, int ex_id, String result_test, int deleted) {
        this.test_id = test_id;
        this.type_id = type_id;
        this.ex_id = ex_id;
        this.result_test = result_test;
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

    public String getResult_test() {
        return result_test;
    }

    public void setResult_test(String result_test) {
        this.result_test = result_test;
    }

    public int getDeleted() {
        return deleted;
    }

    public void setDeleted(int deleted) {
        this.deleted = deleted;
    }

   
    
}
