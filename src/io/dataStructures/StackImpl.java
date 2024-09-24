package io.dataStructures;

public class StackImpl {
	private Node top;

	public static void main(String[] args) {
		StackImpl stack = new StackImpl();
		int arr[] = { 1, 2, 3, 4, 5 };

		for (int i = 0; i < arr.length; i++) {
			stack.push(arr[i]);
			System.out.println("Element pushed into the stack : "+stack.top.val + " ");
		}
		

		stack.print();

		for (int i = 0; i < 6; i++) {
			try {
				System.out.println(stack.pop());
			}
			catch(IllegalStateException e)
			{
				System.out.println(e.getMessage());
			}
		}

	}

	public void push(int data) {
		if (top == null) {
			top = new Node(data, null);

		} else {
			Node temp = new Node(data, null);
			temp.next = top;
			top = temp;
		}

	}

	public int pop() {
		if (top == null) {
			throw new IllegalStateException("Stack is empty!");
		} else {
			int value = top.val;
			top = top.next;
			return value;
		}
	}

	public void print() {
		Node temp = top;
		System.out.println("Elements in stack : ");
		while (temp != null) {
			System.out.print(temp.val + " ");
			temp = temp.next;
		}
		System.out.println();
	}

}
