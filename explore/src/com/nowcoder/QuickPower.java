package com.nowcoder;

public class QuickPower {
    public int getPower(int k, int n) {
    	int size = getSize(n);
    	long[] nums = new long[size+1];
    	nums[0] = k;//0 map 1
    	for(int i = 1; i < nums.length;i++){
    		nums[i] = nums[i-1]*nums[i-1];
    		nums[i] %= 1000000007;
    	}
    	
    	long res = 1;
    	int pos = 0;
    	long cur = 1;
    	while(cur<=n){
    		if((cur&n)==cur){
    			res *= nums[pos];
    			res %= 1000000007;
    		}
    		pos++;
    		cur = cur << 1;
    	}
    	return (int)(res%1000000007);
    }

	private int getSize(int n) {
		int cur = 1;
		int res = 0;
		while(cur<n){
			cur = cur << 1;
			res++;
		}
		return res;
	}
	
	public static void main(String[] args){
		QuickPower qp = new QuickPower();
		int k = 2;
		int n = 14876069;
		System.out.println(65536*65535);
		qp.getPower(k, n);
	}
}