/***************************************************************************
* Purpose : To create class for unordered list
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
public class UnorderedList {
	public static ListImpl list = new ListImpl();

	public static void main(String args[]) {

		String stringForSplitting;
		String name;
		char next;
		int count = 1;

		Scanner scanner = new Scanner(System.in);

		BufferedReader breader;
		try {
			breader = new BufferedReader(new FileReader("/home/bridgeit" + "/Desktop/test.txt"));
			stringForSplitting = breader.readLine();
			String[] array = stringForSplitting.split(",");
			list.addUnoString(array);
			do {
				System.out.println("enter the word");

				name = scanner.nextLine();
				count = list.addList(name);

				System.out.println("do you want to continue");
				next = scanner.nextLine().charAt(0);

			} while (next != 'n');

			String[] sarray = new String[count];
			list.getList();
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
