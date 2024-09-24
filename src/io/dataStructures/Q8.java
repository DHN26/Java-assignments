//Q8: Write a Program to find the first non-repeating character in a string.

package io.dataStructures;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Q8 {

	public static void main(String[] args) {
		String str="aassssddfgghhk";
		Map<Character, Integer> map=new HashMap<>();
		for(int i=0;i<str.length();i++)
		{
			map.put(str.charAt(i), map.getOrDefault(str.charAt(i), 0)+1);
		}
		
		for (Entry<Character, Integer> e : map.entrySet()) {
			if(e.getValue()==1)
			{
				System.out.println("Unique char : "+e.getKey());
				break;
			}
		}

	}

}
