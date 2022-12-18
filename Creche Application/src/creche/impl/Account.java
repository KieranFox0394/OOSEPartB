package creche.impl;
public class Account {
	public enum accountType {STAFF,PARENT};
	
	private int userId;
	private String password;
	private String accountType;

	public Account(){}
	
	public Account(String accountType, int userId) {
		this.password = generatePassword();
		this.accountType = accountType;
		this.userId = userId;
	}

	private String generatePassword() {
		return("" + ((int)Math.floor(Math.random() * 10) + "" + 
				(int)(Math.floor(Math.random() * 10)) + "" + 
				(int)(Math.floor(Math.random() * 10)) + "" + 
				(int)(Math.floor(Math.random() * 10))));
	}

	public void resetPassword() {
		this.password = generatePassword();
	}

	public boolean login(int userId, String accountType, String password) {
		if((this.userId == userId) && (this.accountType.equals(accountType)) && (this.password.equals(password)))
		{		return true;
				}
		return false;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

}