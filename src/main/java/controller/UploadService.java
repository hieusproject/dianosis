/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.sun.jersey.core.header.FormDataContentDisposition;
import com.sun.jersey.multipart.FormDataParam;
import entity.Token;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import repository.ChildChildRepository;
import repository.ExtraInfoRepository;
import repository.TokenRepository;

/**
 *
 * @author AnNguyen
 */
@Path("/file")
public class UploadService {
    String root= "C:\\Users\\AnNguyen\\Documents\\NetBeansProjects"
                        + "\\Diagnosis_services\\src\\main\\webapp\\files\\";
    TokenRepository tokenRepository=new TokenRepository();
    ChildChildRepository childRepository = new ChildChildRepository();
    ExtraInfoRepository extraInfoRepository= new ExtraInfoRepository();
    @POST
    @Path("/newChild")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public Map uploadFile(
		@FormDataParam ("file") InputStream uploadedInputStream,
		@FormDataParam ("file") FormDataContentDisposition fileDetail,
                @FormDataParam ("token") String token,
                @FormDataParam ("fullname") String fullname,
                @FormDataParam ("date_of_birth") String date_of_birth,
                @FormDataParam ("father") String father,
                @FormDataParam ("mother") String mother,
                @FormDataParam ("father_career") String father_career,
                @FormDataParam ("mother_career") String mother_career,
                @FormDataParam ("monthly_income") String monthly_income,
                @FormDataParam ("child_sex") String child_sex
                                    ) {
                Map respone = new HashMap();
                Token tokenOb = tokenRepository.getTokenByCode(token);
                String uploadedFileLocation = root+ fileDetail.getFileName();
                String fileName= fileDetail.getFileName();
                if (token==null) {
                    respone.put("status","0");
                } else {
                    writeToFile(uploadedInputStream, uploadedFileLocation);
                    
                }
		

		// save it
		
                
		

                return null;
	}

	// save uploaded file to new location
	private void writeToFile(InputStream uploadedInputStream,
		String uploadedFileLocation) {

		try {
			OutputStream out = new FileOutputStream(new File(
					uploadedFileLocation));
			int read = 0;
			byte[] bytes = new byte[1024];

			out = new FileOutputStream(new File(uploadedFileLocation));
			while ((read = uploadedInputStream.read(bytes)) != -1) {
				out.write(bytes, 0, read);
			}
			out.flush();
			out.close();
		} catch (IOException e) {

			e.printStackTrace();
		}

	}
}
