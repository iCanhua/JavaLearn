package com.scut.fan.Concurrent;
import java.util.Random;
import java.util.concurrent.CyclicBarrier;

/** *//** 
 * CyclicBarrier类似于CountDownLatch也是个计数器， 
 * 不同的是CyclicBarrier数的是调用了CyclicBarrier.await()进入等待的线程数， 
 * 当线程数达到了CyclicBarrier初始时规定的数目时，所有进入等待状态的线程被唤醒并继续。 
 * CyclicBarrier就象它名字的意思一样，可看成是个障碍， 
 * 所有的线程必须到齐后才能一起通过这个障碍。 
 * CyclicBarrier初始时还可带一个Runnable的参数， 
 * 此Runnable任务在CyclicBarrier的数目达到后，所有其它线程被唤醒前被执行。 
 */  

public class CyclicBarrier_Test {
	
	public static class ComponentThread implements Runnable {  
        CyclicBarrier barrier;// 计数器  
        int ID;    // 组件标识  
        int[] array;    // 数据数组  
  
        // 构造方法  
        public ComponentThread(CyclicBarrier barrier, int[] array, int ID) {  
            this.barrier = barrier;  
            this.ID = ID;  
            this.array = array;  
        }  
  
        public void run() {  
            try {  
                array[ID] = new Random().nextInt(100);  
                System.out.println("Component " + ID + " generates: " + array[ID]);  
                // 在这里等待Barrier处  
                System.out.println("Component " + ID + " sleep");  
                barrier.await();  
                System.out.println("Component " + ID + " awaked");  
                // 计算数据数组中的当前值和后续值  
                int result = array[ID] + array[ID + 1];  
                System.out.println("Component " + ID + " result: " + result);  
            } catch (Exception ex) {  
            }  
        }  
    }  
    /** *//** 
     * 测试CyclicBarrier的用法 
     */  
    public static void testCyclicBarrier() {  
        final int[] array = new int[3];  
        CyclicBarrier barrier = new CyclicBarrier(2, new Runnable() {  
            // 在所有线程都到达Barrier时执行  
            public void run() {  
                System.out.println("testCyclicBarrier run");  
                array[2] = array[0] + array[1];  
            }  
        });  
  
        // 启动线程  
        new Thread(new ComponentThread(barrier, array, 0)).start();  
        new Thread(new ComponentThread(barrier, array, 1)).start();  
    }  
  
    public static void main(String[] args) {  
    	CyclicBarrier_Test.testCyclicBarrier();  
    }  
}

/**
 说明：在main中执行testCyclicBarrier方法 
执行到CyclicBarrier barrier = new CyclicBarrier(2, new Runnable()...)时 
Runnable的参数是在CyclicBarrier的数目达到2时并且所有被CyclicBarrier.await()进入等待的线程被唤醒前执行。 
所以继续执行下面的两个线程 
new Thread(new ComponentThread(barrier, array, 0)).start(); 
new Thread(new ComponentThread(barrier, array, 1)).start(); 
执行public void run()方法，分别执行，互不影响 
执行到barrier.await();时该线程进入等待状态，当两个线程都执行完barrier.await();时，进入到new CyclicBarrier(2, new Runnable()...)里面的方法， 执行完里面的方法后，等待的两个线程再次被唤醒，继续各自执行线程后面的语句。 
 */
