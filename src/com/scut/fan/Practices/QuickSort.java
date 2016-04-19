package com.scut.fan.Practices;
/**
 * 快速排序，相关原理见算法详解
 * @author FAN
 *
 */
public class QuickSort {
	

	@SuppressWarnings("null")
	public static void quicksort(int[] array,int start,int end){
		if(array==null&&0==array.length){
			return;
		}
		
		if(start<end){
			int index=partition(array,start,end);
			quicksort(array, start, index-1);
			quicksort(array, index+1, end);
		}

	}
	
	public static int partition(int[] array,int start,int end){
		int index=start-1;
		if(start<end){
			for(int i=start;i<end;i++){
				if(array[i]<=array[end]){
					int temp=array[++index];
					array[index]=array[i];
					array[i]=temp;
				}
			}
			int temp=array[++index];
			array[index]=array[end];
			array[end]=temp;
			return index;
		}
		return -1;
	}
	
	public static void main(String[] args) {
		int[] array=new int[1000];
		for(int i=0;i<1000;i++){
			array[i]=1000-i;
		}
		for(int a:array){
			System.out.println(a);
		}
		quicksort(array, 0, array.length-1);
		for(int a:array){
			System.out.println(a);
		}
		System.out.println("长度："+array.length);
	}

}
