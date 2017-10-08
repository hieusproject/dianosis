/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataUtil;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author AnNguyen
 */
public class Converter {
    public static java.sql.Date toSQLDATE(java.util.Date javaDate)    {   
        return new java.sql.Date(javaDate.getTime()); 
    }
    
}
