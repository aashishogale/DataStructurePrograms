/***************************************************************************
* Purpose : To create class for building calender with queue
*
* @author   Aashish
* @version  1.0
* @since    08-10-2017
****************************************************************************/

package com.bridgelabz.Programs;

import java.util.Scanner;

import com.bridgelabz.Utility.Util;


/**
 * @author Aashish
 *
 */
public class CalenderQueue {
	public static void main(String args[]) {
		CalenderQueue cqueue = new CalenderQueue();
		Scanner scanner = new Scanner(System.in);
		
		Queue<Queue<String>> weekQueue = new Queue<Queue<String>>();
		Stack weekStack = new Stack<>();
		Stack monthStack = new Stack<>();

		Queue<String> week;
		System.out.println("Enter month and year");
		int month = scanner.nextInt();
		int year = scanner.nextInt();
		String calender[][] = new String[7][7];
		Util.storeArray(calender, month, year);

		for (int i = 1; i < calender.length; i++) {
			week = new Queue<String>();
			for (int j = 0; j < calender[i].length; j++) {

				week.enqueue(calender[i][j]);
			}

			weekQueue.enqueue(week);
			weekStack.push(week);
		}

		monthStack.push(weekQueue);
		cqueue.displayQueue(weekQueue);
	}

	private void displayQueue(Queue weekQueue) {
		String daysOfWeek[] = { "S", "M", "T", "W", "Th", "F", "Sa" };
		for (int i = 0; i < daysOfWeek.length; i++) {
			System.out.print(daysOfWeek[i] + "\t");
		}
		String date;
		System.out.println();
		int weekQueueSize = weekQueue.size();
		for (int i = 0; i < weekQueueSize; i++) {
			Queue<String> week = (Queue) weekQueue.dequeue();
			int weekSize = week.size();

			for (int j = 0; j < weekSize; j++) {

				date = week.dequeue();
				
				System.out.print(date + "\t");
			}
			System.out.println();

		}
	}

}
