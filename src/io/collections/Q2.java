//Q2: Create your own custom cache using HashMap.Create cache, able to add 
//2000 values and read values from cache

package io.collections;

import java.util.HashMap;
import java.util.Map;

public class Q2 {
	private static Map<Integer, String> map=new HashMap<>(2000);
	static Q2 cache=new Q2(map);

	public Q2(Map<Integer, String> map) {
		super();
		this.map = map;
	}

	public static void main(String[] args) {
		for(int i=1;i<=2000;i++)
		{
			map.put(i, "Value");
		}
		
		System.out.println(cache.getElement(34));
		cache.putElement(2001, "Some value");
		System.out.println(map);
	}
	
	public void putElement(Integer n, String m)
	{
		if(map.size()>=2000)
			System.out.println("Map is full. Can't insert new entry!");
		else
			map.put(n, m);
	}
	
	public String getElement(Integer n)
	{
		return map.get(n);
	}

	@Override
	public String toString() {
		return "Q2 [map=" + map + "]";
	}
	
	
}
