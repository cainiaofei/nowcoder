package com.nowcoder;

public class Find {
    public int findPos(int[] arr, int n) {
    	return binarySearch(arr,0,n-1);
    }
    
    public int binarySearch(int[] arr,int left,int right){
    	if(left>right){
    		return -1;
    	}
    	else{
    		int mid = (left + right) / 2;
    		if(arr[mid]==mid){
    			int cur = binarySearch(arr,left,mid-1);
    			if(cur==-1){
    				return mid;
    			}
    			else{
    				return cur;
    			}
    		}
    		else{
    			if(arr[mid]>mid){
    				return binarySearch(arr,left,mid-1);
    			}
    			else{
    				return binarySearch(arr,mid+1,right);
    			}
    		}
    	}
    }
    
    public static void main(String[] args){
    	Find find = new Find();
    	int[] nums = {0,1,2,3};
    	System.out.println(find.findPos(nums, 4));
    }
}