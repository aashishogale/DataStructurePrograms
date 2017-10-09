package com.bridgelabz.Utility;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Util<T> {

	static SinglyLinkedListImpl<String> slist = new SinglyLinkedListImpl<String>();
	static SinglyLinkedListImpl<Integer> olist = new SinglyLinkedListImpl<Integer>();
	static int count;

	public static void addUnoString(String[] array) {

		count = array.length;
		for (int i = 0; i < array.length; i++) {
			slist.add(array[i]);

		}

	}
	public static void addOrderedInt(int []array) {

		count = array.length;
		
		Util.sort(array);
		for (int i = 0; i < array.length; i++) {
			olist.add(array[i]);

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
	
	
	public static int addOrderedList(int number) {
		int index;
		System.out.println(olist.traverse(number));
		if (olist.traverse(number) == 1) {
			index=olist.returnPos(number);
			System.out.println("index"+index);
			olist.insertAt(number,index-1);
			count++;

		} else {
			olist.deleteElement(number);
			count--;

		}

		return count;

	}

	

	public static void showCurrentList() {
		slist.display();

	}
	public static void showCurrentOrderedList() {
		olist.display();

	}

	public static void getList(String[] array, int count) {

		slist.returnElement(array, count);

		File opFile = new File("/home/bridgeit/Desktop/newfile.txt");
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
	public static void getOrderedList(String  []array, int count) {

		olist.returnElement(array, count);

		File opFile = new File("/home/bridgeit/Desktop/newfile.txt");
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
	public static void sort(int []array) {int temp;

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

class SinglyLinkedListImpl<T>{

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

		//System.out.println("Traversing to all nodes..");

		//System.out.println(tmp.getValue());

		while (true) {
			if (tmp == null) {
				break;
			}
			System.out.println(tmp.getValue());

			if (element.equals(tmp.getValue())) {

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

	public void insertAt(T number, int pos) {
		Node<T> tmp = head;
		Node<T> refNode = null;
		Node<T> prev = null;
		Node<T> next = null;

		int i = 0;

		//System.out.println("Traversing to all nodes..");

		//System.out.println(tmp.getValue());

		while (true) {
			if (tmp == null) {
				break;
			}
			prev=tmp;
			//System.out.println(tmp.getValue());

			if (i == pos||tmp.getNextRef()==null) {

				System.out.println(prev.getValue());
				refNode=tmp;
				System.out.println(tmp.getValue());
				next=tmp.getNextRef();
				System.out.println(next.getValue());
				

				break;
			}
			
			
			

			tmp = tmp.getNextRef();

			//next = tmp.getNextRef();

			//System.out.println(tmp.getValue());
			//System.out.println(next.getValue());
			i++;
		}
		
		if (refNode != null) {

			if (refNode == head) {
				//System.out.println("Deleted: " + tmp.getValue());
				tmp.setValue(number);
				tmp.setNextRef(refNode);

				head = tmp;
				
			}

			else if (refNode.getNextRef() == null) {
				
				refNode.setNextRef(tmp);
				tmp.setValue(number);
				
				tail=tmp;
				//tail.setNextRef(null);
			
				
				System.out.println("added: " + tmp.getValue());
			} else {
				
				Node<T> tmp1=new Node<T>();
				
			//	tmp1=prev.getNextRef();
				tmp1.setValue(number);
				
			   prev.setNextRef(tmp1);
			   tmp1.setNextRef(next);
			
				System.out.println(prev.getValue());
				
				System.out.println(tmp1.getValue());
				
				System.out.println(next.getValue());
				//System.out.println(next.getNextRef().getValue());
				
				

			}
		}
			
			else {
				System.out.println("unable to enter");
			}
			
		}

	

	public int traverse(T element) {
		Node<T> tmp = head;

		while (true) {
			if (tmp == null) {
				break;
			}

			if (tmp.getValue().equals(element))
				return 0;

			//System.out.println(tmp.getValue());
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

			array[i] =  tmp.getValue().toString();
			i++;

			tmp = tmp.getNextRef();
		}
	}
	public void returnInteger(String[] array, int count) {
		Node<T> tmp = head;

		int i = 0;

		while (true && i < count) {
			if (tmp == null) {
				break;
			}

			array[i] =  tmp.getValue().toString();
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

			System.out.println(tmp.getValue());
			tmp = tmp.getNextRef();
		}
	}
	
	public int returnPos(T element) {
		Node<T> tmp = head;
		

		int i = 0;
		int currentNo;
		System.out.println("Traversing to all nodes..");

		//System.out.println(tmp.getValue());

		while (true) {
			if (tmp == null) {
				break;
			}
			System.out.println(tmp.getValue());
			
			currentNo=(Integer)tmp.getValue();
			if (tmp.getValue().equals(element)||((Integer) element).compareTo(currentNo)<0) {

				// System.out.println((Integer)((Integer) element).compareTo(currentNo));
				return i;

	
			}

			tmp = tmp.getNextRef();

		
			i++;
		}
		return -1;

	}
}

class Node<T>  {

	T value;
	Node<T> nextRef;

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

}



