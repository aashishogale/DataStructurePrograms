package com.bridgelabz.Programs;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import com.bridgelabz.Utility.Util;

public class UnorderedList {
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
		Util.addUnoString(array);
		do {
			System.out.println("enter the word");
			
			name=sc.nextLine();
			count=Util.addList(name);
			//Util.showCurrentList();
			System.out.println("do you want to continue");
			next=sc.nextLine().charAt(0);
			//System.out
			
					
		} while(next!='n');
		Util.showCurrentList();
		String []sarray=new String[count];
		Util.getList(sarray,count);
	
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	

	

}
}
