package com.scut.fan.Practices;

/**
 * ��һ����ά�����У�ÿһ�ж����մ����ҵ�����˳������ÿһ�ж����մ��ϵ��µ�����˳�����������һ������������������һ����ά�����һ���������ж��������Ƿ��и������� 
 *��������:
	array�� �����ҵĶ�ά����
	target�����ҵ�����
 * @author FAN
 *
 */

public class Two_Dimension_Search {
	//����˼·���þ�������Ͻ�Ԫ�غ͵�ǰԪ�رȽϣ��������һ��һ���޳�
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
