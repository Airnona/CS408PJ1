
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
						intersectList = checker1;
						intersectPointer = intersectList;
					}
					else if(!(contains(checker1.getValue(), intersectList))) {
						intersectPointer.setChild(checker1);
						intersectPointer = intersectPointer.getChild();
					}
//					holderList.setChild(checker1);
					break;
				}
				checker2 = checker2.getChild();
			}
			checker1 = checker1.getChild();
		}
		
		// -------------------------- Printing array --------------------------
		if(intersectList.getValue() == 0) {
			System.out.println("The intersected List is empty.");
			return;
		}
		
		System.out.print("The intersected array is: \n[");
		if(intersectList.getChild() == null)
			System.out.println("]");
		else {
			while(true) {
				if(intersectList.getChild() != null)
					System.out.print(intersectList.getValue() + ", ");
				else {
					System.out.print(intersectList.getValue() + "]\n");
					break;
				}
				intersectList = intersectList.getChild();
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
			unionList = checker1;
			unionPointer = unionList;
		}
		checker1 = checker1.getChild();
		while(checker1 != null) {
			if(!(contains(checker1.getValue(), unionList.getChild()))) {
				unionPointer.setChild(checker1);
				unionPointer = unionPointer.getChild();
			}
			checker1 = checker1.getChild();
			System.out.println("in while");
		}
		
		// -------------------------- Adding all of second Linked List to Union List, ignoring repeats -------------------------- 
		checker2 = header2;
		if(checker2 != null) {
			unionList = checker2;
			unionPointer = unionList;
		}
		checker2 = checker2.getChild();
		while(checker2 != null) {
			if(!(contains(checker2.getValue(), unionList.getChild()))) {
				unionPointer.setChild(checker2);
				unionPointer = unionPointer.getChild();
			}
			checker2 = checker2.getChild();
		}
		
		// -------------------------- Printing Array --------------------------
		if(unionList.getChild() == null) {
			System.out.println("The union'd array is empty.");
			return;
		}
		
		System.out.print("The Union'd array is: \n[");
		while(unionList.getChild() != null) {
			unionList = unionList.getChild();
			if(unionList.getChild() == null) {
				System.out.print(unionList.getValue() + "]");
			}
			else {
				System.out.print(unionList.getValue() + ", ");
			}
		}		
	}
//	
//	public void difference(int[] otherArr) {
//		int[] holderArr, differenceArr;
//		int count = 0;
//		
//		// -------------------------- Initialize holder array to default values --------------------------
//		holderArr = new int[otherArr.length + this.arr.length];
//		for(int i = 0; i < holderArr.length; i++) {
//			holderArr[i] = DEFAULT_VALUE;
//		}
//		
//		// -------------------------- Add this.arr values to holder if they aren't in otherArr --------------------------
//		for(int i = 0; i < this.arr.length; i++) {
//			if(!(inContains(this.arr[i], otherArr)) && !(inContains(this.arr[i], holderArr))){
//				holderArr[i] = this.arr[i];
//				count++;
//			}
//		}
//		
//		// -------------------------- Add otherArr values to holder if they aren't in this.arr --------------------------
//		for(int i = 0; i < otherArr.length; i++) {
//			if(!(inContains(otherArr[i], this.arr)) && !(inContains(otherArr[i], holderArr))) {
//				holderArr[this.arr.length + i] = otherArr[i];
//				count++;
//			}
//		}
//		
//		
//		// -------------------------- Create the difference array from values in the holder array --------------------------
//		differenceArr = new int[count];
//		
//		int j = 0;
//		for(int i = 0; i < differenceArr.length; i++) {
//			while(j < holderArr.length) {
//				if(holderArr[j] != DEFAULT_VALUE) {
//					differenceArr[i] = holderArr[j];
//					j++;
//					break;
//				}
//				else
//					j++;
//			}
//		}
//		
//		// -------------------------- Printing Array --------------------------
//		if(differenceArr.length == 0) {
//			System.out.println("The Difference array is empty.");
//			return;
//		}
//		System.out.print("The Difference of the two arrays is: \n[");
//		for(int i = 0; i < differenceArr.length; i++) {
//			if(i < (differenceArr.length - 1))
//				System.out.print(differenceArr[i] + ", ");
//			else
//				System.out.print(differenceArr[i] + "]\n");
//		}
//	}
	
	private boolean contains(int value, Node myList){
		while(myList != null) {
			if(myList.getValue() == value)
				return true;
			myList = myList.getChild();
		}
		return false;
		
	}
}
