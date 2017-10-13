package com.bridgelabz.Programs;

import java.util.Scanner;

import com.bridgelabz.Utility.ListImpl;
import com.bridgelabz.Utility.SinglyLinkedListImpl;

public class Queue<T> {
	static int totalcash,noofpeople;
	 SinglyLinkedListImpl<T> list=new SinglyLinkedListImpl<>();
	public  void addPerson(int amount,char action,T person) {
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
	public void enqueue(T element) {
		list.add(element);
	}
	public void enqueueDistinct(T element) {
		if(list.traverse(element)!=0)
		list.add(element);
		else
			return;
	}
	public   T dequeue() {
		return(list.deleteFirst());
	}
	public T removeRear() {
		//System.out.println(list.deleteLast1());
		return(list.deleteLast());
	}
	public void display() {
		list.view();
	}
	public int size() {
		return(list.size());
	}
	
	public static void main(String args[]) {
		char action;
		String person;
		Scanner sc=new Scanner(System.in);
		int amount;
		Queue<String> queue=new Queue<String>();
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
				queue.addPerson(amount, action, person);
				
			}
			else if(action=='d') {
				queue.dequeue();
				
			}
			else {
				System.out.println("invalid input");
			}
			System.out.println(totalcash);
			System.out.println("do you want to continue");
			action=sc.nextLine().charAt(0);
			
			
		}while(action!='n');
		String []array=new String[noofpeople];
	queue.display();
		
	}

}
