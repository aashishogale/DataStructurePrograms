package com.bridgelabz.Programs;

import java.io.IOException;
import java.util.Scanner;

import com.bridgelabz.Utility.Util;

public class AddressBook {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String name;
		char enter;
do {
	
	Util.createAddressBook();
	System.out.println("enter the address book name");
	name=sc.next();	
	
		Util.editAddressBook(name);
	
	System.out.println("do you want to continue");
	enter=sc.next().charAt(0);
	
}while(enter!='n');

	}

}
