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
public class Token {
    private int tk_id;
    private int u_id;
    private String token;

    public Token() {
    }

    public Token(int token_id, int u_id, String token_code) {
        this.tk_id = token_id;
        this.u_id = u_id;
        this.token = token_code;
    }

    public int getToken_id() {
        return tk_id;
    }

    public void setToken_id(int token_id) {
        this.tk_id = token_id;
    }

    public int getU_id() {
        return u_id;
    }

    public void setU_id(int u_id) {
        this.u_id = u_id;
    }

    public String getToken_code() {
        return token;
    }

    public void setToken_code(String token_code) {
        this.token = token_code;
    }
    
    
}
