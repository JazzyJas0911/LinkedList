
public class LinkList {
	
	private Node head;
	private Node isNew;
	
	public LinkList(){
		head = null;
	}
	
	public void inOrder(String s){
		Node temp = new Node(s);
		isNew = temp;
		if(head == null) {
			head = temp;
		}
		else if (temp.getValue().compareTo(head.getValue()) < 0){
			temp.setNext(head);
			head = temp;
		}
		else{
			Node previous = head;
			Node current = head;
			while ((temp.getValue().compareTo(current.getValue()) > 0) && (current.getNext() != null)){
				previous = current;
				current = current.getNext();
			}
			if((temp.getValue().compareTo(current.getValue()) > 0) && (current.getNext() == null))
				current.setNext(temp);
			else{
				previous.setNext(temp);
				temp.setNext(current);
			}
		}
	}
	
	public void addDisplay(){
		int counter = 0;
		Node temp = head;
		while (temp != null){
			if (temp == isNew){
				System.out.print("*");
			}
			System.out.print(temp.getValue() + "\t");
			counter++;
			temp = temp.getNext();
			if (counter > 11){
				counter = 0;
				System.out.println();
			}	
		}
		System.out.println();
	}
	
	public void display(){
		int counter = 0;
		Node temp = head;
		while (temp != null){
			System.out.print(temp.getValue() + "\t");
			counter++;
			temp = temp.getNext();
			if (counter > 11){
				counter = 0;
				System.out.println();
			}	
		}
		System.out.println();
	}
	
	public void delete(String deleteWord){
		Node temp = head;
		boolean found = false;
		if (temp == null)
			System.out.println("You have no words in your Linked List.");
		else{ 
			while (temp != null && !found){
				if (temp.getValue().compareTo(deleteWord) == 0)
					found = true;
				else{
					temp = temp.getNext();
					found = false;
				}	
			}
			if (found == true){
				temp = head;
				while (temp != null){
					if (temp.getNext().getValue().compareTo(deleteWord) == 0){
						temp.setNext(temp.getNext().getNext());
						return;
					}
					else if (head.getValue().compareTo(deleteWord) == 0){
						head = head.getNext();
						return;
					}
					else
						temp = temp.getNext();
				}
			}
			else
				System.out.println("Error. You cannot delete " + deleteWord + " because it is not a word in your Linked List.\n");
		}
	}
		
}
