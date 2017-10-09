/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataUtil;

import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import repository.TokenRepository;

/**
 *
 * @author AnNguyen
 */
public class DataUtil {
    private static TokenRepository tokenRepository= new TokenRepository();
    public static java.sql.Date toSQLDATE(java.util.Date javaDate)    {   
        return new java.sql.Date(javaDate.getTime()); 
    }
    public static int getRandomInt(){
        Random randomor= new Random();
        int newRan=0;
        do {            
            newRan=randomor.nextInt();
        } while (newRan<0);
        return newRan;        
    }
     public static String generatingRandomCode(){
        int characterRan;
        int charCode=0;
        Random random= new Random();
        StringBuffer captchaStrBuffer= new StringBuffer();
        for (int i = 0; i <10; i++) {
//    
              characterRan= Math.abs(random.nextInt())%62;
              if (characterRan<26) {
                charCode=65+characterRan;
            }
              else if (characterRan<52) {
                charCode=97+(characterRan-26);
            }
              else{
                 charCode=48+(characterRan-52); 
              
              }
           captchaStrBuffer.append((char) charCode);   
        }
    
    return captchaStrBuffer.toString();
    }
    public static String newTokenforUser(int u_id) throws NoSuchAlgorithmException{
         String newCode= Integer.toString(u_id)+
                    Integer.toString(tokenRepository.getMaxId())
                    +DataUtil.generatingRandomCode();
            newCode= PassWordUtil.hashPassword(newCode);
    return newCode;
    }
    public static Date StringtoDate(String dateString) throws ParseException{
		String DATE_FORMAT = "mm/dd/yyyy";
		SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
		Date date = sdf.parse(dateString);
		return date;
	}
    public static void main(String[] args) throws ParseException {
        System.out.println(StringtoDate("05/05/1994").toString());
    }
}
