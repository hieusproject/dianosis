/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;


import entity.Child;
import entity.User;
import java.io.File;

import java.io.IOException;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

import org.w3c.dom.Document;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.xml.sax.SAXException;
import repository.ChildRepository;
import DataUtil.PassWordUtil;
import entity.Token;
import java.sql.Date;
import java.util.HashMap;
import java.util.Map;
import repository.TokenRepository;
import repository.UserRepository;

/**
 *
 * @author AnNguyen
 */
@RestController
@RequestMapping(value = "/ManageUser")
public class UserController {
    private static UserRepository userRepository= new UserRepository();
    private static ChildRepository childRepository=new ChildRepository();
    private static TokenRepository tokenRepository= new TokenRepository();
    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public Object sayHello() throws ParserConfigurationException, SAXException, IOException{
    File xmlfile=
    new File("C:\\Users\\AnNguyen\\Documents\\NetBeansProjects\\Diagnosis_services\\src\\main\\webapp\\WEB-INF\\files\\xmlfile.xml");
    DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	Document doc = (Document) dBuilder.parse(xmlfile);
        
    
    return doc;
    }
    @RequestMapping(value = "/getUsers",method = RequestMethod.GET)
    public ArrayList <Object> getAllUser(){
            ArrayList<Object> users= userRepository.getAll();
            return users;
    }
    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public Map saveNewUser(@RequestParam(name="username") String username,@RequestParam(name="password") String password,
                                @RequestParam(name="fullname") String fullname, @RequestParam(name="address") String address,
                                @RequestParam(name="phone") String phone, @RequestParam(name="email") String email,
                                @RequestParam(name="age") String ageStr, @RequestParam(name="date_created") String date_createdStr,
                                @RequestParam(name="role") String role
                                ) throws NoSuchAlgorithmException{
        String error="";
        Map respone= new HashMap();
        Date age=null;
        Date date_create=null;
        boolean success=false;
        try {
            age= DataUtil.DataUtil.toSQLDATE(DataUtil.DataUtil.StringtoDate(ageStr));
            date_create=DataUtil.DataUtil.toSQLDATE(DataUtil.DataUtil.StringtoDate(date_createdStr));
            success=true;
        } catch (Exception e) {
            error="Dinh dang ngay khong dung";
            success=false;
        }
        if (userRepository.isExist(username)) {
            success=false;
            error="User nay da ton tai";
        }
        int u_id=0;
        if (success) {
              User newUser= new User(0, username, password, fullname, address, phone, email, age, date_create, 0);
              success= userRepository.save(newUser);
              newUser= userRepository.getUserByInput(username, password);
              u_id= newUser.getU_id();
        }
      
        if (success) {
            String newToken= DataUtil.DataUtil.newTokenforUser(u_id);
            Token token= new Token(0, u_id, newToken);
            tokenRepository.save(token);
            respone.put("status", "1");
            respone.put("token", newToken);
        } else {
            respone.put("status", "0");
            respone.put("fail_message", error);
        }
        
          
       return respone; 
    }
    @RequestMapping(value = "/getUserByinput",method = RequestMethod.POST)
    public User getUserByInput(@RequestParam(name="username") String username,
                                @RequestParam(name="password") String password) throws NoSuchAlgorithmException{
         password= PassWordUtil.hashPassword(password);
         User user=userRepository.getUserByInput(username, password);
         return user;   
    }
    @RequestMapping(value = "/getChildsOfUser",method = RequestMethod.GET)
    public ArrayList<Child> getChildsOfUser(@RequestParam(name="u_id") String u_id 
                               ) throws NoSuchAlgorithmException{
         ArrayList<Child> childs= childRepository.getChildsOfUser(Integer.parseInt(u_id));
         return childs;   
    }
    
}
