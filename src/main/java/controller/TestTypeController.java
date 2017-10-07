/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

/**
 *
 * @author AnNguyen
 */
@RestController
@RequestMapping(value = "/ManageTest")
public class TestTypeController {
 @RequestMapping(value={"/upload"}, method = RequestMethod.POST,produces = "text/html; charset=utf-8")
 @ResponseBody
 public String upload(MultipartHttpServletRequest request /*@RequestBody MultipartFile file*/){
    String responseMessage = "OK";
    MultipartFile file = request.getFile("file");
    String param = request.getParameter("typename");
     System.out.println("controller.TestTypeController.upload()");
    try {
        System.out.println(file.getOriginalFilename());
        System.out.println("some param = "+param);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(file.getInputStream(), StandardCharsets.UTF_8));
        // read file
    }
    catch(Exception ex){
        ex.printStackTrace();
        responseMessage = "fail";
    }
     return responseMessage;
}
    
}
