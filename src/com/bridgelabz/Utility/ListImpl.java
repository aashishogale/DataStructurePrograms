package com.bridgelabz.Utility;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import com.bridgelabz.Utility.SinglyLinkedListImpl;
public class ListImpl<T> {

	static SinglyLinkedListImpl<String> slist = new SinglyLinkedListImpl<String>();
	static SinglyLinkedListImpl<Integer> olist = new SinglyLinkedListImpl<Integer>();
	static int count;

	public  void addUnoString(String[] array) {

		count = array.length;
		for (int i = 0; i < array.length; i++) {
			slist.add(array[i]);

		}

	}

	public  void addOrderedInt(int[] array) {

		count = array.length;

		ListImpl.sort(array);
		for (int i = 0; i < array.length; i++) {
			olist.add(array[i]);

		}

	}

	public  void addAtTop(String operator) {
		slist.addFirst(operator);

	}

	public String deleteAtFirst() {
		if(slist.checkEmpty()==1) {

		return (slist.deleteFirst());
		}
		else {
			return null;
		}

	}

	public  void add(String element) {
		slist.add(element);
	}

	public  String deleteAtLast() {
		System.out.println(slist.deleteLast());
		return (slist.deleteLast());
	}

	public  int addList(String word) {

		if (slist.traverse(word) == 1) {
			slist.add(word);
			count++;

		} else {
			slist.deleteElement(word);
			count--;

		}

		return count;

	}

	public int addOrderedList(int number) {
		int index;
		System.out.println(olist.traverse(number));
		if (olist.traverse(number) == 1) {
			index = olist.returnPos(number);
			System.out.println("index" + index);

			olist.insertAt(number, index);

			count++;

		} else {
			olist.deleteElement(number);
			count--;

		}

		return count;

	}

	public  int checkEmpty() {
		return (slist.checkEmpty());

	}

	public  void getList(String[] array, int count) {

		slist.returnElement(array, count);
		olist.returnElement(array, count);

		File opFile = new File("/home/bridgeit/Desktop/newfile.txt");
		try {
			opFile.createNewFile();
			FileWriter fwriter = new FileWriter(opFile);
			for (int i = 0; i < array.length; i++) {
				System.out.println(array[i]);
				fwriter.append(array[i] + " ");

			}
			fwriter.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	public void addFirst(String element)
	{
		slist.addFirst(element);
	}

	public static void  sort(int[] array) {
		int temp;

		for (int i = 0; i < array.length; i++) {
			for (int j = 1; j < array.length - i; j++) {
				if (array[j - 1] > array[j]) {
					temp = array[j - 1];
					array[j - 1] = array[j];
					array[j] = temp;
				}
			}
		}

	}

}



	
	
