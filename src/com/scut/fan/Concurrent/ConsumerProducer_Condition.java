package com.scut.fan.Concurrent;

import java.util.PriorityQueue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Condition;

import com.scut.fan.Concurrent.ConsumerProducer_Object.Consumer;


public class ConsumerProducer_Condition {
	
	private int queueSize = 10;
	private PriorityQueue<Integer> queue = new PriorityQueue<Integer>(queueSize);
	private Lock lock= new ReentrantLock();
	private Condition notFull = lock.newCondition();
	private Condition notEmpty = lock.newCondition();
	
	public static void main(String[] args) {
		ConsumerProducer_Condition test=new ConsumerProducer_Condition();
		Producer producer1=test.new Producer();
		Producer producer2=test.new Producer();
		Consumer consumer1=test.new Consumer();
		Consumer consumer2=test.new Consumer();
		Consumer consumer3=test.new Consumer();
		
		producer1.start();
		producer2.start();
		consumer1.start();
		consumer2.start();
		consumer3.start();
		
	}
	
	class Consumer extends Thread{
		int consumeNum=0;
		@Override
		public void run() {
			consume();
		}
		
		private void consume(){
			Thread current =Thread.currentThread();
			while(true){
				lock.lock();
				try {
					while(queue.size()==0){
						try {
							System.out.println("队列空，等待数据");
							notEmpty.await();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					queue.poll();        //每次移走队首元素
					consumeNum++;
					notFull.signal();
					System.out.println("消费者："+current.getName()+"从队列取走一个元素，队列剩余"+queue.size()+"个元素");
					System.out.println("消费者："+current.getName()+"共消费了（个）："+consumeNum);
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} finally{
					lock.unlock();
				}
			}
		}
	}
	
	class Producer extends Thread{
		int produceNum=0;
		@Override
		public void run() {
			produce();
		}
		
		private void produce(){
			Thread current =Thread.currentThread();
			while(true){
				lock.lock();
				try {
					while(queue.size()==queueSize){
						try {
							System.out.println("队列满，等待有空余空间");
							notFull.await();
						} catch (Exception e) {
							 e.printStackTrace();
						}
					}
					queue.offer(1);               //每次插入一个元素
					produceNum++;
					notEmpty.signal();
					System.out.println("生产者"+current.getName()+"向队列取中插入一个元素，队列剩余空间："+(queueSize-queue.size()));
					System.out.println("生产者"+current.getName()+"共生产了（个）："+produceNum);
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} finally{
					lock.unlock();
				}
			}
		}
	}

}
