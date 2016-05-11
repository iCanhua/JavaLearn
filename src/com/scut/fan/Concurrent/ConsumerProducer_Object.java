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
							System.out.println("我是消费者"+current.getName()+"：队列空，等待数据");
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
					
					System.out.println("消费者："+current.getName()+"从队列取走一个元素，队列剩余"+queue.size()+"个元素");
					System.out.println("消费者："+current.getName()+"共消费了"+consumeNum+"个元素");
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
	                            System.out.println("我是生产者，队列满，等待有空余空间");
	                            queue.wait();
	                        } catch (InterruptedException e) {
	                            e.printStackTrace();
	                            queue.notify();
	                        }
	                    }
	                    queue.offer(1);        //每次插入一个元素
	                    produce++;
	                    queue.notify();
	                    System.out.println("向队列取中插入一个元素，队列剩余空间："+(queueSize-queue.size()));
	                    System.out.println("共生产了元素（个）："+produce);
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
