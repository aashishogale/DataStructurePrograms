package com.bridgelabz.Programs;

import java.util.Scanner;

import com.bridgelabz.Utility.ListImpl;

public class Palindrome {
	
	static int count;
	Queue<String> queue= new Queue<>();
	public   void add(String letter) {
	
		queue.enqueue(letter);
		
		count++;
		System.out.println(count);
		
		}
	public  String get() {
		String str="";
		for(int i=0;i<count;i++) {
		
		str=str+(String)queue.removeRear();
		
		}

		
		return str;
	}
	public int size() {
		return queue.size();
	}

	
	
	public static void main(String args[]) {
		Palindrome check=new Palindrome();
		Scanner sc=new Scanner(System.in);
		System.out.println("enter the string");
		String original=sc.nextLine();
		
		String []array=original.split("(?!^)");
		String palindrome="";
 for(int i=0;i<array.length;i++) {
	 check.add(array[i]);
 }
		//System.out.println("queue size"+check.size());
		palindrome=check.get();
		System.out.println(palindrome);
		if(original.equals(palindrome)) {
			System.out.println("it is a palindrome");
			
		}
		else {
			System.out.println("it is not a palindrome");
			
		}
	}
}
