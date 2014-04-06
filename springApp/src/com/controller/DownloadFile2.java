package com.controller;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DownloadFile2 {
@RequestMapping("/downloadFile2.htm")
	public String downloadFile(@RequestParam("number")int number ,HttpServletRequest request,HttpServletResponse response) {
	byte[] buffer = new byte[1024];
	String realPath = request.getServletContext().getRealPath("/");
	try{

		FileOutputStream fos = new FileOutputStream(realPath+"MyFile.zip");
		ZipOutputStream zos = new ZipOutputStream(fos);
		for(int i=1;i<=number;i++){
		ZipEntry ze= new ZipEntry("spy"+i+".log");
		zos.putNextEntry(ze);
		FileInputStream in = new FileInputStream(realPath+"spy.log");

		int len;
		while ((len = in.read(buffer)) > 0) {
			zos.write(buffer, 0, len);
		}
		
		in.close();
		}
		zos.closeEntry();

		//remember close it
		zos.close();

		System.out.println("Done");
		 response.setContentType("application/zip");
         response.setHeader("Content-Disposition", "attachment; filename=MyFile.zip");


	
	ServletOutputStream out = response.getOutputStream();
	File file=new File(realPath+"MyFile.zip");

	FileInputStream in=new FileInputStream(file);
    BufferedInputStream bufferedInputStream=new BufferedInputStream(in);
	byte[] outputByte = new byte[4096];
	//copy binary contect to output stream
	while(bufferedInputStream.read(outputByte, 0, 4096) != -1)
	{
		out.write(outputByte, 0, 4096);
	}
	in.close();
	out.flush();
	out.close();
	file.deleteOnExit();
	}catch(IOException ex){
		   ex.printStackTrace();
		}
		return null;
	}
}
