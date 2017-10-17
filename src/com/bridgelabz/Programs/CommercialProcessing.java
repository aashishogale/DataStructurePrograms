package com.bridgelabz.Programs;

import java.io.IOException;
import java.util.Scanner;

public class CommercialProcessing {
	public static void main(String args[]) throws IOException {
		StockAccount stock=new StockAccount("/home/bridgeit/Desktop/stockaccount.json");
	char enter='y';
		int choice=0;
		Scanner sc =new Scanner(System.in);
		String symbol,name;
		int number;
		do {
		System.out.println("enter 1 for adding new stock");
		System.out.println("enter 2 for buying  stock");
		System.out.println("enter 3 for  selling stock");
		System.out.println("enter 4 for  viewing list");
		System.out.println("enter 5 for viewing stack transaction");
		System.out.println("enter 6 for queue");
		System.out.println("enter 7 for report");
		System.out.println("enter 8 for removing stock");
		System.out.println("enter 9 for exit");
		System.out.println("enter your option");
		choice=sc.nextInt();
		switch(choice)  {
		case 1:
			stock.getInput();
			break;
		case 2:
			System.out.println("enter your name");
			name=sc.next();
			System.out.println("enter your symbol ");
			symbol=sc.next();
			System.out.println("enter your number ");
			number=sc.nextInt();
			stock.buy(number, symbol, name);
			break;
		case 3:
			System.out.println("enter your name");
			name=sc.next();
			System.out.println("enter your symbol ");
			symbol=sc.next();
			System.out.println("enter your number ");
			number=sc.nextInt();
			stock.sell(number, name, symbol);
			break;
		case 4:
			stock.viewlist();
			break;
		case 5:
			stock.viewStack();
			break;
		case 6:
			stock.viewQueue();
			break;
		case 7:
			stock.printReport();
			break;
		case 8:
			System.out.println("enter your symbol ");
			symbol=sc.nextLine();
			stock.removeStock(symbol);
			break;
		case 9:
			break;
			
			
			
		}
		System.out.println("do you want to continue");
		enter=sc.next().charAt(0);
		
		
		}while(enter!='n');

}
}