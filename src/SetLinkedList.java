
public class SetLinkedList {
	private int[] arr;
	final int DEFAULT_VALUE = -1001;
	private Node header1, header2;
		
	public SetLinkedList(int[] arr, int[] arr2) {
		// -------------------------- Sets up the first and second linked lists --------------------------
		if(arr.length > 0)
			this.header1 = new Node(arr[0], null, null);
		else
			this.header1 = null;
		
		Node last = this.header1;
		for(int i = 1; i < arr.length; i++) {
			Node node = new Node(arr[i], last, null);
			last = node;
		}
		
		
		
		if(arr2.length > 0)
			this.header2 = new Node(arr2[0], null, null);
		else
			this.header2 = null;
		
		last = this.header2;
		for(int i = 1; i < arr2.length; i++) {
			Node node = new Node(arr2[i], last, null);
			last = node;
		}
	}
	
	public void intersect() {
		Node intersectList, checker1, checker2, intersectPointer, holderList;
		intersectList = null;
		intersectPointer = null;
		
		// -------------------------- Edge case: if either array is empty -------------------------- 
		if(header1 == null || header2 == null) {
			System.out.println("The intersection set is empty.");
			return;
		}
		
		// -------------------------- Places intersected values into intersectList -------------------------- 
		
		checker1 = header1;								//Places checker1 at the beginning of header1 list
		for(int i = 0; i < header1.getLength(); i++) {
			
			checker2 = header2;							//Places checker2 at the beginning of header2 list
			for(int j = 0; j < header2.getLength(); j++) {
				if(checker1.getValue() == checker2.getValue()){
					if(intersectList == null) {
						intersectList = new Node(checker1.getValue(), null, null);
						intersectPointer = intersectList;
					}
					else if(!(contains(checker1.getValue(), intersectList))) {
						intersectPointer.addNode(checker1);
						intersectPointer = intersectPointer.getChild();
					}
					break;
				}
				checker2 = checker2.getChild();
			}
			checker1 = checker1.getChild();
		}
		
		// -------------------------- Printing array --------------------------
		if(intersectList == null) {
			System.out.println("The intersected array is empty.");
			return;
		}
		
		System.out.print("The intersected array is: \n[" + intersectList.getValue());
		
		if(intersectList.getChild() == null)
			System.out.println("]");
		else
			System.out.print(", ");
		
		while(intersectList.getChild() != null) {
			intersectList = intersectList.getChild();
			if(intersectList.getChild() == null) {
				System.out.print(intersectList.getValue() + "]\n");
			}
			else {
				System.out.print(intersectList.getValue() + ", ");
			}
		}		
		
	}
	
	public void union() {
		Node checker1, checker2, unionList, unionPointer;
		unionList = null;
		unionPointer = unionList;
		
		// -------------------------- Adding all of the first Linked List to Union List, ignoring repeats -------------------------- 
		checker1 = header1;
		if(checker1 != null) {
			unionList = new Node(checker1.getValue(), null, null);
			unionPointer = unionList;
			checker1 = checker1.getChild();
		}
		
		while(checker1 != null) {
			if(!(contains(checker1.getValue(), unionList))) {
				unionPointer.addNode(checker1);
				unionPointer = unionPointer.getChild();
			}
			checker1 = checker1.getChild();
		}
		
		// -------------------------- Adding all of second Linked List to Union List, ignoring repeats -------------------------- 
		checker2 = header2;
		if(checker2 != null) {
			if(unionList == null) {
				unionList = new Node(checker2.getValue(), null, null);
				unionPointer = unionList;
			}
			else {
				if(!(contains(checker2.getValue(), unionList))) {
					unionPointer.addNode(checker2);
					unionPointer = unionPointer.getChild();
			
				}
			}
			checker2 = checker2.getChild();
		}
		
		while(checker2 != null) {
			if(!(contains(checker2.getValue(), unionList))) {
				unionPointer.addNode(checker2);
				unionPointer = unionPointer.getChild();
			}
			checker2 = checker2.getChild();
		}
		
		// -------------------------- Printing Array --------------------------
		if(unionList == null) {
			System.out.println("The union'd array is empty.");
			return;
		}
		
		System.out.print("The Union'd array is: \n[" + unionList.getValue());
		
		if(unionList.getChild() == null)
			System.out.println("]");
		else
			System.out.print(", ");
		
		while(unionList.getChild() != null) {
			unionList = unionList.getChild();
			if(unionList.getChild() == null) {
				System.out.print(unionList.getValue() + "]\n");
			}
			else {
				System.out.print(unionList.getValue() + ", ");
			}
		}		
	}
	
	public void difference() {
		Node difList, difPointer, checker1, checker2;
		difList = null;
		difPointer = null;
		// -------------------------- Add Linked List1's nodes into list if they're not in Linked List 2 --------------------------
		
		checker1 = header1;

		while(checker1 != null) {
			if(!(contains(checker1.getValue(), header2))) {
				if(difList == null) {
					difList = new Node(checker1.getValue(), null, null);
					difPointer = difList;
				}
				else if(!(contains(checker1.getValue(), difList))) {
					difPointer.addNode(checker1);
					difPointer = difPointer.getChild();
				}
			}
			checker1 = checker1.getChild();
		}
		
		
		
		// -------------------------- Add Linked List 2's nodes now. --------------------------
		checker2 = header2;

		while(checker2 != null) {
			if(!(contains(checker2.getValue(), header1))) {
				if(difList == null) {
					difList = new Node(checker2.getValue(), null, null);
					difPointer = difList;
				}
				else if(!(contains(checker2.getValue(), difList))) {
					difPointer.addNode(checker2);
					difPointer = difPointer.getChild();
				}
			}
			checker2 = checker2.getChild();
		}
		
		// -------------------------- Printing List --------------------------
		if(difList == null) {
			System.out.println("The Difference of arrays is empty.");
			return;
		}
		
		System.out.print("The Difference of arrays is: \n[" + difList.getValue());
		
		if(difList.getChild() == null)
			System.out.println("]");
		else
			System.out.print(", ");
		
		while(difList.getChild() != null) {
			difList = difList.getChild();
			if(difList.getChild() == null) {
				System.out.print(difList.getValue() + "]\n");
			}
			else {
				System.out.print(difList.getValue() + ", ");
			}
		}	
		
		
	}
	
	private boolean contains(int value, Node myList){
		while(myList != null) {
			if(myList.getValue() == value)
				return true;
			myList = myList.getChild();
		}
		return false;
		
	}
}
