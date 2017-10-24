/***************************************************************************
* Purpose : To create class for checking prime and anagram with stack
*
* @author   Aashish
* @version  1.0
* @since    08-10-2017
****************************************************************************/

package com.bridgelabz.programs;

import com.bridgelabz.utility.Util;

/**
 * @author aashish
 *
 */
public class AnagramStack {
	public static void main(String args[]) {
		int[] array = new int[500];
		Stack<Integer> anastack = new Stack<Integer>();
		for (int i = 0; i < 1000; i++) {

			if (Util.checkPrime(i)) {
				for (int j = i + 1; j < 1000; j++) {
					if (Util.checkPrime(j) && (Util.checkAnagram(i, j))) {

						anastack.pushDistinct(i);
						anastack.pushDistinct(j);

					}

				}

			}
		}

		while (anastack.isEmpty() != 0) {
			System.out.println(anastack.pop());
		}
	}

}
