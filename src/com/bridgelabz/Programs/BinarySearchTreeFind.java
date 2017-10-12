package com.bridgelabz.Programs;

import java.util.Scanner;
import com.bridgelabz.Utility.Util;

public class BinarySearchTreeFind {
	public static void main (String args[]) {
		Scanner sc =new Scanner(System.in);
		System.out.println("enter number");
		int number=Integer.parseInt(sc.nextLine());
		long result=Util.possibleCombinations(number);
		System.out.println(result);
		
	}
	

}
