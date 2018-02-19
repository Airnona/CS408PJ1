
public class SetLinkedList {
	private int[] arr;
	final int DEFAULT_VALUE = -1001;
	Node header, header2;
		
	public SetLinkedList(int[] arr, int[] arr2) {
		// -------------------------- Sets up the first and second linked lists --------------------------
		this.header = new Node(arr[0], null, null);
		Node last = this.header;
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
		int[] smaller, bigger, intersectArr, containsArr;
		int countIntersect = 0;
		
		// -------------------------- Finding which array is bigger and smaller, using references to access these from now on
		if(this.arr.length < otherArr.length) {
			smaller = this.arr;
			bigger = otherArr;
		}
		else {
			smaller = otherArr;
			bigger = this.arr;
		}
		
		// -------------------------- Defaulting Contains array to a certain value to find actual useful values later
		containsArr = new int[smaller.length];
		for(int i = 0; i < containsArr.length; i++) {
			containsArr[i] = DEFAULT_VALUE;
		}
		
		// -------------------------- Places intersected values into containsArr once, however it still will likely have default values within
		for(int i = 0; i < smaller.length; i++) {
			for(int j = 0; j < bigger.length; j++) {
				if(smaller[i] == bigger[j] && inContains(smaller[i], containsArr) == false) {
					containsArr[i] = smaller[i];
					countIntersect++;
					break;
				}
			}
		}
		
		//-------------------------- Initializing holder array to a size of the amount of union'd items
		intersectArr = new int[countIntersect];
		
		//-------------------------- Setting the values of holderArr to the values of union'd items, contains no excess default value
		int j = 0;
		for(int i = 0; i < intersectArr.length; i++) {
			while(j < containsArr.length) {
				if(containsArr[j] != DEFAULT_VALUE) {
					intersectArr[i] = containsArr[j];
					j++;
					break;
				}	
				else {
					j++;
				}
			}
		}
		
		//-------------------------- Printing array --------------------------
		if(intersectArr.length == 0) {
			System.out.println("The intersected array is empty.");
			return;
		}
		System.out.print("The intersected array is: \n[");
		for(int i = 0; i < intersectArr.length; i++) {
			if(i < (intersectArr.length - 1))
				System.out.print(intersectArr[i] + ", ");
			else
				System.out.print(intersectArr[i] + "]\n");
		}
	}
	
	public void union(int[] otherArr) {
		int[] holder, unionArr;
		int count = 0;
		
		//-------------------------- Initializing holder to default value --------------------------
		holder = new int[this.arr.length + otherArr.length];
		for(int i = 0; i < holder.length; i++) {
			holder[i] = DEFAULT_VALUE;
		}
		
		//-------------------------- Adding default array to holder --------------------------
		for(int i = 0; i < this.arr.length; i++) {
			if(!(inContains(this.arr[i], holder))) {
				holder[i] = this.arr[i];
				count++;
			}
		}
		
		// -------------------------- Appending second array to holder, ignoring repeated values --------------------------
		for(int i = 0; i < otherArr.length; i++) {
			if(!(inContains(otherArr[i], holder))) {
				holder[this.arr.length + i] = otherArr[i];
				count++;
			}
		}

		// -------------------------- Creating Intersect array, ignoring default values in holder --------------------------
		unionArr = new int[count];
		int j = 0;
		for(int i = 0; i < unionArr.length; i++) {
			while(j < holder.length) {
				if(holder[j] != DEFAULT_VALUE) {
					unionArr[i] = holder[j];
					j++;
					break;
				}
				else
					j++;
			}
		}
		
		// -------------------------- Printing Array --------------------------
		if(unionArr.length == 0) {
			System.out.println("The union'd array is empty.");
			return;
		}
		System.out.print("The Union'd array is: \n[");
		for(int i = 0; i < unionArr.length; i++) {
			if(i < (unionArr.length - 1))
				System.out.print(unionArr[i] + ", ");
			else
				System.out.print(unionArr[i] + "]\n");
		}
		
		
	}
	
	public void difference(int[] otherArr) {
		int[] holderArr, differenceArr;
		int count = 0;
		
		// -------------------------- Initialize holder array to default values --------------------------
		holderArr = new int[otherArr.length + this.arr.length];
		for(int i = 0; i < holderArr.length; i++) {
			holderArr[i] = DEFAULT_VALUE;
		}
		
		// -------------------------- Add this.arr values to holder if they aren't in otherArr --------------------------
		for(int i = 0; i < this.arr.length; i++) {
			if(!(inContains(this.arr[i], otherArr)) && !(inContains(this.arr[i], holderArr))){
				holderArr[i] = this.arr[i];
				count++;
			}
		}
		
		// -------------------------- Add otherArr values to holder if they aren't in this.arr --------------------------
		for(int i = 0; i < otherArr.length; i++) {
			if(!(inContains(otherArr[i], this.arr)) && !(inContains(otherArr[i], holderArr))) {
				holderArr[this.arr.length + i] = otherArr[i];
				count++;
			}
		}
		
		
		// -------------------------- Create the difference array from values in the holder array --------------------------
		differenceArr = new int[count];
		
		int j = 0;
		for(int i = 0; i < differenceArr.length; i++) {
			while(j < holderArr.length) {
				if(holderArr[j] != DEFAULT_VALUE) {
					differenceArr[i] = holderArr[j];
					j++;
					break;
				}
				else
					j++;
			}
		}
		
		// -------------------------- Printing Array --------------------------
		if(differenceArr.length == 0) {
			System.out.println("The Difference array is empty.");
			return;
		}
		System.out.print("The Difference of the two arrays is: \n[");
		for(int i = 0; i < differenceArr.length; i++) {
			if(i < (differenceArr.length - 1))
				System.out.print(differenceArr[i] + ", ");
			else
				System.out.print(differenceArr[i] + "]\n");
		}
	}
	
	private boolean inContains(int value, int[] arr){
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] == value)
				return true;
		}
		return false;
		
	}
}
