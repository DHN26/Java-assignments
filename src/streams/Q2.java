package streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Q2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> list=Arrays.asList("hello bye", "world", "hii", "greet", "Burj Khalifa");
		Stream<String> res=list.stream()
				.sorted((s1, s2) -> Integer.compare(s2.length(), s1.length()))
				.limit(3);
		res.forEach(n->System.out.print(n+". "));
	}

}
