package solutions.problem12;

public class MyLinkedList {

	private int size;
	private Node anchor;
	private Node last;

	public MyLinkedList(){
		anchor = new Node(0);
		last = anchor;
		size = 0;
	}


	public int get(int index){
		if(index < 0 || index >= size)
			throw new IndexOutOfBoundsException();
		Node node = anchor;
		for (int i = 0; i < index + 1; i++) {
			node = node.next;
		}
		return node.value;
	}
	public void set(int index, int value){
		if(index < 0 || index >= size)
			throw new IndexOutOfBoundsException();
		Node node = anchor;
		for (int i = 0; i < index + 1; i++) {
			node = node.next;
		}
		node.value = value;
	}

	public void incrementPower(int index){
		if(index < 0 || index >= size)
			throw new IndexOutOfBoundsException();
		Node node = anchor;
		for (int i = 0; i < index + 1; i++) {
			node = node.next;
		}
		node.powerOfValue++;
	}

	public void add(int value){
		/*Node last = anchor;
		while (last.next != null)
			last = last.next;*/
		if(indexOf(value)==-1){
		last.next = new Node(value);
		last = last.next;
		}
		else{
			incrementPower(indexOf(value));
		}
		size++;

	}



	public void addAt(int index, int value){
		if(index < 0 || index >= size)
			throw new IndexOutOfBoundsException();

		Node theOneBefore = anchor;
		for (int i = 0; i < index; i++) {
			theOneBefore = theOneBefore.next;
		}
		Node node = new Node(value);
		node.next = theOneBefore.next;
		theOneBefore.next = node;
		size++;
	}

	public void removeAt(int index){
		if(index < 0 || index >= size)
			throw new IndexOutOfBoundsException();

		Node theOneBefore = anchor;
		for (int i = 0; i < index; i++) {
			theOneBefore = theOneBefore.next;
		}
		theOneBefore.next = theOneBefore.next.next;
		size--;

	}

	public int size(){
		return size;
	}

	public int indexOf(int value){
		Node node = anchor;
		int index = 0;
		while (node.next != null){
			if(node.next.value == value)
				return index;
			index++;
			node = node.next;
		}
		return -1;
	}

	public int[] toArray(){
		int[] arr = new int[size];
		Node temp = anchor;
		for (int i = 0; i < size; i++) {
			temp = temp.next;
			arr[i] = temp.value;
		}
		return arr;
	}

	public int productOfPowers(){
		int result = 1;
		Node temp = anchor;

		for (int i = 0; i < size; i++) {
			temp = temp.next;
			result *= temp.powerOfValue + 1;
		}
		return result;
	}
}

class Node{

	int value;
	int powerOfValue;
	Node next;

	public Node(int theValue){
		value = theValue;
		powerOfValue = 1;
	}



}