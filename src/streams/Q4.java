//Q4: Given a list of lists of integers, use Streams and Lambda Expressions to 
//flatten the structure (convert it to a single list) and remove duplicate numbers. 
//Then, print the distinct numbers.

package streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Q4 {

	public static void main(String[] args) {
		
		List<List<Integer>> fullList = Arrays.asList(
				Arrays.asList(90,26,-12,0,453),
				Arrays.asList(0,78,123,-63),
				Arrays.asList(90,286,-112,0,45));
		
		List<Integer> finalList=fullList.stream()
									.flatMap(list->list.stream())//=>flatMap(List::stream)
									.distinct()
									.collect(Collectors.toList());
		System.out.println(finalList);
		

	}

}
