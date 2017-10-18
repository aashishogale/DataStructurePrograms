/***************************************************************************
* Purpose : To create and implement queue foe banking operation
*
* @author   Aashish
* @version  1.0
* @since    08-10-2017
****************************************************************************/
package com.bridgelabz.Programs;

import java.util.Scanner;

/**
 * @author aashish
 *
 */
public class BankQueue {
	Queue<String> queue=new Queue<>();
	static int totalcash;
	static int noofpeople;
	/**
	 * purpose:add the person to the queue
	 * 
	 * @param amount,action,person
	 * @return
	 */

	public  void addPerson(int amount, char action, String person) {
		if (action == 'd') {
			totalcash = totalcash + amount;
			queue.enqueue(person);
			noofpeople++;
		} else if (action == 'w' && (totalcash-amount) > 0) {
			totalcash = totalcash - amount;
		queue.dequeueElement(person);
			noofpeople--;
		} else if(totalcash>amount){
			System.out.println("insufficient funds");

		}
	}
public void display()
{
	queue.display();
}

	public static void main(String[] args) {
		char action;
		String person;
		Scanner scanner = new Scanner(System.in);
		int amount;
	
		BankQueue bqueue=new BankQueue();
		do {
		
				System.out.println("what is youtr name");
				person = scanner.nextLine();
				System.out.println(" enter amount");
				amount = Integer.parseInt(scanner.nextLine());
				System.out.println("do you want to withdraw or deposit");
				action = scanner.nextLine().charAt(0);
				bqueue.addPerson(amount, action, person);

			bqueue.display();

			
			System.out.println("current cash"+totalcash);
			
			System.out.println("do you want to continue");
			action = scanner.nextLine().charAt(0);

		} while (action != 'n');
		
		scanner.close();

		// TODO Auto-generated method stub
		

}
}