package com.bridgelabz.Programs;

import java.util.Scanner;

import com.bridgelabz.Utility.SinglyLinkedListImpl;

public class Stack<T> {
	 SinglyLinkedListImpl<T> list=new SinglyLinkedListImpl<>();
	public  void push(T element) {
		list.addFirst(element);
	}
	public void pop(T element) {
		if(list.checkEmpty()==1) {
			list.deleteFirst();
		}
		else
		{
			list.addFirst(element);
		}
	}
	public  int  isEmpty() {
		 return list.checkEmpty();
	}
	
	public static void main(String args[]) {
	String str;
		Scanner sc=new Scanner(System.in);
		Stack<String> expression=new Stack<String>();
		System.out.println("enter expression");
		str=sc.nextLine();
		String []array=str.split("(?!^)");
		for(int i=0;i<array.length;i++) {

			if(array[i].equals("(")) {
				expression.push(array[i]);
			}
		   if(array[i].equals(")")) {
			   expression.pop(array[i]);
			   
		   }
			
		   
			}
		
			if(expression.isEmpty()==0)
			{
				System.out.println("expression is balanced");
			}
			else {
				System.out.println("expression isnot balanced");
			
		}
		
	}
}
