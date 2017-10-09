package com.bridgelabz.Programs;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import com.bridgelabz.Utility.Util;

public class OrderedList {
		public static void main(String args[]) {
			String str;
			int number;
			char next;
			int count=1;
			
			
			
			Scanner sc= new Scanner(System.in);
			

			BufferedReader breader;
			try {
				breader = new BufferedReader(
						new FileReader("/home/bridgeit" + "/Desktop/orderedtest.txt"));
				str = breader.readLine();
				String[] array = str.split(",");
				int []narray=new int[array.length];
				for(int i=0;i<array.length;i++) {
					narray[i]=Integer.parseInt(array[i]);
				
				}
				Util.addOrderedInt(narray);
				do {
					System.out.println("enter the number");
					
					number=Integer.parseInt(sc.nextLine());
					count=Util.addOrderedList(number);
					//Util.showCurrentList();
					System.out.println("do you want to continue");
					next=sc.nextLine().charAt(0);
					//System.out
					
							
				} while(next!='n');
				//Util.showCurrentOrderedList();
				String []sarray=new String[count];
				Util.getOrderedList(sarray,count);
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
