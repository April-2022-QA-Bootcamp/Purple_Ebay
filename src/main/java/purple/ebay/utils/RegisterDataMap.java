package purple.ebay.utils;

public enum RegisterDataMap {
	Title("Title"), Text("Expected Text"), FirstName("First Name"), LastName("Last Name"), Email("Email"), Password("Password"), Error("Expected Error");
	

	
	private String value;
	
	private RegisterDataMap(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}

}

