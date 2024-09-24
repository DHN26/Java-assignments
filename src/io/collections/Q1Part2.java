//Q1:Design and implement a simple LRU (Least Recently Used) cache using a 
//combination of Linked HashMap and LinkedList. The cache should have a specified 
//capacity, and old entries should be evicted when the capacity is exceeded.

package io.collections;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;

public class Q1Part2 {
	private int capacity;
	private Map<Integer, String> map;
	private LinkedList<Integer> list;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter the capacity of the LRU cache: ");
		int capacity = scanner.nextInt();
		Q1Part2 cache = new Q1Part2(capacity);

		while (true) {
			System.out.println("Choose an operation: 1. Put 2. Get 3. Display 4. Exit");
			int choice = scanner.nextInt();
			switch (choice) {
			case 1:
				System.out.print("Enter key: ");
				int key = scanner.nextInt();
				System.out.print("Enter value: ");
				String value = scanner.next();
				cache.put(key, value);
				break;
			case 2:
				System.out.print("Enter key: ");
				key = scanner.nextInt();
				String result = cache.get(key);
				if (result != null) {
					System.out.println("Value: " + result);
				} else {
					System.out.println("Key not found.");
				}
				break;
			case 3:
				System.out.println("Cache content: " + cache);
				break;
			case 4:
				scanner.close();
				System.exit(0);
			default:
				System.out.println("Invalid choice. Please try again.");
			}
		}

	}

	public Q1Part2(int capacity) {
		this.capacity = capacity;
		this.map = new LinkedHashMap<Integer, String>();
		this.list = new LinkedList<Integer>();
	}

	public String get(Integer key) {
		if (map.containsKey(key)) {
			list.remove(key);
			list.addFirst(key);
			return map.get(key);
		} else
			return null;
	}

	public void put(Integer key, String val) {
		if (map.containsKey(key))
			list.remove(key);
		else if (map.size() >= capacity) {
			Integer old = list.removeLast();
			map.remove(old);
		}
		list.addFirst(key);
		map.put(key, val);
	}

	@Override
	public String toString() {
		return "Q1Part2 [capacity=" + capacity + ", map=" + map + ", list=" + list + "]";
	}
	
	

}
