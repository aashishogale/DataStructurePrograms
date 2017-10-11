package com.bridgelabz.Programs;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import com.bridgelabz.Utility.ListImpl;

public class UnorderedList {
	static ListImpl list=new ListImpl();
	public static void main(String args[]) {
		
	String str,name;
	char next;
	int count=1;
	
	
	Scanner sc= new Scanner(System.in);
	

	BufferedReader breader;
	try {
		breader = new BufferedReader(
				new FileReader("/home/bridgeit" + "/Desktop/test.txt"));
		str = breader.readLine();
		String[] array = str.split(",");
		list.addUnoString(array);
		do {
			System.out.println("enter the word");
			
			name=sc.nextLine();
			count=list.addList(name);
			//list.showCurrentList();
			System.out.println("do you want to continue");
			next=sc.nextLine().charAt(0);
			//System.out
			
					
		} while(next!='n');
		//list.showCurrentList();
		String []sarray=new String[count];
		list.getList(sarray,count);
		sc.close();
	
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	

	

}
}
