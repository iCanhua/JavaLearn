package com.scut.fan.Concurrent;

public class Synchronized_Test {
	public static void main(String[] args) {
		Synchronized_Test test=new Synchronized_Test();
		final  object obj=test.new object();
		Thread t=new Thread(new Runnable(){
			public void run(){
				synchronized (obj){
			for(int i=0;i<10000;i++){
				 {
					obj.count();
				}
			}}
			}
		});
		Thread t2=new Thread(new Runnable(){
			public void run(){
				synchronized (obj) {
					obj.print();
				}
			}
		});
		t.start();
		t2.start();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		obj.print();
	}
	
	
	class object{
		int i=0;
		public int getI() {
			return i;
		}
		public void setI(int i) {
			this.i = i;
		}
		public  void count(){
			i++;
		}
		public void count1(){
			i++;
		}
		public void print(){
			//count();
			System.out.println("我能在多少秒进来呢？"+i);
		}
	}
	
}
