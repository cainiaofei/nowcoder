package com.nowcoder;

public class MinCost {
    public int findMinCost(String str1, int n, String str2, int m, int c0, int c1, int c2) {
    	char[] chs1 = str1.toCharArray();
    	char[] target = str2.toCharArray();
    	int[][] dp = new int[n+1][m+1];
    	dp[0][0] = 0;
    	int cur = 1;
    	for(int i = 1; i < dp[0].length;i++){
    		dp[0][i] = c0 * cur;
    		cur++;
    	}
    	cur = 1;
    	for(int i = 1; i < dp.length;i++){
    		dp[i][0] = c1 * cur;
    		cur++;
    	}
    	
    	for(int i = 1; i < dp.length;i++){
    		for(int j = 1; j < dp[0].length;j++){
    			int add = dp[i][j-1] + c0;
    			int del = dp[i-1][j] + c1;
    			int modify = dp[i-1][j-1];
    			if(chs1[i-1]!=target[j-1]){
    				modify = modify + c2;
    			}
    			dp[i][j] = Math.min(add, Math.min(del, modify));
    		}
    	}
    	return dp[n][m];
    }
    
    public static void main(String[] args){
    	MinCost minCost = new MinCost();
    	String str1 = "abcccbcb";
    	int n = 8;
    	String str2 = "bbb";
    	int m = 3;
    	int add = 7;
    	int del = 4;
    	int modify = 2;
    	System.out.println(minCost.findMinCost(str1, n, str2, m, add, del, modify));
    }
}