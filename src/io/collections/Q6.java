//Q6: Implement a program that counts the frequency of words in a given text using 
//a ConcurrentHashMap. Ensure that the program efficiently handles concurrent read and 
//write operations without using external locks. input to program can be mutiple 
//paragraphs at a time.

package io.collections;

import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Q6 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		String s = "Poo is the dragon warrior. Poo used to be called as the Big Fat Panda. But Oogway made him a legend. Poo made many good friends";
		String words[] = s.split("\\.");
		ConcurrentHashMap<String, Integer> chm = new ConcurrentHashMap<String, Integer>();
		ExecutorService service = Executors.newFixedThreadPool(words.length);

		for (String sentence : words) {
			service.submit(() -> {
				String sentences = sentence.toLowerCase();
				String word[] = sentences.split(" ");
				for (String i : word) {
					chm.put(i, chm.getOrDefault(i, 0) + 1);
				}
			});
		}
		Thread.sleep(4000);
		service.shutdown();

		System.out.println(chm);

	}

}
