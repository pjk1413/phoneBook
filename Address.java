package phoneBook;

public class Address {
	private int number;
	private String street;
	private String city;
	private String state;
	private String zipcode;
	
	public Address() {}
	
	public void parseString(String str) {
		String[] data = str.split(",");
		this.number = Integer.parseInt(data[1].trim().split(" ")[0]);
		this.street = data[1].trim().split(" ")[1].replaceAll("[0-9]+", "");
		this.city = data[2].trim();
		this.state = data[3].trim();
		this.zipcode = data[4].trim();
		
	}
	
	public String display() {
		String display = this.number + " " + this.street + "\n"
				+ this.city + ", " + this.state + " " + this.zipcode;
		return display;
	}
	
	public void updateAddress() {
		
		switch (DisplayMenu.updateAddress()) {
		case 'N':
			this.number = Integer.parseInt(DataHandling.getStringFromUser().trim());
			break;
		case 'S':
			this.street = DataHandling.getStringFromUser().trim();
			break;
		case 'C':
			this.city = DataHandling.getStringFromUser().trim();
			break;
		case 'R':
			this.state = DataHandling.getStringFromUser().trim();
			break;
		case 'Z':
			this.zipcode = DataHandling.getStringFromUser().trim();
			break;
		case 'B':
			DisplayMenu.displayInitialMenu();
			break;
		default:
			break;
		}
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	
	
}
