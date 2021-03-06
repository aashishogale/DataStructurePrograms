/***************************************************************************
* Purpose : To put  prime and anagram number in queue
*
* @author   Aashish
* @version  1.0
* @since    08-10-2017
****************************************************************************/

package com.bridgelabz.programs;

import com.bridgelabz.utility.Util;

/**
 * @author Aashish
 *
 */

public class PrimeQueue {
	public static void main(String args[]) {
		 Queue<Integer> queue = new Queue<Integer>();
		for (int i = 0; i < 1000; i++) {

			for (int j = i + 1; j < 1000; j++) {
				if (Util.checkPrime(i) && Util.checkPrime(j) && Util.checkAnagram(i, j)) {

					queue.enqueueDistinct(i);
					queue.enqueueDistinct(j);

				}

			}

		}

		queue.display();
	}

}
