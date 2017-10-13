package com.bridgelabz.Programs;

import java.util.Scanner;

import com.bridgelabz.Utility.SinglyLinkedListImpl;

public class Stack<T> {
	 SinglyLinkedListImpl<T> list=new SinglyLinkedListImpl<>();
	public  void push(T element) {
		list.addFirst(element);
	}
	public T pop() {
		if(list.checkEmpty()==1) {
			return(list.deleteFirst());
		}
		else {
			return null;
		}
		
	}
	public  int  isEmpty() {
		 return list.checkEmpty();
	}
	public void pushDistinct(T element) {
		if(list.traverse(element)!=0) {
			list.addFirst(element);
		}
		else {
			return;
		}
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
			   expression.pop();
			   
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
