//Q8: Design a priority queue that works with custom objects. The priority should
//be based on a specific property of the objects, and the queue should efficiently 
//support adding, removing, and updating elements

package io.collections;

import java.util.PriorityQueue;

public class Q8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PriorityQueue<Student> pq=new PriorityQueue<>();
		Student s=new Student("Poo", 2);
		pq.add(s);
		pq.add(new Student("Oogway", 12));
		pq.add(new Student("Shifu", 10));
		pq.add(new Student("A", 1));
		

		for(Student stu:pq)
		{
			System.out.println(stu);
		}
		System.out.println();
		
		pq.remove(s);
		for(Student stu:pq)
		{
			System.out.println(stu);
		}
		
	}

	public static class Student implements Comparable<Student> {
		String name;
		int std;

		public Student(String name, int std) {
			super();
			this.name = name;
			this.std = std;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public int getStd() {
			return std;
		}

		public void setStd(int std) {
			this.std = std;
		}

		@Override
		public int compareTo(Student o) {
			return Integer.compare(this.std, o.std);
		}

		@Override
		public String toString() {
			return "Student [name=" + name + ", std=" + std + "]";
		}
		

	}

}
