package com.scut.fan.DOM;
import java.io.File;  
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.xml.parsers.DocumentBuilder;  
import javax.xml.parsers.DocumentBuilderFactory;  
import javax.xml.parsers.ParserConfigurationException;
  
import org.w3c.dom.Attr;
import org.w3c.dom.Comment;
import org.w3c.dom.Document;  
import org.w3c.dom.Element;  
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class acxReader {
	
	public ArrayList<String[]> parseAcxAtomByXYZ(Element element,ArrayList<String[]> strs){
		  
		 
		 NodeList children = element.getChildNodes();

		 String Temp="init";
	      //element元素的所有属性所构成的NamedNodeMap对象，需要对其进行判断  
	      NamedNodeMap map = element.getAttributes();  
	        
	      //如果该元素存在属性  
	      if(null != map&&"atom".endsWith(element.getNodeName()))  
	      {  
	    	  String ID="init",HC="init",X="init",Y="init",Z="init";
	          for(int i = 0; i < map.getLength(); i++)  
	          {
	        	  
	              //获得该元素的每一个属性  
	              Attr attr = (Attr)map.item(i);  
	                
	              String attrName = attr.getName();  
	              String attrValue = attr.getValue();  
	                
	              System.out.println(" " + attrName + "=\"" + attrValue + "\"");  
	              if("id".endsWith(attrName)){
	            	  ID=String.valueOf(Integer.parseInt(attrValue.substring(2))-1);
	              }else
	            	  if("atomicNumber".endsWith(attrName)){
	            		  if("6".endsWith(attrValue)){
	            			  HC="1";
	            		  }else
	            			  if("1".endsWith(attrValue)){
	            				  HC="2";
	            			  }else
	            			  if("14".endsWith(attrValue)){
	            				  HC="3";
	            			  }else{
	            				  System.out.println("解析错误，存在6和1外的其他值");
	            			  }
	            				  
	            	  }else
	            		  if("coord3DX".endsWith(attrName)){
	            			  X=attrValue;
	            		  }else
	            			  if("coord3DY".endsWith(attrName)){
		            			  Y=attrValue;
		            		  }else
		            			  if("coord3DZ".endsWith(attrName)){
			            			  Z=attrValue;
			            		  }else{
			            			  System.out.println("解析错误！存在ID、atomicNumber、coord3DX、coord3DY、coord3DZ外的其他值");
			            		  }
	          }  
	          
	          if(!"init".endsWith(ID)&&!"init".endsWith(HC)&&!"init".endsWith(X)&&!"init".endsWith(Y)&&!"init".endsWith(Z)){
	        	  Temp=ID+"#"+HC+"#"+X+"#"+Y+"#"+Z;
	        	  String[] str=Temp.split("#");
	        	  strs.add(str);
	          }
	          
	          
	          String tagName = element.getNodeName();
			  System.out.println("已解析标签：" + tagName); 
	          
	      }  

	     for(int i = 0; i < children.getLength(); i++)  
	     {  
	         Node node = children.item(i);
		   
	         //获得结点的类型  
	         short nodeType = node.getNodeType();  
	           
	         if(nodeType == Node.ELEMENT_NODE)  
	         {  
	             //是元素，继续递归  
	             strs=parseAcxAtomByXYZ((Element)node,strs);  
	         }  
	         else if(nodeType == Node.TEXT_NODE)  
	         {  
	             //递归出口  
//	             System.out.print(node.getNodeValue()); 
	         }  
	         else if(nodeType == Node.COMMENT_NODE)  
	         {  
	             System.out.print("<!--"); 
	             
	             Comment comment = (Comment)node;  
	                  
	             //注释内容  
	             String data = comment.getData();  
	               
	             System.out.print(data);                   
	             System.out.print("-->");  
	            }  
	        }  
	        	     
	     return strs;
	}
	
	public  void parseAcxAtomByXYZ(String inPath,String outPath) throws ParserConfigurationException, SAXException, IOException{
		  // step 1: 获得dom解析器工厂（工作的作用是用于创建具体的解析器）  
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();  
          
          
        // step 2:获得具体的dom解析器  
        DocumentBuilder db = dbf.newDocumentBuilder();  
           
          
        // step3: 解析一个xml文档，获得Document对象（根结点）  
        Document doc = db.parse(new File(inPath));
        
        
        Element root = doc.getDocumentElement();  
        
        ArrayList<String[]> alist=new ArrayList<String[]>();
        acxReader acx=new acxReader();
        alist=acx.parseAcxAtomByXYZ(root,alist); 
        

        hsdWriter writer=new hsdWriter();
        writer.Write(alist,outPath);
	}
	
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		
//        String inPath="C:/Users/FAN/Desktop/近来烦事/数据转换/数据转换/原始数据/SWNT3.acx";
		String inPath="C:/Users/FAN/Desktop/近来烦事/数据转换/数据转换/原始数据/model6/";
        String outPath="C:/Users/FAN/Desktop/";
//        acxReader acx=new acxReader();
//        acx.parseAcxAtomByXYZ(inPath, outPath);
        for(int i=25;i<=28;i++){
        	String tempPath=inPath+i+".acx";
        	String tempOut=outPath+"shape"+i+".gen";
        	acxReader acxt=new acxReader();
            acxt.parseAcxAtomByXYZ(tempPath, tempOut);
        }
        
        
//        JFileChooser jf = new JFileChooser();
//        jf.setDialogTitle("请选择要解析的文件");
//        int result = jf.showOpenDialog(MainFrame.this);
//        jf.setVisible(true);
//        File selectedFile = null;
//        if (result == JFileChooser.APPROVE_OPTION) {
//            System.out.println("OK button is pushed.");
//            selectedFile = jf.getSelectedFile();
//            if (selectedFile.exists()) {
//                System.out.println("Yes! You have selected the right file.");
//            } else {
//                System.out.println("No! You did not select the right file.");
//            }
//        } else if (result == JFileChooser.CANCEL_OPTION) {
//            System.out.println("Cancel button is pushed.");
//        } else if (result == JFileChooser.ERROR_OPTION) {
//            System.err.println("Error when select file.");
//        }

	}
}
