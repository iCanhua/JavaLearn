package com.scut.fan.Concurrent;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;


/**
 * 在java线程并发处理中，有一个关键字volatile的使用目前存在很大的混淆，以为使用这个关键字，在进行多线程并发处理的时候就可以万事大吉。
 * Java语言是支持多线程的，为了解决线程并发的问题，在语言内部引入了 同步块 和 volatile 关键字机制。
 * 
 * @Synchronized 
 * 同步块大家都比较熟悉，通过 synchronized 关键字来实现，所有加上synchronized 和 块语句，在多线程访问的时候，同一时刻只能有一个线程能够用
 * synchronized 修饰的方法 或者 代码块。
 * @Volatile
 * 用volatile修饰的变量，线程在每次使用变量的时候，都会读取变量修改后的最的值。volatile很容易被误用，用来进行原子性操作。
 * 本类为测试类，展示下一个例子，我们实现一个计数器，每次线程启动的时候，会调用计数器inc方法，对计数器进行加一，会发现线程并非安全的
 * 
 * @author FAN
 * 本测试类仅证明Volitale线程不安全
 */
public class Volatile_Test {
	
	public static int count=0; //未加弱同步的count
	public static volatile int count_vol=0;  //加关键字cvolatile的count
	public static CyclicBarrier barrier=new CyclicBarrier(1001);  //用栅栏关卡计数，使得1000个线程运行完后才打印conut的值，赋值为1001是因为
	
	
	public static CyclicBarrier getBarrier() {
		return barrier;
	}

	public static void setBarrier(CyclicBarrier barrier) {
		Volatile_Test.barrier = barrier;
	}

	//进行字加运算,如果加上修饰符synchronized，那么就同步了！
	public static void intcount(){
		try {
			Thread.sleep(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		count++;
	}
	
	//进行自加运算,运算变量为加了volatile的
	public static  void intcount_vol(){
		try {
			Thread.sleep(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		count_vol++;
	}
	/**
	 * 该方法为测试方法，循环创建1000个线程，然后每个线程等待栅栏，到位后一次性输出结果.
	 * @param args
	 */
	public static void main(String[] args) {
		
		CyclicBarrier barrier; //计数器，用作所有线程运行完主线程才运行
		
		//同时启动1000个线程，去进行i++计算，看看实际结果
		for(int i=0;i<1000;i++){
			new Thread(new Runnable(){
				@Override
				public void run() {
					
					Volatile_Test.intcount();
					Volatile_Test.intcount_vol();
					
					try {
						Volatile_Test.getBarrier().await();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (BrokenBarrierException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					//用于证明barrier有用！
					/*System.out.println("所有线程跑完。现在该值为："+Volatile_Test.count);*/
				}
			}).start();
		}
		
		//以下语句把主线程加入barrier内
		try {
			Volatile_Test.getBarrier().await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BrokenBarrierException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		//这里每次运行的值都有可能不同,可能为1000
		System.out.println("多线程下count未加volatile运算结果为："+count);
		System.out.println("多线程下count加了volatile运算结果为："+count_vol);
		
	}
	
	
	
}

/**
 * 原因：在 java 垃圾回收整理一文中，描述了jvm运行时刻内存的分配。其中有一个内存区域是jvm虚拟机栈，每一个线程运行时都有一个线程栈，
 * 线程栈保存了线程运行时候变量值信息。当线程访问某一个对象时候值的时候，首先通过对象的引用找到对应在堆内存的变量的值，然后把堆内存
 * 变量的具体值load到线程本地内存中，建立一个变量副本，之后线程就不再和对象在堆内存变量值有任何关系，而是直接修改副本变量的值，
 * 在修改完之后的某一个时刻（线程退出之前），自动把线程变量副本的值回写到对象在堆中变量。这样在堆中的对象的值就产生变化了。
 * 于volatile修饰的变量，jvm虚拟机只是保证从主内存加载到线程工作内存的值是最新的
 * 例如假如线程1，线程2 在进行read,load 操作中，发现主内存中count的值都是5，那么都会加载这个最新的值
 * 在线程1堆count进行修改之后，会write到主内存中，主内存中的count变量就会变为6
 * 线程2由于已经进行read,load操作，在进行运算之后，也会更新主内存count的变量值为6
 * 导致两个线程及时用volatile关键字修改之后，还是会存在并发的情况。
 * 
 */


