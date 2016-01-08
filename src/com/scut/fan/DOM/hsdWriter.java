package com.scut.fan.DOM;

import java.util.ArrayList;
import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;

public class hsdWriter {
	
	public void Write(ArrayList<String[]> alist,String path) throws IOException{
		
		
		File file =new File(path);

	    if(!file.exists()){
	        file.createNewFile();
	    }
	    
	    FileWriter fileWritter = new FileWriter(path);
	    System.out.print(file.getName());
	    
	    BufferedWriter bufferWritter = new BufferedWriter(fileWritter);

	    String title_2="      "+alist.size()+"  C";
	    bufferWritter.write(title_2);
	    bufferWritter.newLine();
	    String title_3=" C H";
	    bufferWritter.write(title_3);

	    
	    for(String[] line:alist){
	    	String temp=""+line[0]+"  "+line[1]+"  "+line[2]+" "+line[3]+" "+line[4]+"  ";
	    	bufferWritter.newLine();
	    	bufferWritter.write(temp);

	    
	    }
	    
	    bufferWritter.close();
	    System.out.print("输出成功，请查看目录下文件");
		
	}
	
	
	 
}
