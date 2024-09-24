//Q3: Create a program that reads a list of words from a file, uses Streams and 
//Lambda Expressions to group the words by their first letter, and then counts the 
//number of words in each group. Print the result.

package streams;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Q3 {

	public static void main(String[] args) {
		String paragraph = "Once upon a time a rabbit lost the race against tortaise";
		String[] str = paragraph.split(" ");
		List<String> list = Arrays.asList(str);

		Map<Character, Long> groupedWords = list.stream()
				.collect(Collectors.groupingBy(word -> word.charAt(0), Collectors.counting()));

		groupedWords.forEach((letter, count) -> System.out.println("Words starting with '" + letter + "': " + count));

	}

}
