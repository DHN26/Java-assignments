//Q4:  Write a program to count , how many times a method was accessed by threads, 
//in a multi-thread environment.

package io.multiThreading;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class Q4 {
	private static List<Integer> list = new ArrayList<>(List.of(1, 2, 3));
	static int noOfTimesCalled = 0;

	public static void main(String[] args) {
		Thread t1 = new Thread() {
			{
				changes("add");
			}
		};

		Thread t2 = new Thread() {
			{
				changes("remove");
			}
		};
		
		t2.start();
		t1.start();
		System.out.println(list);
	}

	public static void changes(String s) {
		int count = 1;
		noOfTimesCalled++;
		if (s.equalsIgnoreCase("add"))
		{
			count=count++;
			list.add(count);
			System.out.println(list);
		}
		else if (s.equalsIgnoreCase("remove"))
			list.remove(count);
		System.out.println("Thread accessed changes method for "+noOfTimesCalled+" times");

	}

}
