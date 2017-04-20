package com.nowcoder;

import java.util.*;

public class LeftMostAppearance {
    public int findPos(int[] arr, int n, int num) {
    	return binarySearch(arr,0,arr.length-1,num);
    }

	private int binarySearch(int[] arr, int left, int right,int target) {
		if(left>right){
			return -1;
		}
		else{
			int mid = (left + right) / 2;
			if(arr[mid]==target){
				if(mid==0||arr[mid-1]!=target){
					return mid;
				}
				else{
					return binarySearch(arr,left,mid-1,target);
				}
			}
			else{
				if(arr[mid]>target){
					return binarySearch(arr,left,mid-1,target);
				}
				else{
					return binarySearch(arr,mid+1,right,target);
				}
			}
		}
	}
	
	public static void main(String[] args){
		LeftMostAppearance lma = new LeftMostAppearance();
		int[] nums = {1,2,3,3,4};
		System.out.println(lma.findPos(nums, 5, 3));
	}
}