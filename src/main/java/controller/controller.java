/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.sun.jersey.core.header.FormDataContentDisposition;
import com.sun.jersey.multipart.FormDataParam;
import entity.User;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import static javax.swing.text.html.FormSubmitEvent.MethodType.POST;
import javax.ws.rs.Consumes;
import static javax.ws.rs.HttpMethod.POST;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.w3c.dom.Document;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.xml.sax.SAXException;
import repository.UserRepository;

/**
 *
 * @author AnNguyen
 */
@RestController
public class controller {
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
    public String getAllUser(){
            System.out.println("here you are");
            ArrayList<User> users= new UserRepository().getAllUser();
            return "index.jsp";
    }
    
}
