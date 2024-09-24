package streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Q1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        Stream<Integer> squaredNumbers = numbers.stream()
                                              .filter(n -> n % 2 != 0)  
                                              .map(n -> n * n);  

        squaredNumbers.forEach(n->System.out.print(n+" "));  
	}

}
