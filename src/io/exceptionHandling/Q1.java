//Q1: Write program for OutofMemory Exception and its prevention (Its design issue 
//or memory leak differentiate it.)

package io.exceptionHandling;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Q1 {

	public static void main(String[] args) {
		int size =20;
		List<Object> list = new ArrayList<>();

		try {
			while (true) {
                for (int i = 0; i < size; i++) {
                    list.add(new Byte[1024 * 1024]);
                   
                }
                size += size;
                System.out.println("Allocated " + size + " MB");
            }
			
		} catch (OutOfMemoryError e) {
			System.out.println("Error allocating "+size+" MB");
		}
	}

}
