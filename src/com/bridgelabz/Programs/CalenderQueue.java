package com.bridgelabz.Programs;

import java.util.Scanner;

import com.bridgelabz.Utility.SinglyLinkedListImpl;
import com.bridgelabz.Utility.Util;

public class CalenderQueue {
	public static void main(String args[]) {
		CalenderQueue cqueue=new CalenderQueue();
		Scanner scanner=new Scanner(System.in);
		String daysOfWeek[]={ "S", "M", "T", "W", "Th", "F", "Sa" };
		Queue weekQueue=new Queue<>();
		Stack weekStack=new Stack<>();
		Stack monthStack=new Stack<>();
		
		Queue week;
		System.out.println("Enter month and year");
		int month=scanner.nextInt();
		int year=scanner.nextInt();
		String calender[][]=new String[7][7];
		Util.storeArray(calender, month, year);
		for(int i=1;i<calender.length;i++){
			week =new Queue<WeekDay>();
			for(int j=0;j<calender[i].length;j++){
				WeekDay day=new WeekDay();
				day.date=calender[i][j];
				day.day=daysOfWeek[j];
				week.enqueue(day);
			}
			weekQueue.enqueue(week);
			weekStack.push(week);
		}
		monthStack.push(weekQueue);
		cqueue.displayQueue(weekQueue);
	}

	private  void displayQueue(Queue weekQueue) {
		String daysOfWeek[]={ "S", "M", "T", "W", "Th", "F", "Sa" };
		for(int i=0;i<daysOfWeek.length;i++){
			System.out.print(daysOfWeek[i]+"\t");
		}
		String date;
		System.out.println();
		int weekQueueSize=weekQueue.size();
		for(int i=0;i<weekQueueSize;i++){
			Queue week =(Queue) weekQueue.dequeue();
			int weekSize=week.size();
			for(int j=0;j<weekSize;j++){
				WeekDay day=(WeekDay) week.dequeue();
				date=day.toString();
				System.out.print(date+"\t");
			}
			System.out.println();
		
		}
}

	
	


}
