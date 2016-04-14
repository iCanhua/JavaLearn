package com.scut.fan.Practices;

/**
 * 在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。 
 *输入描述:
	array： 待查找的二维数组
	target：查找的数字
 * @author FAN
 *
 */

public class Two_Dimension_Search {
	//解题思路，用矩阵的右上角元素和当前元素比较，根据情况一行一列剔除
    public static boolean Find(int [][] array,int target) {
        if(array==null){
            return false;
        }
        int rows=array.length-1;
        int cols=array[0].length-1;
        boolean solider=false;
        int row=0;
        while(!solider&&row<=rows&&cols>=0){
            if(array[row][cols]==target){
                solider=true;
                System.out.println(array[row][cols]);
            }else if(array[row][cols]>target){
                cols--;
            }else{
                row++;
            }
        }
           
        return solider;

    }
    
    public static void main(String[] args) {
		int[][] testcase=new int[4][3];
		for(int i=0;i<testcase.length;i++){
			for(int j=0;j<testcase[0].length;j++){
				testcase[i][j]=i*j;
			}
		}
		Find(testcase, 6);
	}
	

}
