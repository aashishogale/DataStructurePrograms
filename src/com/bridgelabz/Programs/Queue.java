/***************************************************************************
* Purpose : To create and implement queue foe banking operation
*
* @author   Aashish
* @version  1.0
* @since    08-10-2017
****************************************************************************/

package com.bridgelabz.Programs;

import java.util.Scanner;

import com.bridgelabz.Utility.ListImpl;
import com.bridgelabz.Utility.SinglyLinkedListImpl;

public class Queue<T> {
	static int totalcash, noofpeople;
	SinglyLinkedListImpl<T> list = new SinglyLinkedListImpl<>();

	/**
	 * purpose:add the person to the queue
	 * 
	 * @param amount,action,person
	 * @return
	 */

	public void addPerson(int amount, char action, T person) {
		if (action == 'd') {
			totalcash = totalcash + amount;
			list.add(person);
			noofpeople++;
		} else if (action == 'w' && (amount - totalcash) > 0) {
			totalcash = totalcash - amount;
			list.add(person);
			noofpeople++;
		} else {
			System.out.println("insufficient funds");

		}
	}

	/**
	 * purpose:enqueue the element
	 * 
	 * @param element
	 * @return
	 */
	public void enqueue(T element) {
		list.add(element);
	}

	/**
	 * purpose:enqueue distinct element
	 * 
	 * @param element
	 * @return
	 */
	public void enqueueDistinct(T element) {
		if (list.traverse(element) != 0)
			list.add(element);
		else
			return;
	}

	/**
	 * purpose:dequeue the element
	 * 
	 * @param
	 * @return element
	 */
	public T dequeue() {
		return (list.deleteFirst());
	}

	/**
	 * purpose:remove the rear element
	 * 
	 * @param
	 * @return element
	 */
	public T removeRear() {
		// System.out.println(list.deleteLast1());
		return (list.deleteLast());
	}

	/**
	 * purpose:display the queue
	 * 
	 * @param
	 * @return
	 */
	public void display() {
		list.view();
	}

	/**
	 * purpose:give the size of the queue
	 * 
	 * @param
	 * @return size;
	 */
	public int size() {
		return (list.size());
	}

	public static void main(String args[]) {
		char action;
		String person;
		Scanner scanner = new Scanner(System.in);
		int amount;
		Queue<String> queue = new Queue<String>();
		do {
			System.out.println("enter if you want to enque or dequeue");
			action = scanner.nextLine().charAt(0);
			if (action == 'e') {
				System.out.println("what is youtr name");
				person = scanner.nextLine();
				System.out.println(" enter amount");
				amount = Integer.parseInt(scanner.nextLine());
				System.out.println("do you want to withdraw or deposit");
				action = scanner.nextLine().charAt(0);
				queue.addPerson(amount, action, person);

			} else if (action == 'd') {
				queue.dequeue();

			} else {
				System.out.println("invalid input");
			}
			System.out.println(totalcash);
			System.out.println("do you want to continue");
			action = scanner.nextLine().charAt(0);

		} while (action != 'n');
		String[] array = new String[noofpeople];
		queue.display();

	}

}
