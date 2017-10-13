package com.bridgelabz.Programs;

import com.bridgelabz.Utility.Util;

public class PrimeQueue {
	public static void main(String args[]) {
		Queue<Integer> queue =new Queue<Integer>();
		for (int i = 0; i < 1000; i++) {

			if (Util.checkPrime(i)) {
				for (int j = i + 1; j < 1000; j++) {
					if (Util.checkPrime(j)) {
						if (Util.checkAnagram(i, j)) {
							//System.out.print(i+" ");
							queue.enqueueDistinct(i);
							 queue.enqueueDistinct(j);
							
						}

					}

				}
			}
		}
		
		queue.display();
	}
		
	}


