//Q2: Write a program for binary search.

package io.dataStructures;


public class Q1 {

	public static void main(String[] args) {
		int arr[]= {1,2,3,4,5};
		System.out.println("Element found at index : "+binarySearch(arr, 3));

	}
	
	public static int binarySearch(int arr[], int target)
	{
		
		int left=0;
		int right=arr.length-1;
		while(right>=left)
		{
			int mid=(left+right)/2;
			if(arr[mid]==target)
				return mid;
			else if(arr[mid]>target)
				right=mid-1;
			else
				left=mid+1;
			
		}
		return -1;
	}

}
