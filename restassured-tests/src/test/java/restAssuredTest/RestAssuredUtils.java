package restAssuredTest;

import org.apache.commons.lang3.RandomStringUtils;

public class RestAssuredUtils {

	public static String getFirstName()
	{
		String firstName = RandomStringUtils.randomAlphabetic(1);
		System.out.println(firstName);
		return "Rajesh "+firstName;
	}
	
	public static String getLastName()
	{
		String lastName = RandomStringUtils.randomAlphabetic(1);
		return "Kumar"+lastName;
	}
	
	public static String getUserName()
	{
		String userName = RandomStringUtils.randomAlphabetic(2);
		return "rajesh"+userName;
	}
	
	public static String getPassword()
	{
		String password = RandomStringUtils.randomAlphabetic(3);
		return "passowrd"+password;
	}
	public static String getEmail()
	{
		String email = RandomStringUtils.randomAlphabetic(3);
		return email+"@gmail.com";
	}
}
