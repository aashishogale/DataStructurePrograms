/***************************************************************************
* Purpose : To create class for displaying calender
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
public class DisplayCalender {
	public static void main(String args[]) {

		Scanner scanner = new Scanner(System.in);
		int month, year;
		System.out.println("enter the month");
		month = Integer.parseInt(scanner.nextLine());
		System.out.println("enter the year");
		year = Integer.parseInt(scanner.nextLine());
		Util.displayCal(year, month);
		String array[][] = new String[7][7];
		Util.storeArray(array, month, year);
		for (int i = 0; i < 7; i++) {
			for (int j = 0; j < 7; j++) {
				System.out.println(array[i][j]);
			}
		}

	}
}