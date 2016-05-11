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
	      //elementԪ�ص��������������ɵ�NamedNodeMap������Ҫ��������ж�  
	      NamedNodeMap map = element.getAttributes();  
	        
	      //�����Ԫ�ش�������  
	      if(null != map&&"atom".endsWith(element.getNodeName()))  
	      {  
	    	  String ID="init",HC="init",X="init",Y="init",Z="init";
	          for(int i = 0; i < map.getLength(); i++)  
	          {
	        	  
	              //��ø�Ԫ�ص�ÿһ������  
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
	            				  System.out.println("�������󣬴���6��1�������ֵ");
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
			            			  System.out.println("�������󣡴���ID��atomicNumber��coord3DX��coord3DY��coord3DZ�������ֵ");
			            		  }
	          }  
	          
	          if(!"init".endsWith(ID)&&!"init".endsWith(HC)&&!"init".endsWith(X)&&!"init".endsWith(Y)&&!"init".endsWith(Z)){
	        	  Temp=ID+"#"+HC+"#"+X+"#"+Y+"#"+Z;
	        	  String[] str=Temp.split("#");
	        	  strs.add(str);
	          }
	          
	          
	          String tagName = element.getNodeName();
			  System.out.println("�ѽ�����ǩ��" + tagName); 
	          
	      }  

	     for(int i = 0; i < children.getLength(); i++)  
	     {  
	         Node node = children.item(i);
		   
	         //��ý�������  
	         short nodeType = node.getNodeType();  
	           
	         if(nodeType == Node.ELEMENT_NODE)  
	         {  
	             //��Ԫ�أ������ݹ�  
	             strs=parseAcxAtomByXYZ((Element)node,strs);  
	         }  
	         else if(nodeType == Node.TEXT_NODE)  
	         {  
	             //�ݹ����  
//	             System.out.print(node.getNodeValue()); 
	         }  
	         else if(nodeType == Node.COMMENT_NODE)  
	         {  
	             System.out.print("<!--"); 
	             
	             Comment comment = (Comment)node;  
	                  
	             //ע������  
	             String data = comment.getData();  
	               
	             System.out.print(data);                   
	             System.out.print("-->");  
	            }  
	        }  
	        	     
	     return strs;
	}
	
	public  void parseAcxAtomByXYZ(String inPath,String outPath) throws ParserConfigurationException, SAXException, IOException{
		  // step 1: ���dom���������������������������ڴ�������Ľ�������  
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();  
          
          
        // step 2:��þ����dom������  
        DocumentBuilder db = dbf.newDocumentBuilder();  
           
          
        // step3: ����һ��xml�ĵ������Document���󣨸���㣩  
        Document doc = db.parse(new File(inPath));
        
        
        Element root = doc.getDocumentElement();  
        
        ArrayList<String[]> alist=new ArrayList<String[]>();
        acxReader acx=new acxReader();
        alist=acx.parseAcxAtomByXYZ(root,alist); 
        

        hsdWriter writer=new hsdWriter();
        writer.Write(alist,outPath);
	}
	
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		
//        String inPath="C:/Users/FAN/Desktop/��������/����ת��/����ת��/ԭʼ����/SWNT3.acx";
		String inPath="C:/Users/FAN/Desktop/��������/����ת��/����ת��/ԭʼ����/model6/";
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
//        jf.setDialogTitle("��ѡ��Ҫ�������ļ�");
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
