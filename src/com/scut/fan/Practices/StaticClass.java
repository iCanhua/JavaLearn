package com.scut.fan.Practices;


/* ���������ʾ�����java�д�����̬�ڲ���ͷǾ�̬�ڲ��� */
class OuterClass{
   private static String msg = "GeeksForGeeks";

   // ��̬�ڲ���
   public static class NestedStaticClass{

       // ��̬�ڲ���ֻ�ܷ����ⲿ��ľ�̬��Ա
       public void printMessage() {

         // ���Ž�msg�ĳɷǾ�̬�ģ��⽫���±������ 
         System.out.println("Message from nested static class: " + msg); 
       }
    }

    // �Ǿ�̬�ڲ���
    public class InnerClass{

       // �����Ǿ�̬�������ǷǾ�̬�����������ڷǾ�̬�ڲ����з���
       public void display(){
          System.out.println("Message from non-static nested class: "+ msg);
       }
    }
} 

public class StaticClass
{
    // ��ô������̬�ڲ���ͷǾ�̬�ڲ����ʵ��
    public static void main(String args[]){

       // ������̬�ڲ����ʵ��
       OuterClass.NestedStaticClass printer = new OuterClass.NestedStaticClass();

       // ������̬�ڲ���ķǾ�̬����
       printer.printMessage();   

       // Ϊ�˴����Ǿ�̬�ڲ��࣬������Ҫ�ⲿ���ʵ��
       OuterClass outer = new OuterClass();        
       OuterClass.InnerClass inner  = outer.new InnerClass();

       // ���÷Ǿ�̬�ڲ���ķǾ�̬����
       inner.display();

       // ����Ҳ���Խ�����ϲ��裬һ���������ڲ���ʵ��
       OuterClass.InnerClass innerObject = new OuterClass().new InnerClass();

       // ͬ���������ڿ��Ե����ڲ��෽��
       innerObject.display();
    }
}