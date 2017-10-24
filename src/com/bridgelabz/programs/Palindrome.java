/***************************************************************************
* Purpose : To check for palindrome with queue
*
* @author   Aashish
* @version  1.0
* @since    08-10-2017
****************************************************************************/

package com.bridgelabz.programs;

import java.util.Scanner;


/**
 * @author Aashish
 *
 */

public class Palindrome {

	public static int count;
	public Queue<String> queue = new Queue<>();

	public void add(String letter) {

		queue.enqueue(letter);

		count++;
		System.out.println(count);

	}

	public String get() {
		String checkString = "";
		for (int i = 0; i < count; i++) {

			checkString = checkString + (String) queue.removeRear();

		}

		return checkString;
	}

	public int size() {
		return queue.size();
	}

	public static void main(String args[]) {
		Palindrome check = new Palindrome();
		Scanner scanner = new Scanner(System.in);
		System.out.println("enter the string");
		String original = scanner.nextLine();

		String[] array = original.split("(?!^)");
		String palindrome = "";
		for (int i = 0; i < array.length; i++) {
			check.add(array[i]);
		}

		palindrome = check.get();
		System.out.println(palindrome);
		if (original.equals(palindrome)) {
			System.out.println("it is a palindrome");

		} else {
			System.out.println("it is not a palindrome");

		}
	}
}
