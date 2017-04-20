package com.nowcoder.dp;

public class Exchange {
    public int countWays(int[] penny, int n, int aim) {
    	int[][] dp = new int[aim+1][n+1];
    	for(int i = 0; i < dp[0].length;i++){
    		dp[0][i] = 1;
    	}
    	for(int i = 1; i < dp.length;i++){
    		dp[i][0] = 0;
    	}
    	for(int i = 1; i < dp.length;i++){
    		for(int j = 1; j < dp[0].length;j++){
    			if(penny[j-1]>i){
    				dp[i][j] = dp[i][j-1];
    			}
    			else{
    				dp[i][j] = dp[i][j-1] + dp[i-penny[j-1]][j];
    			}
    		}
    	}
    	return dp[aim][n];
    }
    
    public static void main(String[] args){
    	Exchange ex = new Exchange();
    	int[] nums = {1,2,4};
    	System.out.println(ex.countWays(nums, 3, 3));
    }
}