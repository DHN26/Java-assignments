package io.vcti.serialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.System.Logger;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.List;

import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SealedObject;
import javax.crypto.SecretKey;

public class Library implements Serializable {
	Library lib;

	List<Book> list;
	SecretKey secretKey;
	// private static final Logger logger = LoggerFactory.getLogger(Library.class);

	public Library(SecretKey secretKey, List<Book> list) {
		this.secretKey = secretKey;
		this.list=list;
	}

	public Library(Serializable obj, Cipher cipher) {
		// TODO Auto-generated constructor stub
	}

	void addBook(Book book) {
		list.add(book);
	}

	void removeBook(String isbn) {
		for (Book b : list) {
			if (b.isbn.equals(isbn)) {
				list.remove(b);
				break;
			}
		}
	}

	void listBooks() {
		for (Book b : list) {
			System.out.println(b);
		}
	}

//
//    public Library() throws Exception {
//        this.secretKey = KeyGenerator.getInstance("AES").generateKey();
//    }
//
//    public void saveLibrary(String fileName) throws IOException {
//        try (FileOutputStream fos = new FileOutputStream(fileName);
//             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
//            oos.writeObject(this);
//        }
//    }
//
//    private void writeObject(ObjectOutputStream out) throws Exception {
//        // Encrypt the library object
//        Cipher cipher = Cipher.getInstance("AES");
//        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
//        SealedObject sealedObject = new SealedObject(this, cipher);
//        out.writeObject(sealedObject);
//        System.out.println("Library object saved to file!");
//    }
//
//    public void loadLibrary(String fileName) throws Exception {
//        try (FileInputStream fis = new FileInputStream(fileName);
//             ObjectInputStream ois = new ObjectInputStream(fis)) {
//            Library lib = (Library) ois.readObject();
//            this.secretKey = lib.secretKey;
//            System.out.println("Library object retrieved from file!");
//        }
//    }
//
//    private void readObject(ObjectInputStream in) throws Exception {
//        // Decrypt the library object
//        SealedObject sealedObject = (SealedObject) in.readObject();
//        Cipher cipher = Cipher.getInstance("AES");
//        cipher.init(Cipher.DECRYPT_MODE, secretKey);
//        Library lib = (Library) sealedObject.getObject(cipher);
//        
//        // Copy data from decrypted library to this object
//        // Assuming you have getter and setter methods for all fields in Library
//        // Copy field values from lib to this
//
//        in.defaultReadObject();
//        System.out.println("Library object retrieved from file!");
//    }
//	
	

	void saveLibrary(String fileName) throws Exception {
		
		Cipher cipher = Cipher.getInstance("AES");
		cipher.init(Cipher.ENCRYPT_MODE, secretKey);
		//System.out.print(secretKey);
		FileOutputStream fos = new FileOutputStream(fileName);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		CipherOutputStream cipherOut = new CipherOutputStream(oos, cipher);
		oos.writeObject(this);
	}

	private void writeObject(ObjectOutputStream out) throws Exception {

		out.defaultWriteObject();
		System.out.println("Library object saved to file!");
	}

	void loadLibrary(String fileName) throws Exception {
		
		Cipher cipher = Cipher.getInstance("AES");
		cipher.init(Cipher.DECRYPT_MODE, secretKey);
		FileInputStream fis = new FileInputStream(fileName);
		ObjectInputStream ois = new ObjectInputStream(fis);
		CipherInputStream cipherIn = new CipherInputStream(ois, cipher);

		Library res = (Library) ois.readObject();
		System.out.println(res);
		ois.close();
		fis.close();
	}

	private void readObject(ObjectInputStream in) throws Exception {

		in.defaultReadObject();
		System.out.println("Library object retrieved from file!");
	}

}
