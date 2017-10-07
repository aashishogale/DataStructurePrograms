package com.bridgelabz.Utility;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Util {

	static SinglyLinkedListImpl<String> slist = new SinglyLinkedListImpl<String>();
	static int count;

	public static void addUnoString(String[] array) {

		count = array.length;
		for (int i = 0; i < array.length; i++) {
			slist.add(array[i]);

		}

	}

	public static int addList(String word) {

		System.out.println(slist.traverse(word));
		if (slist.traverse(word) == 1) {
			slist.add(word);
			count++;

		} else {
			slist.deleteElement(word);
			count--;

		}

		return count;

	}

	public static void showCurrentList() {
		slist.display();

	}

	public static void getList(String[] array, int count) {

		slist.returnElement(array, count);

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

}

class SinglyLinkedListImpl<T> {

	Node<T> head;
	Node<T> tail;

	public void add(T element) {

		Node<T> nd = new Node<T>();
		nd.setValue(element);
		System.out.println("Adding: " + element);
		/**
		 * check if the list is empty
		 */
		if (head == null) {
			// since there is only one element, both head and
			// tail points to the same object.
			head = nd;
			tail = nd;
		} else {
			// set current tail next link to new node
			tail.setNextRef(nd);
			// set tail as newly created node
			tail = nd;
		}
	}


	public void deleteElement(T element) {
		Node<T> tmp = head;
		Node<T> refNode = null;
		Node<T> next = null;
		Node<T> prev = null;

		System.out.println("Traversing to all nodes..");

		System.out.println(tmp.getValue());

		while (true) {
			if (tmp == null) {
				break;
			}
			 System.out.println(tmp.getValue());
			
			if (element.compareTo( tmp.getValue()) == 0) {

				// System.out.println(tmp.getValue());
				refNode = tmp;

				break;
			}

			prev = tmp;
			
			tmp = tmp.getNextRef();
		
			next = tmp.getNextRef();
			System.out.println(prev.getValue());
			System.out.println(tmp.getValue());
			System.out.println(next.getValue());

		}

		if (refNode != null) {

			if (refNode == head) {
				System.out.println("Deleted: " + tmp.getValue());
				tmp = tmp.getNextRef();
				
				head = tmp;
			}

			else if (refNode.getNextRef() == null) {
				tail = refNode;
				System.out.println("Deleted: " + tmp.getValue());
			} else {

				// System.out.println(next.getValue());

				prev.setNextRef(next);
				System.out.println("Deleted: " + tmp.getValue());
			}
		}

		else {
			System.out.println("Unable to find the given element...");
		}

		// System.out.println("Deleted: " + tmp.getValue());
	}

	public int traverse(T element) {
		Node<T> tmp = head;

		while (true) {
			if (tmp == null) {
				break;
			}

			if (((String) element).compareTo((String) tmp.getValue()) == 0)
				return 0;

			System.out.println(tmp.getValue());
			tmp = tmp.getNextRef();
		}
		return 1;
	}

	public void returnElement(String[] array, int count) {
		Node<T> tmp = head;

		int i = 0;

		while (true && i < count) {
			if (tmp == null) {
				break;
			}

			array[i] = (String) tmp.getValue();
			i++;

			tmp = tmp.getNextRef();
		}
	}
		

		public void display() {
			Node<T> tmp = head;
			while (true) {
				if (tmp == null) {
					break;
				}
				tmp = tmp.getNextRef();
				
				System.out.println(tmp.getValue());
			}
		}

	}

	class Node<T> implements Comparable<T> {

		private T value;
		private Node<T> nextRef;

		public T getValue() {
			return value;
		}

		public void setValue(T value) {
			this.value = value;
		}

		public Node<T> getNextRef() {
			return nextRef;
		}

		public void setNextRef(Node<T> ref) {
			this.nextRef = ref;
		}

		@Override
		public int compareTo(T arg) {
			if (arg == this.value) {
				return 0;
			} else {
				return 1;
			}
		}
	}
