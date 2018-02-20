
public class SetLinkedList {
	private int[] arr;
	final int DEFAULT_VALUE = -1001;
	private Node header1, header2;
		
	public SetLinkedList(int[] arr, int[] arr2) {
		// -------------------------- Sets up the first and second linked lists --------------------------
		this.header1 = new Node(arr[0], null, null);
		Node last = this.header1;
		for(int i = 1; i < arr.length; i++) {
			Node node = new Node(arr[i], last, null);
			last = node;
		}
		
		this.header2 = new Node(arr2[0], null, null);
		last = this.header2;
		for(int i = 1; i < arr2.length; i++) {
			Node node = new Node(arr2[i], last, null);
			last = node;
		}
	}
	
	public void intersect() {
		Node intersectList, checker1, checker2, intersectPointer, holderList;
		intersectList = null;
		// -------------------------- Places intersected values into intersectList -------------------------- 
		
		intersectPointer = intersectList;
		checker1 = header1;								//Places checker1 at the beginning of header1 list
		for(int i = 0; i < header1.getLength(); i++) {
			
			checker2 = header2;							//Places checker2 at the beginning of header2 list
			for(int j = 0; j < header2.getLength(); j++) {
				if(checker1.getValue() == checker2.getValue() && !(contains(checker1.getValue(), intersectList))){
//					holderList.setChild(checker1);
					intersectPointer.setChild(checker1);
					intersectPointer = intersectPointer.getChild();
					break;
				}
				checker2 = checker2.getChild();
			}
			checker1 = checker1.getChild();
		}
		
		//-------------------------- Printing array --------------------------
		if(intersectList.getValue() == 0) {
			System.out.println("The intersected List is empty.");
			return;
		}
		
		System.out.print("The intersected array is: \n[" + intersectList.getValue());
		if(intersectList.getChild() == null)
			System.out.println("]");
		while(intersectList.getChild() != null) {
			intersectList = intersectList.getChild();
			if(intersectList.getChild() != null)
				System.out.print(intersectList.getValue() + ", ");
			else
				System.out.print(intersectList.getValue() + "]\n");
		}
	}
	
//	public void union(int[] otherArr) {
//		int[] holder, unionArr;
//		int count = 0;
//		
//		//-------------------------- Initializing holder to default value --------------------------
//		holder = new int[this.arr.length + otherArr.length];
//		for(int i = 0; i < holder.length; i++) {
//			holder[i] = DEFAULT_VALUE;
//		}
//		
//		//-------------------------- Adding default array to holder --------------------------
//		for(int i = 0; i < this.arr.length; i++) {
//			if(!(inContains(this.arr[i], holder))) {
//				holder[i] = this.arr[i];
//				count++;
//			}
//		}
//		
//		// -------------------------- Appending second array to holder, ignoring repeated values --------------------------
//		for(int i = 0; i < otherArr.length; i++) {
//			if(!(inContains(otherArr[i], holder))) {
//				holder[this.arr.length + i] = otherArr[i];
//				count++;
//			}
//		}
//
//		// -------------------------- Creating Intersect array, ignoring default values in holder --------------------------
//		unionArr = new int[count];
//		int j = 0;
//		for(int i = 0; i < unionArr.length; i++) {
//			while(j < holder.length) {
//				if(holder[j] != DEFAULT_VALUE) {
//					unionArr[i] = holder[j];
//					j++;
//					break;
//				}
//				else
//					j++;
//			}
//		}
//		
//		// -------------------------- Printing Array --------------------------
//		if(unionArr.length == 0) {
//			System.out.println("The union'd array is empty.");
//			return;
//		}
//		System.out.print("The Union'd array is: \n[");
//		for(int i = 0; i < unionArr.length; i++) {
//			if(i < (unionArr.length - 1))
//				System.out.print(unionArr[i] + ", ");
//			else
//				System.out.print(unionArr[i] + "]\n");
//		}
//		
//		
//	}
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
		for(int i = 0; i < myList.getLength(); i++) {
			if(myList.getValue() == value)
				return true;
			myList = myList.getChild();
		}
		return false;
		
	}
}
