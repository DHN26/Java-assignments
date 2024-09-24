package io.vcti.serialization;

import java.util.ArrayList;
import java.util.List;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public class Main {

	public static void main(String[] args) throws Exception {
		KeyGenerator keyGenerator=KeyGenerator.getInstance("AES");
		SecretKey secretKey = keyGenerator.generateKey();
		
		List<Book> listOfBooks=new ArrayList<>();
		Book b1=new Book("Wings of fire","Arun tiwari",2017, "asdf");
		Book b2=new Book("Ramayana","Valmiki",12, "qwer");
		Book b3=new Book("The sky is Pink","Zoya Aktar",2015, "zxcv");
		
		Library lib=new Library(secretKey, listOfBooks);
		lib.addBook(b1);
		lib.addBook(b2);
		lib.addBook(b3);
		
		lib.removeBook("asdf");
		
		System.out.println("Books in library before saving to file :");
		lib.listBooks();
		System.out.println();
		
		lib.saveLibrary("newAssignment.txt");
		
		lib.loadLibrary("newAssignment.txt");
		
		System.out.println();
		System.out.println("Books in library after saving to file :");
		lib.listBooks();

	}

}
