package com.nowcoder.dp;

public class LCS {
    public int findLCS(String str1, int n, String str2, int m) {
    	char[] chs1 = str1.toCharArray();
    	char[] chs2 = str2.toCharArray();
    	int[][] dp = new int[chs1.length+1][chs2.length+1];
    	for(int i = 0; i < dp.length;i++){
    		dp[i][0] = 0;
    	}
    	for(int i = 0; i < dp[0].length;i++){
    		dp[0][i] = 0;
    	}
    	
    	for(int i = 1; i <= chs1.length;i++){
    		for(int j = 1; j <= chs2.length;j++){
    			int curMax = Math.max(dp[i-1][j], dp[i][j-1]);
    			if(chs1[i-1]==chs2[j-1]){
    				curMax = Math.max(dp[i-1][j-1]+1, curMax);
    			}
    			dp[i][j] = curMax;
    		}
    	}
    	return dp[dp.length-1][dp[0].length-1];
    }
    
    public static void main(String[] args){
    	LCS lcs = new LCS();
    	String str1 = "1A2C3D4B56";
    	String str2 = "B1D23CA45B6A";
    	System.out.println(lcs.findLCS(str1, 10, str2, 12));
    }
}