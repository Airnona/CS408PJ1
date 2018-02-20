
public class Node {
	private int value, length = 1;
	private Node parent, child, topParent;
	
	public Node(int value, Node parent, Node child) {
		this.value = value;
		this.parent = parent;
		this.child = child;
		this.topParent = this;
		if(this.parent != null) {
			this.parent.setChild(this);
			this.topParent = this.parent;
			length++;
		}
		while(this.topParent.getParent() != null) {
			length++;
			this.topParent = this.topParent.getParent();
			if(this.topParent.parent == null)
				break;
		}
		if(this.parent != null)
			this.topParent.setLength(length);
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
	public int getLength() {
		return this.length;
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
	public void setLength(int newLength) {
		this.length = newLength;
	}
}
