package com.nowcoder.dp;

public class LongestIncreasingSubsequence {
    public int getLIS(int[] nums, int n) {
    	if(nums==null||nums.length==0){
    		return 0;
    	}
    	else{
    		int[] dp = new int[nums.length];
    		dp[0] = 1;
    		int max = 1;
    		for(int i = 1; i < nums.length;i++){
    			int curMax = 0;
    			for(int j = i-1;j>=0;j--){
    				if(nums[i]>nums[j]){
    					curMax = Math.max(dp[j], curMax);
    				}
    			}
    			dp[i] = curMax + 1;
    			max = Math.max(max, dp[i]);
    		}
    		return max;
    	}
    }
    
    public static void main(String[] args){
    	LongestIncreasingSubsequence lis = new LongestIncreasingSubsequence();
    	int[] nums = {1,4,2,5,3};
    	System.out.println(lis.getLIS(nums, 5));
    }
}