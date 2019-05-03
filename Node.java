
public class Node {
	
	private String value;
	private Node next;
	
	public Node(String x){
		value = x;
		next = null;
	}
	
	public void setNext(Node n){
		next = n;
	}
	
	public Node getNext(){
		return next;
	}
	
	public String getValue(){
		return value;
	}

}