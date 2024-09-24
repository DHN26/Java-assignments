//Q7: Write program to Store custom objects into tree set and maintain orders of object
//based on specific object property. Do same with hash set and linked hash set validate
//the result.
//For Example: Employee class has id and name attributes. Set should maintain employee
//instance by employee id.

package io.collections;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;

public class Q7 {

	public static void main(String[] args) {
		TreeSet<Employee> treeSet=new TreeSet<Q7.Employee>();
		treeSet.add(new Employee(2, "Pooo"));
		treeSet.add(new Employee(1, "Tigress"));
		treeSet.add(new Employee(3, "Shifu"));
		
		System.out.println("Storing using TreeSet :");
		System.out.println(treeSet);
		System.out.println();
		
		HashSet<Employee> hashset=new HashSet<>();
		hashset.add(new Employee(2, "Pooo"));
		hashset.add(new Employee(1, "Tigress"));
		hashset.add(new Employee(3, "Shifu"));
		
		System.out.println("Storing using HashSet :");
		System.out.println(hashset);
		System.out.println();
		
		LinkedHashSet<Employee> linkedhashset=new LinkedHashSet<>();
		linkedhashset.add(new Employee(2, "Pooo"));
		linkedhashset.add(new Employee(1, "Tigress"));
		linkedhashset.add(new Employee(3, "Shifu"));
		
		System.out.println("Storing using LinkedHashSet :");
		System.out.println(linkedhashset);
	}
	
	public static class Employee implements Comparable<Employee>{
		int id;
		String name;
		
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public Employee(int id, String name) {
			super();
			this.id = id;
			this.name = name;
		}
		
		
		@Override
        public int compareTo(Employee other) {
            return Integer.compare(this.id, other.id);
        }

        @Override
        public String toString() {
            return "{Id=" + id + ", Name='" + name + "'}";
        }
		
		
	}

}
