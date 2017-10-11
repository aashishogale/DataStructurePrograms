package com.bridgelabz.Utility;

public class SinglyLinkedListImpl<T> {
	Node<T> head;
	Node<T> tail;

	public void add(T element) {

		Node<T> nd = new Node<T>();
		nd.setValue(element);
		System.out.println("Adding: " + element);

		if (head == null) {

			head = nd;
			tail = nd;
		} else {

			tail.setNextRef(nd);

			tail = nd;
		}
	}

	public void addFirst(T element) {

		Node<T> tmp = head;
		Node<T> refNode = new Node<T>();
		refNode.setValue(element);
		refNode.setNextRef(tmp);

		head = refNode;

	}

	public int checkEmpty() {
		Node<T> tmp = head;
		if (tmp == null)
			return 0;
		else
			return 1;
	}

	public T deleteFirst() {

		Node<T> tmp = head;
		Node<T> refNode = new Node<T>();
		

			refNode = tmp;
			tmp = tmp.getNextRef();

			head = tmp;
			System.out.println(refNode.getValue());
			return refNode.getValue();

		
	

	}
	
	

	public T deleteLast() {
		Node<T> refNode = new Node<T>();
		Node<T> tmp1 = new Node<T>();
		refNode = tail;
		tmp1.setNextRef(null);
		tail = tmp1;
		System.out.println(refNode.getValue());
		return  refNode.getValue();

	}

	public T deleteElement(T element) {
		Node<T> tmp = head;
		Node<T> refNode = null;
		Node<T> next = null;
		Node<T> prev = null;

		while (true) {
			if (tmp == null) {

				break;
			}

			if (element.equals(tmp.getValue())&&tmp!=head) {

				refNode = tmp;
				
				//next = tmp.getNextRef();

				break;
			}

			prev = tmp;

			tmp = tmp.getNextRef();

		

		}

		if (refNode != null) {

			if (refNode == head) {

				tmp = tmp.getNextRef();

				head = tmp;
				return  refNode.getValue();
			}

			else if (refNode.getNextRef() == null) {

				Node<T> tmp1 = new Node<T>();
				tmp1 = prev;
				tmp1.setNextRef(null);
				tail = tmp1;
				return  prev.getValue();
			} else {
				next = tmp.getNextRef();
				prev.setNextRef(next);
				return  tmp.getValue();

			}
		}

		else {
			return null;
		}
		

	}

	public void insertAt(T number, int pos) {
		Node<T> tmp = head;
		Node<T> refNode = null;
		Node<T> prev = null;
		Node<T> next = null;

		int i = 0;

		while (true) {
			
			if (pos == 0) {
				addFirst(number);
				break;

			}

			prev = tmp;

			if (i == pos - 1 || tmp.getNextRef() == null) {

				refNode = tmp;

				next = tmp.getNextRef();

				break;
			}

			tmp = tmp.getNextRef();

			i++;
		}

		if (refNode != null) {

			if (next == null) {
				Node<T> tmp1 = new Node<T>();

				tmp1.setValue(number);
				refNode.setNextRef(tmp1);
				tmp1.setNextRef(null);

				tail = tmp1;

				System.out.println("added: " + tmp1.getValue());
			} else {

				Node<T> tmp1 = new Node<T>();

				tmp1.setValue(number);

				prev.setNextRef(tmp1);
				tmp1.setNextRef(next);

				System.out.println(prev.getValue());

				System.out.println(tmp1.getValue());

				System.out.println(next.getValue());

			}
		}

		else {
			return;
		}

	}

	public int traverse(T element) {
		Node<T> tmp = head;
		int i = 0;
		int flag = 0;

		while (true) {
			if (tmp == null) {
				flag = 1;
				break;

			}

			if (tmp.getValue().equals(element))
				return 0;

			tmp = tmp.getNextRef();
		}
		if (flag == 1) {
			return 1;
		}

		return -1;
	}

	public void returnElement(String[] array, int count) {
		Node<T> tmp = head;

		int i = 0;

		while (true && i < count) {
			if (tmp == null) {
				break;
			}
			//System.out.println(tmp.getValue());

			array[i] = tmp.getValue().toString();
			i++;

			tmp = tmp.getNextRef();
		}
	}
public T returnItem(int pos) {
	Node<T> tmp=head;
	int count=0;
	while(true) {
		if(tmp==null) {
			break;
		}
		if(count==pos){
			return tmp.getValue();
		}
	}
	return null;
	
}
	public int returnPos(T element) {
		Node<T> tmp = head;

		int i = 0;
		int flag = 0;
		int currentNo;

		while (true) {
			if (tmp == null) {
				flag = 1;
				break;

			}

			currentNo = (Integer) tmp.getValue();
			if (tmp.getValue().equals(element) || ((Integer) element).compareTo(currentNo) < 0) {
				return i;

			}

			tmp = tmp.getNextRef();

			i++;
		}
		if (flag == 1) {
			return 0;
		}
		return -1;

	}

	public int size() {
		// TODO Auto-generated method stub
		
		Node<T> tmp=head;
		int count =0;
		while(true)
			if(tmp==null)
			{
				return 0;
			}
			else {
				return count;
			}
	}
}

class Node<T> {

	T value;
	Node<T> nextRef;

	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}

	public Node<T> getNextRef() {
		return nextRef;
	}

	public void setNextRef(Node<T> ref) {
		this.nextRef = ref;
	}

}


