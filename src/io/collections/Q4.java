//Q4: Write a program to find and remove duplicate elements from an ArrayList without
//using any additional data structures. The goal is to achieve this with optimal time
//and space complexity.	

package io.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q4 {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 1, 2));
        System.out.println("Before: " + list);
        list = removeDuplicates(list);
        System.out.println("After: " + list);
    }

    public static List<Integer> removeDuplicates(List<Integer> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(i).equals(list.get(j))) {
                    list.remove(j);
                    j--; 
                }
            }
        }
        return list;
    }

}
