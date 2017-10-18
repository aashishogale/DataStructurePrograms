/***************************************************************************
* Purpose : To create methods for implementing unordered and ordered list
*
* @author   Aashish
* @version  1.0
* @since    08-10-2017
****************************************************************************/

package com.bridgelabz.Utility;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import com.bridgelabz.Utility.SinglyLinkedListImpl;

public class ListImpl<T> {

	static SinglyLinkedListImpl<String> slist = new SinglyLinkedListImpl<String>();
	static SinglyLinkedListImpl<Integer> olist = new SinglyLinkedListImpl<Integer>();
	static int count;

	/**
	 * purpose:add unordered string
	 * 
	 * @param array
	 * @return
	 */
	public void addUnoString(String[] array) {

		count = array.length;
		for (int i = 0; i < array.length; i++) {
			slist.add(array[i]);

		}

	}

	/**
	 * purpose:add ordered integer
	 * 
	 * @param array
	 * @return
	 */
	public void addOrderedInt(int[] array) {

		count = array.length;

		ListImpl.sort(array);
		for (int i = 0; i < array.length; i++) {
			olist.add(array[i]);

		}

	}

	/**
	 * purpose:add at the head
	 * 
	 * @param operator
	 * @return
	 */
	public void addAtTop(String operator) {
		slist.addFirst(operator);

	}

	/**
	 * purpose:delete at first
	 * 
	 * @param
	 * @return head
	 */
	public String deleteAtFirst() {
		if (slist.checkEmpty() == 1) {

			return (slist.deleteFirst());
		} else {
			return null;
		}

	}

	/**
	 * purpose:add element to linked list
	 * 
	 * @param element
	 * @return
	 */
	public void add(String element) {
		slist.add(element);
	}

	/**
	 * purpose:delete tail
	 * 
	 * @param element
	 * @return
	 */
	public String deleteAtLast() {
		System.out.println(slist.deleteLast());
		return (slist.deleteLast());
	}

	/**
	 * purpose:add or delete to the list if present and return count
	 * 
	 * @param word
	 * @return count
	 */
	public int addList(String word) {

		if (slist.traverse(word) == 1) {
			slist.add(word);
			count++;

		} else {
			slist.deleteElement(word);
			count--;

		}

		return count;

	}

	/**
	 * purpose:add integer to list
	 * 
	 * @param number
	 * @return count
	 */

	public int addOrderedList(int number) {
		int index;
	
		if (olist.traverse(number) == 1) {
			index = olist.returnPos(number);
			System.out.println("number will be added at" + index);

			olist.insertAt(number, index);

			count++;

		} else if (olist.traverse(number) == 0) {
			olist.deleteElement(number);
			count--;

		}

		return count;

	}

	/**
	 * purpose:check id list is empty
	 * 
	 * @param
	 * @return
	 */
	public int checkEmpty() {
		return (slist.checkEmpty());

	}

	/**
	 * purpose:add list to file
	 * 
	 * @param
	 * @return
	 */

	public void getList() {

		File opFile = new File("/home/bridgeit/Desktop/newfile.txt");
		try {
			opFile.createNewFile();
			FileWriter fwriter = new FileWriter(opFile);

			for (int i = 0; i < slist.size(); i++) {

				fwriter.append(slist.returnItem(i) + " ");

			}
			fwriter.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * purpose:add ordered list ot file
	 * 
	 * @param
	 * @return
	 */
	public void getOrderedList() {

		File opFile = new File("/home/bridgeit/Desktop/newfile.txt");
		try {
			opFile.createNewFile();
			FileWriter fwriter = new FileWriter(opFile);

			for (int i = 0; i < olist.size(); i++) {

				fwriter.append(olist.returnItem(i) + " ");

			}
			fwriter.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * purpose:add element to head
	 * 
	 * @param
	 * @return
	 */
	public void addFirst(String element) {
		slist.addFirst(element);
	}

	/**
	 * purpose:sort the given array
	 * 
	 * @param array
	 * @return
	 */
	public static void sort(int[] array) {
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
	public  void viewList() {
		olist.view();
	}

}
