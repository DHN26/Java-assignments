package io.dataStructures;


public class QueueImpl {
	private Node front;
	private Node rear;

	public static void main(String[] args) {
		QueueImpl queue=new QueueImpl();
		
		int arr[]= {1,2,3,4,5};
		Node front=null;
		for(int i=0;i<arr.length;i++)
		{
			front=queue.enqueue(arr[i]);
		}
		
		print(front);
		
		int temp;
		for(int i=0;i<6;i++)
		{
			temp=queue.dequeue();
			System.out.println("Dequeued data : "+temp);
		}
	}
	
	public Node enqueue(int data)
	{
		if(front==null)
		{
			rear=new Node(data, null);
			front=rear;
		}
		else {
			rear.next=new Node(data, null);
			rear=rear.next;
		}
		return front;
	}
	
	public int dequeue()
	{
		if(front==null)
			return -1;
		else {
			Node temp=front;
			front=front.next;
			return temp.val;
		}
	}
	
	public static void print(Node front)
	{
		while(front!=null)
		{
			System.out.print(front.val+" ");
			front=front.next;
		}
		System.out.println();
	}

}
