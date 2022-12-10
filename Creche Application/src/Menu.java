import java.util.Scanner;

public class Menu {

	public static void logIn()
	{
		System.out.println();
		System.out.println("Please log in: Select a user ID");
		System.out.println();
		Scanner myObj = new Scanner(System.in); // Create a Scanner object
		int userId = Integer.parseInt((myObj.nextLine()));
		Account selectedAccount = AccountStorage.findUser(userId);
		if (selectedAccount != null)// we found an account
		{
			System.out.println("Enter the password to authorize access");
			System.out.println();
			myObj = new Scanner(System.in);
			String password = myObj.nextLine();
			if(selectedAccount.login(userId, selectedAccount.getAccountType(), password))
			{	AccountStorage.currentAccount = selectedAccount;
				System.out.println("Logged in as " + AccountStorage.currentAccount.getAccountType() + " "
						          + AccountStorage.currentAccount.getUserId() );
			}
			else {
				System.out.println("Incorrect password");
			}
			
		} else {
			System.out.println("No Account exists");
		}
	}

	public static void listUsers() {
		AccountStorage.listUsers(true);
		
	}

	public static void logOut() {
		AccountStorage.currentAccount = null;
		StaffStorage.currentStaff = null;
		
	}

	public static void resetPassword() {
		System.out.println("Old Password: " + AccountStorage.currentAccount.getPassword());
		AccountStorage.currentAccount.resetPassword();
		System.out.println("New Password: " + AccountStorage.currentAccount.getPassword());
		
	}
}
