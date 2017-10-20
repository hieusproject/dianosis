/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;


public class SolutionLike {
    private int s_id;
    private int u_id;
    public SolutionLike(int s_id, int u_id) {
        this.s_id = s_id;
        this.u_id = u_id;
    }

    public SolutionLike() {
    }

    public int getS_id() {
        return s_id;
    }

    public void setS_id(int s_id) {
        this.s_id = s_id;
    }

    public int getU_id() {
        return u_id;
    }

    public void setU_id(int u_id) {
        this.u_id = u_id;
    }
    
}
   
