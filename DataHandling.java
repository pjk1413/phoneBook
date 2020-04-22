package phoneBook;

import java.util.Scanner;

public abstract class DataHandling {

	abstract void saveRecord(); // Saves a record to the file

	abstract void deleteRecord(); // Deletes a record

	public static char getCleanChar() {
		char choice = '@';
		Scanner input = new Scanner(System.in);

		// System.out.println("E");
		boolean hasNext = true;
		while (hasNext) {

			// if the next is a Byte,
			// prByte found and the Byte
			if (input.hasNext()) {
				choice = input.next().charAt(0);
				// System.out.println(choice);
				hasNext = false;

			} else {
				System.out.println("Not found Byte value: " + input.next());
			}
		}

		// input.close();
		// System.out.println(choice);
		return choice;
	}

	abstract void parseString(String str); // Parses a string to save or load a record

	public static Contact[] findRecords(Contact[] contactList, String searchTerm, char searchBy) {
		Contact[] cl = new Contact[0];

		for (Contact contact : contactList) {
			String searchable = "";
			
			switch (searchBy) {
			case 'F':
				searchable = contact.getFirstName();
				break;
			case 'L':
				searchable = contact.getLastName();
				break;
			case 'U':
				searchable = contact.getFirstName() + contact.getLastName();
				break;
			case 'P':
				searchable = contact.getPhoneNumber();
				break;
			case 'C':
				searchable = contact.getAddress().getCity();
				break;
			case 'S':
				searchable = contact.getAddress().getState();
				break;
			default:
				break;
			}

			if (searchable.matches(searchTerm.trim())) {
				cl = addRecordToArray(contact, cl);
				
			}
		}

		return cl;
	}

	public static String getStringFromUser() {
		System.out.println("\nEnter your data below");
		Scanner lineReader = new Scanner(System.in);

		String contactEntry = "";
		if (lineReader.hasNextLine()) {
			contactEntry = lineReader.nextLine();
		}
		return contactEntry;
	}

	public static Contact[] addRecordToArray(Contact contact, Contact[] contactList) {
		int i;
		int n = contactList.length;

		Contact[] newContactList = new Contact[n + 1];

		for (i = 0; i < n; i++) {
			newContactList[i] = contactList[i];
		}
		newContactList[n] = contact;

		return newContactList;
	}

	public static Contact[] deleteRecordFromArray(Contact contact, Contact[] contactList) {
		int i;
		int n = contactList.length;

		Contact[] newContactList = new Contact[n - 1];

		for (i = 0; i < n; i++) {
			if (!contactList[i].getPhoneNumber().equals(contact.getPhoneNumber())) {
				newContactList[i] = contactList[i];
			}
		}

		return newContactList;
	}
}
