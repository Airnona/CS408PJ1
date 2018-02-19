
public class Node {
	private int value;
	private Node parent, child;
	
	public Node(int value, Node parent, Node child) {
		this.value = value;
		this.parent = parent;
		this.child = child;
		if(this.parent != null)
			this.parent.setChild(this);
	}
	
	public Node getParent() {
		return this.parent;
	}
	public Node getChild() {
		return this.child;
	}
	public int getValue(){
		return this.value;
	}
	public void setParent(Node newNode) {
		this.parent = newNode;
	}
	public void setChild(Node newNode) {
		this.child = newNode;
	}
	public void setValue(int newValue) {
		this.value = newValue;
	}
}
