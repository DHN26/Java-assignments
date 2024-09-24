//Q6:Implements multistack solution for a fixed sized stack beyond which it should 
//create a new stack.

package io.dataStructures;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Q6 {
	
	private final int stackCapacity;
	private List<Stack<Integer>> stacks;
	
	public Q6(int stackCapacity)
	{
		this.stackCapacity=stackCapacity;
		this.stacks=new ArrayList<Stack<Integer>>();
		this.stacks.add(new Stack<>());
	}
	
	public void push(int val)
	{
		Stack<Integer> last=getLastStack();
		if(last.size()>=stackCapacity)
		{
			Stack<Integer> newStack=new Stack<>();
			newStack.push(val);
			stacks.add(newStack);
		}
		else {
			last.push(val);
		}
	}
	
	public int pop() throws Exception
	{
		Stack<Integer> last=getLastStack();
		if(last.isEmpty() && stacks.size()==1)
		{
			throw new Exception("All stacks are empty!");
		}
		int val=last.pop();
		if(last.isEmpty() && stacks.size()>1)
		{
			stacks.remove(stacks.size()-1);
		}
		return val;
	}
	
	public Stack<Integer> getLastStack()
	{
		return stacks.get(stacks.size()-1);
	}

	public static void main(String[] args) throws Exception {
		Q6 multiStack=new Q6(2);
		
		for(int i=1;i<10;i++)
		{
			multiStack.push(i);
		}
		
		System.out.println(multiStack.pop());
	}

}
