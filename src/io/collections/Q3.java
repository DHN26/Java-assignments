//Q3: Implement your own ArrayList  using plain array? supported Add(), indexof(),
//contains() also implement Addall() method in your own ArrayList ? Write a method  
//to support add(int index, int value) ? 

package io.collections;

public class Q3 {
	int arr[];
	int i=0;
	
	
	public Q3(int i) {
		arr=new int[i];
		this.i=i;
	}
	
	
	
	public void add(int val)
	{
		if(i==arr.length)
			increaseCapacity();
		arr[i++]=val;
	}
	
	private void increaseCapacity() {
		int newArr[]=new int[arr.length*2];
		for(int i=0;i<arr.length;i++)
		{
			newArr[i]=arr[i];
		}
		arr=newArr;
		
	}



	public int get(int index)
	{
		return arr[index];
	}



	public static void main(String[] args) {
		Q3 arrayList=new Q3(4);
		arrayList.add(2);
		arrayList.add(1);
		System.out.println(arrayList.get(0));
	}

}
