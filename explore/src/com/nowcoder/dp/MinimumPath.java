package com.nowcoder.dp;

public class MinimumPath {
    public int getMin(int[][] map, int n, int m) {
    	int[][] dp = new int[map.length][map[0].length];
    	int cur = 0;
    	for(int i = 0; i < dp[0].length;i++){
    		cur += map[0][i];
    		dp[0][i] = cur;
    	}
    	cur = 0;
    	for(int i = 0; i < dp.length;i++){
    		cur += map[i][0];
    		dp[i][0] = cur;
    	}
    	for(int i = 1; i < map.length;i++){
    		for(int j = 1; j < map[0].length;j++){
    			dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + map[i][j];
    		}
    	}
    	return dp[map.length-1][map[0].length-1];
    }
    
    public static void main(String[] args){
    	MinimumPath mini = new MinimumPath();
    	int[][] map = {{1,2,3},{1,1,1}};
    	System.out.println(mini.getMin(map, 2, 3));
    }
}