package com.scut.fan.Concurrent;

import java.util.PriorityQueue;

public class ConsumerProducer_Object {
	
	private int queueSize=10;
	private PriorityQueue<Integer> queue=new  PriorityQueue<Integer>(queueSize);
	
	public static void main(String[] args) {
		ConsumerProducer_Object test=new ConsumerProducer_Object();
		Producer producer=test.new Producer();
		Consumer consumer=test.new Consumer();
		Consumer consumer1=test.new Consumer();
		Consumer consumer2=test.new Consumer();
		
		producer.start();
		consumer.start();
		consumer1.start();
		consumer2.start();
		
	}
	
	class Consumer extends Thread{
		int consumeNum=0;
		public void run(){
			consume();
		}
		
		private void consume(){
			while(true){
				synchronized(queue){
					Thread current =Thread.currentThread();
					while(queue.size()==0){
						try{
							System.out.println("����������"+current.getName()+"�����пգ��ȴ�����");
							queue.wait();
						}catch(Exception e){
							e.printStackTrace();
							queue.notify();
						}
						  try {
								Thread.sleep(1000);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
					}
					
					queue.poll();         //poll the first element of queue every time
					consumeNum++;
					queue.notifyAll();
					
					System.out.println("�����ߣ�"+current.getName()+"�Ӷ���ȡ��һ��Ԫ�أ�����ʣ��"+queue.size()+"��Ԫ��");
					System.out.println("�����ߣ�"+current.getName()+"��������"+consumeNum+"��Ԫ��");
					  try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
				}
			}
		}
	}
	
	 class Producer extends Thread{
         int produce=0;
	        @Override
	        public void run() {
	            produce();
	        }
	          
	        private void produce() {
	            while(true){
	                synchronized (queue) {
	                    while(queue.size() == queueSize){
	                        try {
	                            System.out.println("���������ߣ����������ȴ��п���ռ�");
	                            queue.wait();
	                        } catch (InterruptedException e) {
	                            e.printStackTrace();
	                            queue.notify();
	                        }
	                    }
	                    queue.offer(1);        //ÿ�β���һ��Ԫ��
	                    produce++;
	                    queue.notify();
	                    System.out.println("�����ȡ�в���һ��Ԫ�أ�����ʣ��ռ䣺"+(queueSize-queue.size()));
	                    System.out.println("��������Ԫ�أ�������"+produce);
	                    try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
	                }
	            }
	        }
	    }

}
