package com.bridgelabz.Programs;

import java.util.Scanner;

import com.bridgelabz.Utility.ListImpl;

public class Stack {
	static ListImpl list=new ListImpl();
	public static void push(String element) {
		list.addAtTop(element);
	}
	public static void pop(String element) {
		if(list.checkEmpty()==1) {
			list.deleteAtFirst();
		}
		else
		{
			list.addAtTop(element);
		}
	}
	public static int  isEmpty() {
		 return list.checkEmpty();
	}
	
	public static void main(String args[]) {
	String str;
		Scanner sc=new Scanner(System.in);
		System.out.println("enter expression");
		str=sc.nextLine();
		String []array=str.split("(?!^)");
		for(int i=0;i<array.length;i++) {

			if(array[i].equals("(")) {
				Stack.push(array[i]);
			}
		   if(array[i].equals(")")) {
			   Stack.pop(array[i]);
			   
		   }
			
		   
			}
		
			if(isEmpty()==0)
			{
				System.out.println("expression is balanced");
			}
			else {
				System.out.println("expression isnot balanced");
			
		}
		
	}
}
