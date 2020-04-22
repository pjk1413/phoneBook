package phoneBook;

public class Application {

	public static void main(String[] args) {
		Contact[] contactList = new Contact[0];
		
		Contact contact = new Contact();
		Address address = new Address();
		contact.setAddress(address);
		
		boolean run = true;
		
		while (run) {
			
			switch (DisplayMenu.displayInitialMenu()) {
			case 'A': // Add a record
				Contact newContact = new Contact();
				newContact.setAddress(new Address());
				newContact.saveRecord();
				contactList = DataHandling.addRecordToArray(newContact, contactList);
				break;
			case 'D': // Delete a record
				contact.deleteRecord(); //Locate a record to delete
				contactList = DataHandling.deleteRecordFromArray(contact, contactList);
				break;
			case 'U': // Update a record
				contact.updateRecord(contactList);
				contactList = DataHandling.deleteRecordFromArray(contact, contactList);
				contactList = DataHandling.addRecordToArray(contact, contactList);
				break;
			case 'F': // Find a record - first, last, city, state, number
				
				Contact[] foundContacts = contact.findRecord(contactList);
				for (Contact c : foundContacts) {
					c.display();
				}
				break;
			case 'S': // Show all records
				System.out.println(contactList.length);
				contactList = Contact.sortRecords(contactList);
				for (Contact c : contactList) {
					c.display();
				}
				break;
			case 'E': // Exit
				run = false;
				break;

			default:
				DisplayMenu.clearScreen();
				run = true;
				break;
			}

		}

	}
}
