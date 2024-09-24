//Assignment: File Management System with Java I/O
//
//Create a file management system that can perform basic operations on files and directories, such as creating, reading, writing, copying, and deleting files.
//
//Requirements:
//
//1. Create a FileManager Class:
//
//Methods:
//void createFile(String filePath, String content): Creates a new file at the specified path and writes the provided content to it. If the file already exists, it should overwrite it.
//String readFile(String filePath): Reads the content of a file and returns it as a String.
//void appendToFile(String filePath, String content): Appends content to the end of an existing file.
//void copyFile(String sourcePath, String destPath): Copies a file from the source path to the destination path.
//void deleteFile(String filePath): Deletes a file at the specified path.
//List<String> listDirectory(String dirPath): Lists all files and directories within the specified directory.
//
//
//2.Implement Error Handling:
//
//Each method should handle potential I/O exceptions (e.g., FileNotFoundException, IOException) and provide meaningful error messages.
//
//3.Implement Buffered I/O:
//
//Use BufferedReader and BufferedWriter for reading and writing operations to improve efficiency.
//
//
//4.Create a Main Class:
//
//Demonstrate the functionality of the FileManager class:
//Create a few files with content.
//Read and display the content of the files.
//Append new content to an existing file and read it again.
//Copy a file to a new location and verify the copy.
//List the contents of a directory.
//Delete a file and confirm its deletion.
//
//5.Bonus Challenge:
//
//Implement Directory Copying:
//
//Add a method void copyDirectory(String sourceDirPath, String destDirPath) that copies all files and subdirectories from one directory to another.
//Search Files by Extension:
//
//Add a method List<String> searchFilesByExtension(String dirPath, String extension) that lists all files in a directory (and its subdirectories) that have a specific extension (e.g., .txt, .java).

package io.vcti.javaio;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.AccessDeniedException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;

public class FileManager {

	BufferedWriter bw;
	BufferedReader br;
	String path = "C:\\Users\\divyashree.nataraja\\OneDrive - VCTI\\Desktop";

	void createFile(String content, String fileName) {
		String pathTemp = path + "\\" + fileName;
		try {
			bw = new BufferedWriter(new FileWriter(pathTemp));
			bw.write(content);
			bw.flush();
			System.out.println("Content written successfully into file : " + fileName);

		} catch (IOException e) {
			System.out.println("Couldn't write into file!");
		} finally {
			try {
				if (bw != null) {
					bw.close();
				}
			} catch (IOException e) {
				System.out.println("An error occurred while closing the BufferedWriter: " + e.getMessage());
			}
		}

	}

	String readFile(String fileName) {

		String res = null;
		try {
			br = new BufferedReader(new FileReader(path + "\\" + fileName));
			System.out.println("Content inside file :");
			res = br.readLine();
		} catch (IOException e) {
			System.out.println("Couldn't read the data!");
		}
		return res;
	}

	void appendToFile(String fileName, String content) {
		String pathTemp = path + "\\" + fileName;

		try {
			bw = new BufferedWriter(new FileWriter(pathTemp, true));
			bw.write(content);
			bw.flush();
			System.out.println("Content appended successfully!");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("File not found!");
		}
	}

	void copyFile(String sourcePath, String destPath) {
		Path destFilePath = Paths.get(path, "\\" + destPath);
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(destFilePath.toString(), true));
				BufferedReader br = new BufferedReader(new FileReader(sourcePath))) {
			int i;
			while ((i = br.read()) != -1) {
				bw.write(i);
			}
			System.out.println("Copied successfully!");
		} catch (IOException e) {
			System.out.println("Couldn't copy " + sourcePath + " into " + destPath + "!");
		} finally {
			try {
				bw.close();
				br.close();
			} catch (IOException e) {
				System.out.println("File NOT closed!");
			}
		}

	}

	void deleteFile(String sourcePath) {
		Path pathTemp = Paths.get(sourcePath);

		try {
			Files.delete(pathTemp);
			System.out.println("File deleted successfully!");
		} catch (NoSuchFileException e) {
			System.out.println("No such file or directory: " + e.getMessage());
		} catch (AccessDeniedException e) {
			System.out.println("Permission denied: " + e.getMessage());
		} catch (IOException e) {
			System.out.println("An IO error occurred: " + e.getMessage());
		} catch (SecurityException e) {
			System.out.println("Security exception: " + e.getMessage());
		}

	}

	List<String> listDirectory(String dirPath) {
		System.out.println("Lists all files and directories within the specified directory : ");
		List<String> fileList = new ArrayList<>();
		Path path = Paths.get(dirPath);// path is used to locate resources like file directory in a system.
		DirectoryStream<Path> stream;
		try {
			stream = Files.newDirectoryStream(path);
			for (Path entry : stream) {
				fileList.add(entry.getFileName().toString());
			}
		} catch (IOException e) {
			System.out.println("Error while listing directory!");
		}

		return fileList;

	}

	public void copyDirectory(String sourceDirPath, String destDirPath) {
		Path sourceDir = Paths.get(sourceDirPath);
		Path destDir = Paths.get(destDirPath);

		try {

			if (Files.notExists(destDir)) {
				Files.createDirectories(destDir);
			}

			try (DirectoryStream<Path> stream = Files.newDirectoryStream(sourceDir)) {
				for (Path entry : stream) {
					Path targetPath = destDir.resolve(entry.getFileName());
					if (Files.isDirectory(entry)) {

						copyDirectory(entry.toString(), targetPath.toString());
					} else {

						Files.copy(entry, targetPath, StandardCopyOption.REPLACE_EXISTING);
					}
				}
			}
		} catch (IOException e) {
			System.out.println("Error while copying directory: " + e.getMessage());
		}
	}

	List<String> searchFilesByExtension(String dirPath, String extension) {
		List<String> fileList = new ArrayList<>();
		Path startPath = Paths.get(dirPath);

		try {
			Files.walk(startPath).filter(path -> !Files.isDirectory(path) && path.toString().endsWith(extension))
					.forEach(path -> fileList.add(path.toString()));
		} catch (IOException e) {
			e.printStackTrace();
		}

		return fileList;
	}
}
