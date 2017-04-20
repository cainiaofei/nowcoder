package com.nowcoder.dp;


public class GoUpstairs {
    public int countWays(int n) {
    	int[] dp = new int[n+1];
    	if(n<1){
    		return 0;
    	}
    	else if(n==1){
    		return 1;
    	}
    	else if(n==2){
    		return 2;
    	}
    	else{
            dp[1] = 1;
            dp[2] = 2;
    		for(int i = 3;i<=n;i++){
    			dp[i] = (dp[i-1] + dp[i-2])%1000000007;
    		}
    		return dp[n];
    	}
    }
    
    public static void main(String[] args){
    	GoUpstairs go = new GoUpstairs();
    	System.out.println(go.countWays(36196));
    }
}