import java.util.*;

public class Driver {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int[] arr1, arr2;
		int choice;
		boolean exit = false, innerExit = false;
		
		arr1 = createArray();
		arr2 = createArray();
		
		// -------------------------- Menu Loop -------------------------
		SetArray setArray = new SetArray(arr1);
		
		while(exit == false) {
			System.out.println("\n -------------------------- Main menu:  -------------------------- \n\nPlease choose which program you wish to use. "
							   + "1: Java defined sets or 2: ADT user created sets");
			choice = sc.nextInt();
			sc.nextLine();
			
			// --------------------------Java defined Sets --------------------------
			if(choice == 1) { 
				while(innerExit == false) {
					System.out.println("Do you want to 1: Union the sets, 2: Intersect the sets, 3: Find the difference of the sets, or 4: return to main menu");
					choice = sc.nextInt();
					sc.nextLine();
					
					if (choice == 1){
						setArray.union(arr2);
					}
					else if(choice == 2)
						setArray.intersect(arr2);
					else if(choice == 3)
						setArray.difference(arr2);
					else if(choice == 4)
						break;
				}
			}
			
		}
		
	}
	
	public static int[] createArray() {
		int[] arr;
		int size = 0;
		Scanner sc = new Scanner(System.in);
		List<Integer> list1 = new ArrayList<Integer>();
		
		System.out.println("Please enter the size of the array.");
		size = sc.nextInt();
		sc.nextLine();
		
		System.out.println("Please enter the array, each item separated by a space.");
		while(size > 0) {
			list1.add(sc.nextInt());
			size--;
		}
		sc.nextLine();
		
		arr = new int[list1.size()];
		for(int i = 0; i < list1.size(); i++) {
			arr[i] = list1.get(i);
		}

		
//		sc.close();
		return arr;
	}
	
}
