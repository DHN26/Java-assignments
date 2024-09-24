//Q3: Write a program to rotate an array of n elements to the right by k steps.

package io.dataStructures;

public class Q3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[]= {1,2,3};
		int k=1;
		while(k>0)
		{
			arr=rotateRightByK(arr);
			k--;
		}
		for(int i=0;i<arr.length;i++)
		{
			System.out.print(arr[i]+" ");
			
		}
	}
	
	public static int[] rotateRightByK(int arr[])
	{
		int temp = arr[arr.length - 1];
	    for (int i = arr.length - 1; i > 0; i--) {
	        arr[i] = arr[i - 1];
	    }

	    arr[0] = temp;
		return arr;
	}

}
