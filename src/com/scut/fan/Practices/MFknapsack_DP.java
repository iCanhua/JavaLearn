package com.scut.fan.Practices;
/**
 * 01�������⣬�����㷨��ο��й��鼮
 * @author FAN
 *
 */
public class MFknapsack_DP {
   public static void main(String[] args) throws Exception {
        int val[] = {10, 40, 30, 50};
        int wt[] = {5, 4, 6, 3};
        int W = 13;
 
        System.out.println(knapsack(val, wt, W));
    }
	/**
	 * @param val ������Ʒ�ļ�ֵ
	 * @param wt ������Ʒ��Ӧ����������val��Ӧ
	 * @param w ��������
	 * @return �ñ�������ֵ
	 */
	public static int knapsack(int[] val,int[] wt,int W){
		int N=val.length+1;
		//��̬�滮����,+1ԭ��Ϊ����һ��0������Ϊ0����ѡ��ƷΪ0
		int[][] V=new int[N][W+1];
		//��һ����Ʒ����ѡʱ������ʲô��������ֵ��Ϊ0
		for(int i=0;i<W+1;i++){
			V[0][i]=0;
		}
		//ͬ����������Ϊ0ʱ
		for(int i=0;i<val.length+1;i++){
			V[i][0]=0;
		}
		
		for(int weight=1;weight<=W;weight++){
			for(int item=1;item<=val.length;item++){
				if(weight<wt[item-1]){
					V[item][weight]=V[item-1][weight];
				}else{
					V[item][weight]=Math.max(V[item-1][weight-wt[item-1]]+val[item-1],V[item-1][weight]);
				}
			}
		}
		//Printing the matrix
        for (int[] rows : V) {
            for (int col : rows) {
                System.out.format("%5d", col);
            }
            System.out.println();
        }
        System.out.println((N+1)+":"+(W+1));
        return V[N-1][W];
	}
}
