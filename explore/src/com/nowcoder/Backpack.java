package com.nowcoder;

public class Backpack {
    public int maxValue(int[] w, int[] v, int n, int cap) {
    	int[][] dp = new int[cap+1][n+1];
    	for(int i = 0; i < dp.length;i++){
    		dp[i][0] = 0;
    	}
    	for(int i = 0; i < dp[0].length;i++){
    		dp[0][i] = 0;
    	}
    	
    	for(int i = 1; i < dp.length;i++){
    		for(int j = 1; j < dp[0].length;j++){
    			if(w[j-1]<=i){
    				dp[i][j] = Math.max(dp[i][j-1], dp[i-w[j-1]][j-1]+v[j-1]);
    			}
    			else{
    				dp[i][j] = dp[i][j-1];
    			}
    		}
    	}
    	return dp[cap][n];
    }
    
    public static void main(String[] args){
    	Backpack backPack = new Backpack();
    	int[] w = {1,2,3};
    	int[] v = {1,2,3};
    	int n = 3;
    	int cap = 6;
    	System.out.println(backPack.maxValue(w, v, n, cap));
    }
}