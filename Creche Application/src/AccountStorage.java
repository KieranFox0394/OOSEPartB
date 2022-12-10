import java.util.ArrayList;

public class AccountStorage {
	public static ArrayList<Account> accountData;
	public static Account currentAccount;
	
	public static void createStorage() 
	{
		accountData = new ArrayList<>();
	}

	public static void createSampleData() {
		for (Staff staff : StaffStorage.staffData) {
			Account newAccount = new Account(Account.accountType.STAFF.name(),staff.getStaffId());
			AccountStorage.accountData.add(newAccount);
		}		
	}

	public static void listUsers(boolean inclPassword) {
		//List All of the Accounts and Passwords.
				System.out.println("List Of Users");
				for(Account acc:AccountStorage.accountData)
				{
					System.out.print(acc.getAccountType().toString() + "\t" + 
										acc.getUserId() + "\t" );
					if(inclPassword)
					{
						System.out.print(acc.getPassword().toString());
					}
					System.out.print("\n");
									
				}		
	}

	public static Account findUser(int userId)
	{
		for (Account account : accountData) {
			if(account.getUserId() == userId)
			{
				return account;
			}
		}
		return null;
	}
	
	
}
