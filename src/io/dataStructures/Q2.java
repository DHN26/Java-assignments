//Q3: Write your own Linked List? Add and Remove method mainly?

package io.dataStructures;

import java.util.Arrays;
import java.util.List;

public class Q2 {

	public static void main(String []args)
	{
		List<Integer> list=Arrays.asList(1,2,3,4,5);
		Node head=null;
		for(int i=0;i<list.size();i++)
		{
			head=add(list.get(i), head);
		}
		
		System.out.println("Printing LL : ");
		print(head);
		System.out.println();
		
		head=removeElement(head, 5);
		System.out.println("After removal of element 5 : ");
		print(head);
		
	}
	
	public static Node add(int val, Node head)
	{
		if(head==null)
		{
			head=new Node(val, null);
		}
		else {
			Node temp=head;
			while(temp.next!=null)
			{
				temp=temp.next;
			}
			temp.next=new Node(val, null);			
		}
		return head;
	}
	
	public static void print(Node head)
	{
		while(head!=null)
		{
			System.out.print(head.val+" ");
			head=head.next;
		}
	}
	
	public static Node removeElement(Node head, int element)
	{
		Node temp=head;
		Node temp2=null;
		
		while(temp.val!=element)
		{
			temp2=temp;
			temp=temp.next;
		}
		temp2.next=temp.next;
		return head;
	}
}
