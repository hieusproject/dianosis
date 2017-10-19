/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Token;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.annotation.MultipartConfig;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import repository.ChildChildRepository;
import repository.ExtraInfoRepository;
import repository.TokenRepository;

/**
 *
 * @author AnNguyen
 */
@RestController
public class ChildController {
    TokenRepository tokenRepository=new TokenRepository();
    ChildChildRepository childRepository = new ChildChildRepository();
    ExtraInfoRepository extraInfoRepository= new ExtraInfoRepository();
@RequestMapping(value = "newchild",method = RequestMethod.POST)     
public Map newChild(
        @RequestParam(name="token") String token,
        @RequestParam(name="fullname") String fullname,
        @RequestParam(name="date_of_birth") String date_of_birth,
        @RequestParam(name="farther") String farther,
        @RequestParam(name="mother") String mother,
        @RequestParam(name="father_career") String father_career,
        @RequestParam(name="mother_career") String mother_career,
        @RequestParam(name="monthly_income") String monthly_income,
        @RequestParam(name="child_sex") String child_sex
                        ){
     Map respone = new HashMap();
     Token tokenOb = tokenRepository.getTokenByCode(token);
       
        if (token==null) {
            respone.put("status","0");
        } else {
             
        }

return respone;
}    
    
    
    
}
