/***************************************************************************
* Purpose : To create class for finding all binary search tree combinations
*
* @author   Aashish
* @version  1.0
* @since    08-10-2017
****************************************************************************/

package com.bridgelabz.programs;

import java.util.Scanner;

import com.bridgelabz.utility.Util;

/**
 * @author aashish
 *
 */
public class BinarySearchTreeFind {
	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("enter number");
		int number = Integer.parseInt(scanner.nextLine());
		long result = Util.possibleCombinations(number);
		System.out.println(result);
		scanner.close();
	}

}
