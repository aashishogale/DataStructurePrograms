package com.bridgelabz.Programs;

import java.util.Scanner;

import com.bridgelabz.Utility.ListImpl;

public class Queue {
	static int totalcash,noofpeople;
	static ListImpl list=new ListImpl<Integer>();
	public static void enqueue(int amount,char action,String person) {
		if(action=='d'){
		totalcash=totalcash+amount;
		list.add(person);
		noofpeople++;
		}
		else	if(action=='w'&&(amount-totalcash)>0)
		{
		 totalcash=totalcash-amount;
		 list.add(person);
		 noofpeople++;
		}
		else {
			System.out.println("insufficient funds");
			
		}
	}
	public static  void dequeue() {
		list.deleteAtFirst();
	}
	public static void main(String args[]) {
		char action;
		String person;
		Scanner sc=new Scanner(System.in);
		int amount;
		
		do
		{
			System.out.println("enter if you want to enque or dequeue");
			action=sc.nextLine().charAt(0);
			if(action=='e') {
				System.out.println("what is youtr name");
				person=sc.nextLine();
				System.out.println(" enter amount");
				amount=Integer.parseInt(sc.nextLine());
				System.out.println("do you want to withdraw or deposit");
				action=sc.nextLine().charAt(0);
				Queue.enqueue(amount, action, person);
				
			}
			else if(action=='d') {
				Queue.dequeue();
				
			}
			else {
				System.out.println("invalid input");
			}
			System.out.println(totalcash);
			System.out.println("do you want to continue");
			action=sc.nextLine().charAt(0);
			
			
		}while(action!='n');
		String []array=new String[noofpeople];
		list.getList(array, noofpeople);
		
	}

}
