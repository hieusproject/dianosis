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
public class Login_token {
    private int token_id;
    private int u_id;
    private String token_code;

    public Login_token() {
    }

    public Login_token(int token_id, int u_id, String token_code) {
        this.token_id = token_id;
        this.u_id = u_id;
        this.token_code = token_code;
    }

    public int getToken_id() {
        return token_id;
    }

    public void setToken_id(int token_id) {
        this.token_id = token_id;
    }

    public int getU_id() {
        return u_id;
    }

    public void setU_id(int u_id) {
        this.u_id = u_id;
    }

    public String getToken_code() {
        return token_code;
    }

    public void setToken_code(String token_code) {
        this.token_code = token_code;
    }
    
    
}
