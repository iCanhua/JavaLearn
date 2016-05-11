package com.scut.fan.Practices;
/**
 * 01背包问题，具体算法请参考有关书籍
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
	 * @param val 各个物品的价值
	 * @param wt 各个物品对应的重量，与val对应
	 * @param w 背包重量
	 * @return 该背包最大价值
	 */
	public static int knapsack(int[] val,int[] wt,int W){
		int N=val.length+1;
		//动态规划数组,+1原因为设置一行0，重量为0，所选物品为0
		int[][] V=new int[N][W+1];
		//当一个物品都不选时，无论什么背包，价值都为0
		for(int i=0;i<W+1;i++){
			V[0][i]=0;
		}
		//同理，背包承重为0时
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
