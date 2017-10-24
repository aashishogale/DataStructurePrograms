/***************************************************************************
* Purpose : To create and implement queue 
*
* @author   Aashish
* @version  1.0
* @since    08-10-2017
****************************************************************************/

package com.bridgelabz.programs;

import com.bridgelabz.utility.SinglyLinkedListImpl;

/**
 * @author Aashish
 *
 */

public class Queue<T> {

	public SinglyLinkedListImpl<T> list = new SinglyLinkedListImpl<>();

	public void dequeueElement(T element) {
		list.deleteElement(element);
	}

	/**
	 * purpose:enqueue the element
	 * 
	 * @param element
	 * @return
	 */
	public void enqueue(T element) {
		list.add(element);
	}

	/**
	 * purpose:enqueue distinct element
	 * 
	 * @param element
	 * @return
	 */
	public void enqueueDistinct(T element) {
		if (list.traverse(element) != 0)
			list.add(element);
		else
			return;
	}

	/**
	 * purpose:dequeue the queue
	 * 
	 * @param
	 * @return element
	 */
	public T dequeue() {
		return (list.deleteFirst());
	}

	/**
	 * purpose:remove the rear element
	 * 
	 * @param
	 * @return element
	 */
	public T removeRear() {

		return (list.deleteLast());
	}

	/**
	 * purpose:display the queue
	 * 
	 * @param
	 * @return
	 */
	public void display() {
		list.view();
	}

	/**
	 * purpose:give the size of the queue
	 * 
	 * @param
	 * @return size;
	 */
	public int size() {
		return (list.size());
	}

}
