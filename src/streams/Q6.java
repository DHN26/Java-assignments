//Q6: Write a program that uses Streams and Lambda Expressions to process a list of 
//strings. Print each string's length, convert it to uppercase, and then print the 
//modified string. Use the peek method for debugging purposes.

package streams;

import java.util.Arrays;
import java.util.List;

public class Q6 {

	public static void main(String[] args) {
		List<String> list = Arrays.asList("help", "bob", "to", "find", "Alex");
		list.stream().peek(ele->System.out.print(ele+" -> ")).forEach(s -> System.out.print(s.length() + ". "));
		System.out.println();
		list.stream().peek(ele->System.out.print(ele+" -> ")).map(s -> s.toUpperCase()).forEach(ele -> System.out.print(ele + ". "));
		
	}

}
