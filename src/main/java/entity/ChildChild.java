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
public class ChildChild {
    private int c_id1,c_id2;
    private float similarity;

    public ChildChild(int c_id1, int c_id2, float similarity) {
        this.c_id1 = c_id1;
        this.c_id2 = c_id2;
        this.similarity = similarity;
    }

    public void setC_id1(int c_id1) {
        this.c_id1 = c_id1;
    }

    public void setC_id2(int c_id2) {
        this.c_id2 = c_id2;
    }

    public void setSimilarity(float similarity) {
        this.similarity = similarity;
    }

    public int getC_id1() {
        return c_id1;
    }

    public int getC_id2() {
        return c_id2;
    }

    public float getSimilarity() {
        return similarity;
    }
    
}
