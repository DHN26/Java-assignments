package io.vcti.javaio;

import java.util.List;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		FileManager fm = new FileManager();

		String content = "Poo is the dragon warrior and Shifu is his Master.";
		String fileName = "dw.txt";

		fm.createFile(content, fileName);

		System.out.println(fm.readFile(fileName));

		fm.appendToFile(fileName, content);

		String sourcePath = "newAssignment.txt";
		fm.copyFile(sourcePath, fileName);
		
		String fileToDelete = "C:\\Users\\divyashree.nataraja\\OneDrive - VCTI\\Desktop\\dw.txt";
		fm.deleteFile(fileToDelete);

		String directoryPath = "C:\\Users\\divyashree.nataraja\\OneDrive - VCTI\\Desktop";
		List<String> list = fm.listDirectory(directoryPath);
		for (String s : list) {
			System.out.println(s);
		}
		
		String directory="C:\\Users\\divyashree.nataraja\\OneDrive - VCTI\\Desktop\\demo";
		fm.copyDirectory(sourcePath, directory);
		
		List<String> listOfFiles=fm.searchFilesByExtension("C:\\\\Users\\\\divyashree.nataraja\\\\OneDrive - VCTI\\\\Desktop", ".txt");
		for(String s:listOfFiles)
		{
			System.out.print(s+" ");
		}

	}

}
