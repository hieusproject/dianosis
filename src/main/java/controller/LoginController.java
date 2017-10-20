/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DataUtil.DataUtil;
import entity.Token;
import entity.User;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import DataUtil.PassWordUtil;
import static com.sun.xml.internal.ws.spi.db.BindingContextFactory.LOGGER;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.logging.Level;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import javax.ws.rs.core.Context;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import repository.TokenRepository;
import repository.UserRepository;

@RestController
public class LoginController {
   static UserRepository userRepository= new UserRepository();
   static  TokenRepository tokenRepository= new TokenRepository();
   
   
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public Map getUserByInput(@RequestParam(name="username") String username,
                                @RequestParam(name="password") String password) throws NoSuchAlgorithmException{
         Map respone= new HashMap();
         User user=userRepository.getUserByInput(username, password);
         if (user!=null) {
            //new token,save token
            String newCode= Integer.toString(user.getU_id())+
                    Integer.toString(tokenRepository.getMaxId())
                    +DataUtil.generatingRandomCode();
            newCode= PassWordUtil.hashPassword(newCode);
            Token tk= new Token(0,user.getU_id(), newCode);
            tokenRepository.save(tk);
            respone.put("status","1");
            respone.put("token",tk.getToken_code());
        } else {
            respone.put("status","0");
            respone.put("token","");
        }
         return respone;
    } 
    
    
    
    @RequestMapping(value="/login",method= RequestMethod.GET)
    public Map getUserTokenByCode(@RequestParam(name="token") String token){
        Map respone= new HashMap();
        Token tk= tokenRepository.getTokenByCode(token);
        if (tk!=null) {
            respone.put("status","1");
            respone.put("token",tk.getToken_code());
        } else {
            respone.put("status","0");
            respone.put("token","");
        }
    return respone;
    }
  
    @RequestMapping( value = "/up",method = RequestMethod.POST)
    public Map sampleUpload(@RequestPart MultipartFile file) {
           Map respone= new HashMap();
           String fileName=file.getName();
           respone.put("filename", fileName);
           System.out.println(fileName);
        return  respone ;
    }
    private String getFileName(final Part part) {
    final String partHeader = part.getHeader("content-disposition");
    LOGGER.log(Level.INFO, "Part Header = {0}", partHeader);
    for (String content : part.getHeader("content-disposition").split(";")) {
        if (content.trim().startsWith("filename")) {
            return content.substring(
                    content.indexOf('=') + 1).trim().replace("\"", "");
        }
    }
    return null;
}
}
    