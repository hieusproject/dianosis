/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
<<<<<<< HEAD
 * @author VanHau
 */
public class SolutionLike {

    public SolutionLike(int s_id, int u_id) {
        this.s_id = s_id;
        this.u_id = u_id;
    }

    public void setS_id(int s_id) {
        this.s_id = s_id;
    }

    public void setU_id(int u_id) {
=======
 * @author AnNguyen
 */
public class SolutionLike {
    private int s_id;
    private int u_id;

    public SolutionLike() {
    }

    public SolutionLike(int s_id, int u_id) {
        this.s_id = s_id;
>>>>>>> 8c2ef073e87409a9ae48cf18e2950efe78d8c5bc
        this.u_id = u_id;
    }

    public int getS_id() {
        return s_id;
    }

<<<<<<< HEAD
    public int getU_id() {
        return u_id;
    }
    private int s_id,u_id;
=======
    public void setS_id(int s_id) {
        this.s_id = s_id;
    }

    public int getU_id() {
        return u_id;
    }

    public void setU_id(int u_id) {
        this.u_id = u_id;
    }
    
    
>>>>>>> 8c2ef073e87409a9ae48cf18e2950efe78d8c5bc
}
