package purple.ebay.utils;

public class RegisterData {
	private String expectedTitle;
	private String expectedText1;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String expectedError;

	public RegisterData(String expectedTitle, String expectedText1, String firstName, String lastName, String email,
			String password, String expectedError) {

		this.expectedTitle = expectedTitle;
		this.expectedText1 = expectedText1;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.expectedError = expectedError;
	}

	public String getExpectedTitle() {
		return expectedTitle;
	}

	public String getExpectedText1() {
		return expectedText1;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public String getExpectedError() {
		return expectedError;
	}

}
