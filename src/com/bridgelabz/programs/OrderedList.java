/***************************************************************************
* Purpose : To create class creating ordered list
*
* @author   Aashish
* @version  1.0
* @since    08-10-2017
****************************************************************************/

package com.bridgelabz.programs;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import com.bridgelabz.utility.ListImpl;

/**
 * @author Aashish
 *
 */
public class OrderedList {
	public static void main(String args[]) {
		String str;
		int number;
		char next;
		int count = 1;
		ListImpl list = new ListImpl();

		Scanner scanner = new Scanner(System.in);

		BufferedReader breader;
		try {
			breader = new BufferedReader(new FileReader("/home/bridgeit" + "/Desktop/orderedtest.txt"));
			str = breader.readLine();
			String[] array = str.split(",");
			int[] narray = new int[array.length];
			for (int i = 0; i < array.length; i++) {
				System.out.println(array[i]);
				narray[i] = Integer.parseInt(array[i]);

			}
			list.sort(narray);
			list.addOrderedInt(narray);
			do {
				System.out.println("enter the number");

				number = Integer.parseInt(scanner.nextLine());
				count = list.addOrderedList(number);
			
				System.out.println("do you want to continue");
				next = scanner.nextLine().charAt(0);
				

			} while (next != 'n');

			String[] sarray = new String[count];
			
			list.getOrderedList();
		
			scanner.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
