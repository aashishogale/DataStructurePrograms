/***************************************************************************
* Purpose : To create class for creating hash with linked list
*
* @author   Aashish
* @version  1.0
* @since    08-10-2017
****************************************************************************/

package com.bridgelabz.Programs;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

import com.bridgelabz.Utility.SinglyLinkedListImpl;

/**
 * @author Aashish
 *
 */
public class HashSearch {
	public static void main(String args[]) {
		HashSearch hash = new HashSearch();
		Scanner scanner = new Scanner(System.in);

		String filepath = "/home/bridgeit" + "/Desktop/orderedtest.txt";
		String[] number = hash.addFromFile(filepath);

		HashMap<Integer, SinglyLinkedListImpl<Integer>> map = new HashMap<>();

		for (int i = 0; i < 11; i++) {
			map.put(i, new SinglyLinkedListImpl<Integer>());
		}

		for (int i = 0; i < number.length; i++) {
			int numberToAdd = Integer.parseInt(number[i]);
			
			map.get(numberToAdd % 11).add(numberToAdd);

		}
		
		System.out.println("Enter number to search");
		int search = scanner.nextInt();
		if (hash.findNumber(map, search)) {
			System.out.println("Number is present");
			int index = map.get(search % 11).findIndex(search);
			map.get(search % 11).deleteAt(index);
		} else {
			map.get(search % 11).add(search);
			System.out.println("Number Added to the file");
		}

		String file = "/home/bridgeit/Desktop/newfile.txt";

		hash.writeInFile(map, file);

	}

	public boolean findNumber(HashMap<Integer, SinglyLinkedListImpl<Integer>> map, int number) {
		if (map.get(number % 11).traverse(number) == 0) {
			return true;

		}
		return false;
	}

	public String[] addFromFile(String filePath) {
		BufferedReader breader;
		String str;
		String[] array = null;
		try {
			breader = new BufferedReader(new FileReader(filePath));
			str = breader.readLine();
			array = str.split(",");

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return array;

	}

	public void writeInFile(HashMap<Integer, SinglyLinkedListImpl<Integer>> map, String file) {
		String array[] = {};
		ArrayList<String> list = new ArrayList<String>();
		for (int i = 0; i < map.size(); i++) {
			int j = 0;
			while (j < map.get(i).size()) {
				// System.out.println(map.get(i).get(j));
				list.add(map.get(i).returnItem(j) + " ");
				j++;
			}
			list.add("\n");

		}
		array = list.toArray(new String[list.size()]);
		File opFile = new File(file);
		try {
			opFile.createNewFile();
			FileWriter fwriter = new FileWriter(opFile);
			for (int i = 0; i < array.length; i++) {
				// System.out.println(array[i]);
				fwriter.append(array[i] + " ");

			}
			fwriter.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
