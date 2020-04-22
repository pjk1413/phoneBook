package phoneBook;

import java.util.Scanner;

public class DisplayMenu {
	
	public static char displayInitialMenu() {
		System.out.println(
				"(A)dd a record \n"
			  + "(D)elete a record \n"
			  + "(U)pdate a record \n"
			  + "(F)ind a record \n"
			  + "(S)how all records \n"
			  + "(E)xit \n"
			  + "------------------"
				);
		return DataHandling.getCleanChar();
	}
	
	public static void clearScreen() {
		
	}
	
	public static char updateRecord() {
		System.out.println(
				"Which field would you like to update: \n"
			  + "(F)irst Name \n"
			  + "(L)ast Name \n"
			  + "(A)ddress \n"
			  + "(P)honeNumber "
			  + "(B)ack");
		
		return DataHandling.getCleanChar();
	}
	
	public static char updateAddress( ) {
		System.out.println(
				"Which field would you like to update: \n"
			  + "(N)umber \n"
			  + "(S)treet Name \n"
			  + "(C)ity \n"
			  + "(R)egion or State \n"
			  + "(Z)ipcode ");
		
		return DataHandling.getCleanChar();
	}
	
	public static char searchBy() {
		System.out.println(
				"Which field would you like to search by: \n"
			  + "(F)irst Name \n"
			  + "(L)ast Name \n"
			  + "f(U)ll Name \n"
			  + "(P)hone Number \n"
			  + "(C)ity \n"
			  + "(S)tate \n"
			  + "(R)eturn ");
		return DataHandling.getCleanChar();
	}
	
	
	//Input
	
}
