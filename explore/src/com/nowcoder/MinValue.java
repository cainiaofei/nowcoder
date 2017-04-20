package com.nowcoder;

public class MinValue {
    public int getMin(int[] arr, int n) {
        return binarySearch(arr,0,n-1);
    }

	private int binarySearch(int[] arr, int left, int right) {
		if(left+1==right){
			return Math.min(arr[right],arr[left]);
		}
		else{
			int mid = (left + right) / 2;
			if(arr[mid]<=arr[arr.length-1]){
				return binarySearch(arr,left,mid);
			}
			else{
				return binarySearch(arr,mid,right);
			}
		}
	}
	
	public static void main(String[] args){
		MinValue mv = new MinValue();
		int[] nums = {66,240,326,330,577,618};
		System.out.println(mv.getMin(nums, 6));
	}
}