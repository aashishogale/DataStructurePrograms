/***************************************************************************
* Purpose : To create  stack and implement stack for checking balanced equation
*
* @author   Aashish
* @version  1.0
* @since    08-10-2017
****************************************************************************/

package com.bridgelabz.programs;

import java.util.Scanner;

import com.bridgelabz.utility.SinglyLinkedListImpl;

/**
 * @author Aashish
 *
 */
public class Stack<T> {
	public SinglyLinkedListImpl<T> list = new SinglyLinkedListImpl<>();

	/**
	 * purpose:push the element
	 * 
	 * @param
	 * @return element
	 */
	public void push(T element) {
		list.addFirst(element);
	}

	/**
	 * purpose:pop the element
	 * 
	 * @param
	 * @return element
	 */
	public T pop() {
		if (list.checkEmpty() == 1) {
			return (list.deleteFirst());
		} else {
			return null;
		}

	}

	/**
	 * purpose:check if stack is empty
	 * 
	 * @param
	 * @return isEmpty
	 */

	public int isEmpty() {
		return list.checkEmpty();
	}

	/**
	 * purpose:push the distinct element
	 * 
	 * @param
	 * @return
	 */
	public void pushDistinct(T element) {
		if (list.traverse(element) != 0) {
			list.addFirst(element);
		} else {
			return;
		}
	}

	public static void main(String args[]) {
		String str;
		Scanner scanner = new Scanner(System.in);
		Stack<String> expression = new Stack<String>();
		System.out.println("enter expression");
		str = scanner.nextLine();
		String[] array = str.split("(?!^)");
		for (int i = 0; i < array.length; i++) {

			if (array[i].equals("(")) {
				expression.push(array[i]);
			}
			if (array[i].equals(")")) {
				expression.pop();

			}

		}

		if (expression.isEmpty() == 0) {
			System.out.println("expression is balanced");
		} else {
			System.out.println("expression isnot balanced");

		}

	}
}
