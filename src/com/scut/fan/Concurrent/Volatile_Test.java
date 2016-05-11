package com.scut.fan.Concurrent;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;


/**
 * ��java�̲߳��������У���һ���ؼ���volatile��ʹ��Ŀǰ���ںܴ�Ļ�������Ϊʹ������ؼ��֣��ڽ��ж��̲߳��������ʱ��Ϳ������´󼪡�
 * Java������֧�ֶ��̵߳ģ�Ϊ�˽���̲߳��������⣬�������ڲ������� ͬ���� �� volatile �ؼ��ֻ��ơ�
 * 
 * @Synchronized 
 * ͬ�����Ҷ��Ƚ���Ϥ��ͨ�� synchronized �ؼ�����ʵ�֣����м���synchronized �� ����䣬�ڶ��̷߳��ʵ�ʱ��ͬһʱ��ֻ����һ���߳��ܹ���
 * synchronized ���εķ��� ���� ����顣
 * @Volatile
 * ��volatile���εı������߳���ÿ��ʹ�ñ�����ʱ�򣬶����ȡ�����޸ĺ�����ֵ��volatile�����ױ����ã���������ԭ���Բ�����
 * ����Ϊ�����࣬չʾ��һ�����ӣ�����ʵ��һ����������ÿ���߳�������ʱ�򣬻���ü�����inc�������Լ��������м�һ���ᷢ���̲߳��ǰ�ȫ��
 * 
 * @author FAN
 * ���������֤��Volitale�̲߳���ȫ
 */
public class Volatile_Test {
	
	public static int count=0; //δ����ͬ����count
	public static volatile int count_vol=0;  //�ӹؼ���cvolatile��count
	public static CyclicBarrier barrier=new CyclicBarrier(1001);  //��դ���ؿ�������ʹ��1000���߳��������Ŵ�ӡconut��ֵ����ֵΪ1001����Ϊ
	
	
	public static CyclicBarrier getBarrier() {
		return barrier;
	}

	public static void setBarrier(CyclicBarrier barrier) {
		Volatile_Test.barrier = barrier;
	}

	//�����ּ�����,����������η�synchronized����ô��ͬ���ˣ�
	public static void intcount(){
		try {
			Thread.sleep(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		count++;
	}
	
	//�����Լ�����,�������Ϊ����volatile��
	public static  void intcount_vol(){
		try {
			Thread.sleep(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		count_vol++;
	}
	/**
	 * �÷���Ϊ���Է�����ѭ������1000���̣߳�Ȼ��ÿ���̵߳ȴ�դ������λ��һ����������.
	 * @param args
	 */
	public static void main(String[] args) {
		
		CyclicBarrier barrier; //�����������������߳����������̲߳�����
		
		//ͬʱ����1000���̣߳�ȥ����i++���㣬����ʵ�ʽ��
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
					//����֤��barrier���ã�
					/*System.out.println("�����߳����ꡣ���ڸ�ֵΪ��"+Volatile_Test.count);*/
				}
			}).start();
		}
		
		//�����������̼߳���barrier��
		try {
			Volatile_Test.getBarrier().await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BrokenBarrierException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		//����ÿ�����е�ֵ���п��ܲ�ͬ,����Ϊ1000
		System.out.println("���߳���countδ��volatile������Ϊ��"+count);
		System.out.println("���߳���count����volatile������Ϊ��"+count_vol);
		
	}
	
	
	
}

/**
 * ԭ���� java ������������һ���У�������jvm����ʱ���ڴ�ķ��䡣������һ���ڴ�������jvm�����ջ��ÿһ���߳�����ʱ����һ���߳�ջ��
 * �߳�ջ�������߳�����ʱ�����ֵ��Ϣ�����̷߳���ĳһ������ʱ��ֵ��ʱ������ͨ������������ҵ���Ӧ�ڶ��ڴ�ı�����ֵ��Ȼ��Ѷ��ڴ�
 * �����ľ���ֵload���̱߳����ڴ��У�����һ������������֮���߳̾Ͳ��ٺͶ����ڶ��ڴ����ֵ���κι�ϵ������ֱ���޸ĸ���������ֵ��
 * ���޸���֮���ĳһ��ʱ�̣��߳��˳�֮ǰ�����Զ����̱߳���������ֵ��д�������ڶ��б����������ڶ��еĶ����ֵ�Ͳ����仯�ˡ�
 * ��volatile���εı�����jvm�����ֻ�Ǳ�֤�����ڴ���ص��̹߳����ڴ��ֵ�����µ�
 * ��������߳�1���߳�2 �ڽ���read,load �����У��������ڴ���count��ֵ����5����ô�������������µ�ֵ
 * ���߳�1��count�����޸�֮�󣬻�write�����ڴ��У����ڴ��е�count�����ͻ��Ϊ6
 * �߳�2�����Ѿ�����read,load�������ڽ�������֮��Ҳ��������ڴ�count�ı���ֵΪ6
 * ���������̼߳�ʱ��volatile�ؼ����޸�֮�󣬻��ǻ���ڲ����������
 * 
 */


