package com.scut.fan.Practices;
/**
 * ��ʵ��һ����������һ���ַ����еĿո��滻�ɡ�%20�������磬���ַ���ΪWe Are Happy.�򾭹��滻֮����ַ���ΪWe%20Are%20Happy��
 * @author FAN
 *
 */
public class Replace_Space_InString {
	
	public static String replaceSpace(StringBuffer str) {
		
       String stg=str.toString();
       char[] chararray=stg.toCharArray();
       //ע��Stringbuffer��StringBulider������Ŷ��bufferҪ���̰߳�ȫ��
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
