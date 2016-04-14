package com.scut.fan.Practices;
/**
 * 请实现一个函数，将一个字符串中的空格替换成“%20”。例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 * @author FAN
 *
 */
public class Replace_Space_InString {
	
	public static String replaceSpace(StringBuffer str) {
		
       String stg=str.toString();
       char[] chararray=stg.toCharArray();
       //注意Stringbuffer和StringBulider的区别哦，buffer要求线程安全的
       StringBuffer stb=new StringBuffer();
       for(int i=0;i<chararray.length;i++){
            if(chararray[i]==' '){
                stb.append("%20");
            }else{
                stb.append(chararray[i]);
            }
        }
       
        return stb.toString();
    	
    }
	
	public static void main(String[] args) {
		StringBuffer str=new StringBuffer("We Are Happy");
		System.out.println(replaceSpace(str));
	}

}
