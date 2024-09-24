//Q5: Write a program to sort the String characters and the strings in a List<String>. 
//sorting has to be done in decending order using comparator.  

package io.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Q5 {

	public static void main(String[] args) {
		List<String> list=new ArrayList<>();
		list=Arrays.asList("Poo","Tigress", "Shifu", "Crane", "Mantis");
		System.out.println("Elements before sort : "+list);
		for(int i=0;i<list.size();i++)
		{
			String s=charSort(list.get(i));
			list.set(i, s);
		}
		Collections.sort(list, Comparator.reverseOrder());
		System.out.println("Elements after sort : "+list);
	}
	
	public static String charSort(String s)
	{
		List<Character> ch=s.chars()  
                .mapToObj(c -> (char) c)  
                .collect(Collectors.toList());

		Collections.sort(ch, Comparator.reverseOrder());
		StringBuilder str=new StringBuilder();
		for(char c: ch)
		{
			str.append(c);
		}
		return str.toString();
	}

}
