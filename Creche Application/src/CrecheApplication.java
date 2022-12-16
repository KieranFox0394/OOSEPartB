import java.util.ArrayList;
import java.util.Scanner;

public class CrecheApplication {
	public final static int adminCount = 3;
	public final static int minderCount = 3;
	public final static int ownerCount = 3;

	public static void main(String[] args) {
		// storage of some account data and some Staff and Calendar Entries
		StaffStorage.createStorage();
		StaffStorage.createSampleData();
		AccountStorage.createStorage();
		AccountStorage.createSampleData();
		CalendarStorage.createStorage();
		CalendarStorage.createSampleData();

//		LOGGED OUT
//		1	LogIn
//		2	ListUsers
//		LOGGED IN 
//		11	LogOut
//		12	ResetPassword
//		MINDER
//		21	ViewOwnRota
//		22	AdjustOwnAvailability
//		23	RemoveOwnAvailability
//		OWNER/ADMIN
//		31	ViewAllRota
//		32	ViewSingleRota
//		33	AdjustSingleRostered

		int menuInput = 99;
		Scanner myObj = new Scanner(System.in); // Create a Scanner object

		System.out.println("\n\n" + "Please Select a Menu Option");
		while (true) {
			if (AccountStorage.currentAccount == null) { // Logged Out Options
				System.out.println("1: Login");
				System.out.println("2: List Users");

				myObj = new Scanner(System.in);
				menuInput = Integer.parseInt((myObj.next()));

			} else {
				if (AccountStorage.currentAccount.getAccountType().equals(Account.accountType.STAFF.name())) {
					System.out.print("Current User:" + AccountStorage.currentAccount.getAccountType() + " "
							+ AccountStorage.currentAccount.getUserId() + "\n");
					System.out.println("11: Logout");
					System.out.println("12: Reset Password");

					if (StaffStorage.currentStaff.getEmployeeRole().equals(Staff.staffRole.MINDER.name())) {
						System.out.println("21: View Own Rota");
						System.out.println("22: Adjust Own Availability");
						System.out.println("23: Remove Own Availability");

					} else if (StaffStorage.currentStaff.getEmployeeRole().equals(Staff.staffRole.ADMIN.name())
							|| StaffStorage.currentStaff.getEmployeeRole().equals(Staff.staffRole.OWNER.name())) {
						System.out.println("31: View Single Minder Rota");
						System.out.println("32: Adjust Single Minder Rostered");
						System.out.println("33: Remove Single Minder Rostered");
					}
				}

				myObj = new Scanner(System.in);
				menuInput = Integer.parseInt((myObj.next()));
			}

			switch (menuInput) {
			// Logged out Options
			case 1:// Log in
				Menu.logIn();
				break;
			case 2:// User List
				Menu.listUsers();
				break;
			// Logged in Account Options
			case 11:// Log out of current User
				Menu.logOut();
				break;
			case 12:// Reset password
				Menu.resetPassword();
				break;
			// Logged in Minder Options
			case 21:
				Menu.viewOwnRota();
				break;
			case 22:
				Menu.adjustOwnAvilability();
				break;
			case 23:
				Menu.removeOwnAvailability();
				break;
				// Logged in Owner / Admin Options
			case 31:
				Menu.viewMinderRota();
				break;
			case 32:
				Menu.adjustRostered();
				break;
			case 33:
				Menu.removeRostered();
				break;
			case 34:
	
				break;

			default://
				System.out.println("Please Select a Menu Option");
			}

		}

	}

}
