package com.bridgelabz.Programs;



public class Queue<T> {
	LinkedList<T> list=new LinkedList<T>();
	
	public void enqueue(T element) {
		list.add(element);
	}
	public void enqueueDistinct(T element) {
		if(list.traverse(element)!=0)
		list.add(element);
		else
			return;
	}
	
	public void enqueueSort(T element) {
			int index;
			
				index = list.returnPos(element);

               if(index!=-1)
				list.insertAt(element, index);
               else
            	   list.add(element);
				

			

			}
	
	public   T dequeue() {
		return(list.deleteFirst());
	}
	public T removeRear() {
		//System.out.println(list.deleteLast1());
		return(list.deleteLast());
	}
	public void display() {
		list.view();
	}
	public int size() {
		return(list.size());
	}
	
}
