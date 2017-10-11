package com.bridgelabz.Programs;

import java.util.Scanner;

import com.bridgelabz.Utility.ListImpl;

public class Palindrome {
	
	static int count;
	static ListImpl list=new ListImpl();
	public  static void enqueue(String letter) {
	
		list.addFirst(letter);
		count++;
		
		}
	public static String dequeue() {
		String str="";
		for(int i=0;i<count;i++) {
		
		str=str+(String)list.deleteAtFirst();
		//System.out.println(str);
		}

		
		return str;
	}
	

	
	
	public static void main(String args[]) {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter the string");
		String original=sc.nextLine();
		
		String []array=original.split("(?!^)");
		String palindrome="";
 for(int i=0;i<array.length;i++) {
	 enqueue(array[i]);
 }
		
		palindrome=dequeue();
		System.out.println(palindrome);
		if(original.equals(palindrome)) {
			System.out.println("it is a palindrome");
			
		}
		else {
			System.out.println("it is not a palindrome");
			
		}
	}
}
