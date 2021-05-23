package com.itbank.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.itbank.service.InsertService;
import com.itbank.service.UploadService;

// ajaxController
@RestController
public class InsertController {
   
   @Autowired
   private InsertService is;
   @Autowired
   private UploadService us;
   
   private String fileName;
   
   
   @GetMapping(value="firstCall/{id}", produces = "application/text;charset=utf8")
   public String firstCall(@PathVariable String id) {
	   
	   String profileName = is.firstCall(id);
	   
	   return profileName;
	   
   }
   
   @GetMapping(value="idCheck/{id}", produces="application/text;charset=utf8")
   public String idCheck(@PathVariable String id) {
      
      String row = is.sameIdCheck(id);
      
      return row;
   }
   
   @PostMapping(value="upload", produces="application/text;charset=utf8")
   public String upload(MultipartFile file) throws IllegalStateException, IOException {
      
      fileName = file.getOriginalFilename();
      
      int row = us.uploadFile(file);
      
      return null;
   }
   @GetMapping(value="updateImg/{id}",produces = "application/text;charset=utf8")
   public void updateImg(@PathVariable String id) {
      int row = is.updateFileName(fileName,id);
   }
   
   @GetMapping(value="callImg/{id}",produces = "application/text;charset=utf8")
   public String recallImg(@PathVariable String id) {
      String imgName = is.callUpdateImgName(id);
      
      return imgName;
   }
   
}