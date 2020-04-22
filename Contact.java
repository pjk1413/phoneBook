package phoneBook;

import java.util.Scanner;

public class Contact extends DataHandling {
	private String firstName;
	private String lastName;
	private Address address;
	private String phoneNumber;

	public Contact() {
	}

	public Contact(String firstName, String lastName, Address address, String phoneNumber) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.address = address;
	}



	public void updateRecord(Contact[] contactList) {
		// TODO Auto-generated method stub
		System.out.println("\nEnter the telephone number of the contact you would like to find");
		Scanner lineReader = new Scanner(System.in);

		String contactEntry = "";
		if (lineReader.hasNextLine()) {
			contactEntry = lineReader.nextLine();
		}

		this.phoneNumber = formatPhoneNumber(contactEntry.trim());
		this.loadRecord(contactList);

		switch (DisplayMenu.updateRecord()) {
		case 'F':
			this.firstName = DataHandling.getStringFromUser().trim();
			break;
		case 'L':
			this.lastName = DataHandling.getStringFromUser().trim();
			break;
		case 'A':
			this.address.updateAddress();
			break;
		case 'P':
			this.phoneNumber = formatPhoneNumber(DataHandling.getStringFromUser().trim());
			break;
		case 'R':
			DisplayMenu.displayInitialMenu();
			break;
		default:
			break;
		}

	}

	public void display() {
		System.out.println(
				this.firstName + " " + this.lastName + "\n" + this.address.display() + " \n" + this.phoneNumber + "\n");
	}

	@Override // Grab all data in one line and parse out
	public void saveRecord() {
		System.out.println("\nEnter your information in a single line, comma seperated");
		Scanner lineReader = new Scanner(System.in);

		String contactEntry = "";
		if (lineReader.hasNextLine()) {
			contactEntry = lineReader.nextLine();
		}

		this.parseString(contactEntry);
	}

	@Override
	void deleteRecord() {
		// TODO Auto-generated method stub
		System.out.println("\nEnter the telephone number of the contact you would like to delete");
		Scanner lineReader = new Scanner(System.in);

		String contactEntry = "";
		if (lineReader.hasNextLine()) {
			contactEntry = lineReader.nextLine();
		}

		this.phoneNumber = formatPhoneNumber(contactEntry.trim());
	}

	public void loadRecord(Contact[] contactList) {
		// TODO Auto-generated method stub
		for (int i = 0; i < contactList.length; i++) {
			if (contactList[i].getPhoneNumber().contentEquals(this.phoneNumber)) {
				this.firstName = contactList[i].getFirstName();
				this.lastName = contactList[i].getLastName();
				this.address = contactList[i].getAddress();
				this.phoneNumber = contactList[i].getPhoneNumber();
			}
		}
	}

	public Contact[] findRecord(Contact[] contactList) {
		// TODO Auto-generated method stub
		Contact[] cl = new Contact[0];

		char c = DisplayMenu.searchBy();
		switch (c) {
		case 'F':
			cl = DataHandling.findRecords(contactList, DataHandling.getStringFromUser(), c);
			break;
		case 'L':
			cl = DataHandling.findRecords(contactList, DataHandling.getStringFromUser(), c);
			break;
		case 'U':
			cl = DataHandling.findRecords(contactList, DataHandling.getStringFromUser(), c);
			break;
		case 'P':
			cl = DataHandling.findRecords(contactList, DataHandling.getStringFromUser(), c);
			break;
		case 'C':
			cl = DataHandling.findRecords(contactList, DataHandling.getStringFromUser(), c);
			break;
		case 'S':
			cl = DataHandling.findRecords(contactList, DataHandling.getStringFromUser(), c);
			break;
		case 'R':
			DisplayMenu.displayInitialMenu();
			break;
		default:
			break;

		}

		return sortRecords(cl);

	}

	@Override
	public void parseString(String str) {

		String[] data = str.split(",");
		this.firstName = data[0].split(" ")[0].trim();
		this.lastName = data[0].replaceAll(this.firstName, "").trim();
		this.address.parseString(str);
		this.phoneNumber = formatPhoneNumber(data[5]).trim();

	}

	public static Contact[] sortRecords(Contact[] contactList) {
		
		int n = contactList.length; 
		  
        for (int i = 0; i < n-1; i++) 
        { 
            int min_i = i; 
            for (int j = i+1; j < n; j++) {
                if (isLowerAlphabetically(contactList[j], contactList[min_i])) {
                    min_i = j; 
                }
            }
            Contact tempContact = contactList[min_i]; 
            contactList[min_i] = contactList[i]; 
            contactList[i] = tempContact; 
        }   
        return contactList;
	    }

	private static boolean isLowerAlphabetically(Contact holder, Contact contact) {
		// if contact is lower return true
		char[] con = (contact.lastName).toCharArray();
		char[] hold = (holder.lastName).toCharArray();

		for (int i = 0; i < con.length; i++) {
			if (con[i] < hold[i]) {
				return false;
			}
		}

		return true;

	}

	public static String formatPhoneNumber(String str) {
		char[] n = str.trim().toCharArray();
		return "(" + n[0] + n[1] + n[2] + ")-" + n[3] + n[4] + n[5] + "-" + n[6] + n[7] + n[8] + n[9];
	}

	// Getters and Setters
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}




}
