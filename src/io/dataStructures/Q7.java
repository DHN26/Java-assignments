//Q7: Write a program to find the maximum path sum from given a binary tree.

package io.dataStructures;

public class Q7 {

	public static void main(String[] args) {
		BinaryTeeClass btc=new BinaryTeeClass();
		btc.root=new Node2(1);
		btc.root.left=new Node2(2);
		btc.root.right=new Node2(3);
		btc.root.left.left=new Node2(4);
		btc.root.left.right=new Node2(5);
		
		System.out.println(btc.maxDepth(btc.root));
	}

}

class BinaryTeeClass{
	Node2 root;
	int maxDepth(Node2 node)
	{
		if(node==null)
			return 0;
		else {
			int leftDepth=maxDepth(node.left);
			int rightDepth=maxDepth(node.right);
			
			if(leftDepth>=rightDepth)
				return leftDepth+1;
			else if(rightDepth>leftDepth)
				return rightDepth+1;
		}
		return 1;
		
	}
	
}

class Node2{
	int data;
	Node2 left, right;
	public Node2(int data)
	{
		this.data=data;
		this.left=this.right=null;
	}
}
