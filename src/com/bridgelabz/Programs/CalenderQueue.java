package com.bridgelabz.Programs;

import java.util.Arrays;
import java.util.Scanner;

import com.bridgelabz.Utility.SinglyLinkedListImpl;
import com.bridgelabz.Utility.Util;

public class CalenderQueue {
	public static void main(String args[]) {
		CalenderQueue cqueue=new CalenderQueue();
		Scanner scanner=new Scanner(System.in);
		String daysOfWeek[]={ "S", "M", "T", "W", "Th", "F", "Sa" };
		Queue<Queue<String>> weekQueue=new Queue<Queue<String>>();
		Stack weekStack=new Stack<>();
		Stack monthStack=new Stack<>();
		
		Queue<String> week;
		System.out.println("Enter month and year");
		int month=scanner.nextInt();
		int year=scanner.nextInt();
		String calender[][]=new String[7][7];
		Util.storeArray(calender, month, year);
		
		for(int i=1;i<calender.length;i++){
			week =new Queue<String>();
			for(int j=0;j<calender[i].length;j++){
				//WeekDay day=new WeekDay(daysOfWeek[j],calender[i][j]);
			
				//day.date=calender[i][j];
				//day.day=daysOfWeek[j];
				week.enqueue(calender[i][j]);
			}
			
			weekQueue.enqueue(week);
			weekStack.push(week);
		}
		//System.out.println(day.toString());
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
			Queue<String> week =(Queue) weekQueue.dequeue();
			int weekSize=week.size();
			
			for(int j=0;j<weekSize;j++){
				
				date= week.dequeue();
				//String str=day.date;
				//String adate=str.replaceAll(day.toString(),"");
				//System.out.println(day.toString());
				System.out.print(date+"\t");
			}
			System.out.println();
		
		}
}

	
	


}
