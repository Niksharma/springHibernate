package login;

import org.springframework.data.annotation.Id;

/**
 * The object will be used to persist product data to MongoDB
 * @author nikhil
 *
 */
public class Person {

	@Id 
	private String id;

	private String userName;
	private String email;
	
	/**
	 * Returns the user name of the person
	 * @return	String
	 */
	public String getUserName() {
		return userName;
	}
	
	/**
	 * Set the user name of the person
	 * 
	 * @param userName
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	/**
	 * Returns the email address of the person
	 * @return	String
	 */
	public String getEmail() {
		return email;
	}
	
	/**
	 * Set the email address of the person
	 * 
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}
}