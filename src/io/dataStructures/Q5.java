//Q5: Write a program to Reverse a singly linked list.

package io.dataStructures;

import java.util.Arrays;
import java.util.List;

public class Q5 {

	public static void main(String[] args) {
		List<Integer> list=Arrays.asList(1,2,3,4,5);
		Node head=null;
		for(int i=0;i<list.size();i++)
		{
			head=add(list.get(i), head);
		}
		System.out.println("Before reverse : ");
		print(head);
		head=reverse(list, head);
		System.out.println("After reverse : ");
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
		System.out.println();
	}
	
	public static Node reverse(List<Integer> list, Node head)
	{
		 Node prev = null;
	        Node current = head;
	        Node next = null;
	        while (current != null) {
	            next = current.next; // Store the next node
	            current.next = prev; // Reverse the link
	            prev = current;      // Move prev and current one step forward
	            current = next;
	        }
	       return prev;
	}
	
	

}
