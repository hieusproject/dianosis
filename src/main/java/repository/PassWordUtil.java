package repository;


import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author PC
 */
public class PassWordUtil {
    //page 533
    public static String hashPassword(String password)
            throws NoSuchAlgorithmException{
        MessageDigest md= MessageDigest.getInstance("SHA-256");
        md.update(password.getBytes());
        byte[] mArray=md.digest();
        StringBuilder sb= new StringBuilder(mArray.length*2);
        for(byte b:mArray){
            int v=b&0xff;
            if (v<16) {
                sb.append('0');
            }
            sb.append(Integer.toHexString(v));

        }
        return sb.toString();
    } 
    public static void main(String[] args) throws NoSuchAlgorithmException {
        System.out.println(""+hashPassword("admin"));
    }
}
