//Implement a Simple Library System with Serialization.
//
//Create a simple library management system where you can add, remove, and list books. You should also be able to save the current state of the library to a file and load it back, using Java Serialization.
//
//Requirements:
//Create a Book Class:
//
//1. Fields: String title, String author, int yearPublished, String isbn.
//Implement the Serializable interface.
//Override the toString() method to return a string representation of the book.
//
//2. Create a Library Class:
//
//Field: List<Book> books.
//Methods:
//void addBook(Book book): Adds a book to the library.
//void removeBook(String isbn): Removes a book from the library based on the ISBN.
//void listBooks(): Lists all the books in the library.
//void saveLibrary(String fileName): Serializes the books list to a file.
//void loadLibrary(String fileName): Deserializes the books list from a file.
//
//3.Implement Custom Serialization:
//
//In the Library class, implement custom serialization and deserialization logic using writeObject() and readObject() methods to add additional logging when the library is saved or loaded.
//
//4.Create a Main Class:
//
//Demonstrate the functionality:
//Add a few books to the library.
//List the books.
//Save the library to a file.
//Load the library from the file.
//List the books again to confirm the state is restored.
//
//
//Bonus Challenge:
//Add Encryption to the Serialization Process:
//Modify the Library class to encrypt the serialized data before saving it to a file and decrypt it when loading.
//Use a simple symmetric encryption algorithm (e.g., AES).

package io.vcti.serialization;

import java.io.Serializable;

public class Book implements Serializable {

	String title;
	String author;
	int yearPublished;
	String isbn;

	public Book(String title, String author, int yearPublished, String isbn) {
		super();
		this.title = title;
		this.author = author;
		this.yearPublished = yearPublished;
		this.isbn = isbn;
	}

	@Override
	public String toString() {
		return "Book [title=" + title + ", author=" + author + ", yearPublished=" + yearPublished + ", isbn=" + isbn
				+ "]";
	}

}
