package com.bridgelabz.Programs;

import java.util.Scanner;

import com.bridgelabz.Utility.Util;

public class DisplayCalender {
	public static void main(String args[]) {
		
	Scanner sc=new Scanner(System.in);
	int month,year;
	System.out.println("enter the month");
	month=Integer.parseInt(sc.nextLine());
	System.out.println("enter the year");
	year=Integer.parseInt(sc.nextLine());
	Util.displayCal(year,month);
	String array[][]=new String[7][7];
	Util.storeArray(array, month, year);
	for (int i=0;i<7;i++)
	{
		for(int j=0;j<7;j++)
		{
			System.out.println(array[i][j]);
		}
	}

}
}