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
import repository.PassWordUtil;
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
    public ArrayList <User> getAllUser(){
            ArrayList<User> users= userRepository.getNormalUser();
            return users;
    }
    @RequestMapping(value = "/saveNew",method = RequestMethod.POST)
    public boolean saveNewUser(@RequestBody User newUser){
        if (userRepository.save(newUser)) {
            return true;
        } 
     return false;
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
