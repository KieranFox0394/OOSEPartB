import java.util.ArrayList;
import java.util.Scanner;

public class Menu {

	public static void logIn() {
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
			if (selectedAccount.login(userId, selectedAccount.getAccountType(), password)) {
				AccountStorage.currentAccount = selectedAccount;
				StaffStorage.currentStaff = StaffStorage.getStaffFromAccount(selectedAccount);
				System.out.println("Logged in as " + AccountStorage.currentAccount.getAccountType() + " "
						+ AccountStorage.currentAccount.getUserId());
			} else {
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

	public static void viewOwnRota() {
		ArrayList<Calendar> ownRota = StaffStorage.currentStaff.getRota(AccountStorage.currentAccount);
		System.out.println("DATE \tAVAILABLE \tROSTERED");
		for (Calendar ownCal : ownRota) {
			System.out.println(ownCal.getDate() + "\t" + ownCal.getAvailability() + "\t" + ownCal.getRostered());
		}
	}

	public static void adjustOwnAvilability() {
		viewOwnRota();
		System.out.println("Enter the date you wish to adjust availability to.  Press 0 to return ");
		System.out.println();
		Scanner myObj = new Scanner(System.in);
		int dateToAdjust = Integer.parseInt(myObj.nextLine());

		if (dateToAdjust == 0) {
			return;
		}

		Calendar calToAdjust = CalendarStorage.getCalendarEntry(StaffStorage.currentStaff, dateToAdjust);

		if (calToAdjust == null) {
			System.out.println("Date is not valid");
			return;
		}

		System.out.println("Enter 1 to set to Available.  Enter 2 to set to Not Available");
		System.out.println();
		myObj = new Scanner(System.in);
		int availability = Integer.parseInt(myObj.nextLine());
		switch (availability) {
		case (1):
			StaffStorage.currentStaff.adjustAvailability(calToAdjust, Calendar.availabilityStatus.AVAILABLE.name(),
					AccountStorage.currentAccount);
			break;
		case (2):
			StaffStorage.currentStaff.adjustAvailability(calToAdjust, Calendar.availabilityStatus.NOTAVAILABLE.name(),
					AccountStorage.currentAccount);
			break;
		default:
			System.out.println("Invalid entry");
			return;
		}
	}

	public static void removeOwnAvailability() {
		viewOwnRota();
		System.out.println("Enter the date you wish to remove availability for.  Press 0 to return ");
		System.out.println();
		Scanner myObj = new Scanner(System.in);
		int dateToAdjust = Integer.parseInt(myObj.nextLine());

		if (dateToAdjust == 0) {
			return;
		}

		Calendar calToAdjust = CalendarStorage.getCalendarEntry(StaffStorage.currentStaff, dateToAdjust);

		if (calToAdjust == null) {
			System.out.println("Date is not valid");
			return;
		}

		StaffStorage.currentStaff.adjustAvailability(calToAdjust, Calendar.availabilityStatus.NOT__SET.name(),
				AccountStorage.currentAccount);

	}

	public static void viewMinderRota() {
		AccountStorage.listUsers(false);
		System.out.println("Enter the Minder you wish to see rota for.  Press 0 to return ");
		System.out.println();
		Scanner myObj = new Scanner(System.in);
		int minderID = Integer.parseInt(myObj.nextLine());
		if (minderID == 0) {
			return;
		}
		Staff staffToView = StaffStorage.getStaffFromID(minderID);
		if (staffToView == null) {
			System.out.println("Not valid Minder");
			return;
		}
		if (!(staffToView.getEmployeeRole().equals(Staff.staffRole.MINDER.name()))) {
			System.out.println("Not valid Minder");
			return;
		}
		ArrayList<Calendar> staffRotaCal = staffToView.getRota(AccountStorage.currentAccount);
		System.out.println("DATE \tAVAILABLE \tROSTERED");
		for (Calendar cal : staffRotaCal) {
			System.out.println(cal.getDate() + "\t" + cal.getAvailability() + "\t" + cal.getRostered());
		}

	}

	public static void adjustRostered() {
		AccountStorage.listUsers(false);
		System.out.println("Enter the Minder you wish to adjust roster for.  Press 0 to return ");
		System.out.println();
		Scanner myObj = new Scanner(System.in);
		int minderID = Integer.parseInt(myObj.nextLine());
		if (minderID == 0) {
			return;
		}
		Staff staffToAdjust = StaffStorage.getStaffFromID(minderID);
		if (staffToAdjust == null) {
			System.out.println("Not valid Minder");
			return;
		}
		if (!(staffToAdjust.getEmployeeRole().equals(Staff.staffRole.MINDER.name()))) {
			System.out.println("Not valid Minder");
			return;
		}

		System.out.println("Enter the date you wish to adjust rostered status for.  Press 0 to return ");
		System.out.println();
		myObj = new Scanner(System.in);
		int dateToAdjust = Integer.parseInt(myObj.nextLine());

		if (dateToAdjust == 0) {
			return;
		}

		Calendar calToAdjust = CalendarStorage.getCalendarEntry(staffToAdjust, dateToAdjust);

		if (calToAdjust == null) {
			System.out.println("Date is not valid");
			return;
		}

		System.out.println("Enter 1 to set to Rostered.  Enter 2 to set to Not Rostered");
		System.out.println();
		myObj = new Scanner(System.in);
		int rostered = Integer.parseInt(myObj.nextLine());
		switch (rostered) {
		case (1):
			staffToAdjust.adjustRostered(calToAdjust, Calendar.rosteredStatus.ROSTERED.name(),
					AccountStorage.currentAccount);
			break;
		case (2):
			staffToAdjust.adjustRostered(calToAdjust, Calendar.rosteredStatus.NOTROSTERED.name(),
					AccountStorage.currentAccount);
			break;
		default:
			System.out.println("Invalid entry");
			return;
		}

	}

	public static void removeRostered() {
		AccountStorage.listUsers(false);
		System.out.println("Enter the Minder you wish to remove roster for.  Press 0 to return ");
		System.out.println();
		Scanner myObj = new Scanner(System.in);
		int minderID = Integer.parseInt(myObj.nextLine());
		if (minderID == 0) {
			return;
		}
		Staff staffToAdjust = StaffStorage.getStaffFromID(minderID);
		if (staffToAdjust == null) {
			System.out.println("Not valid Minder");
			return;
		}
		if (!(staffToAdjust.getEmployeeRole().equals(Staff.staffRole.MINDER.name()))) {
			System.out.println("Not valid Minder");
			return;
		}

		System.out.println("Enter the date you wish to remove rostered status for.  Press 0 to return ");
		System.out.println();
		myObj = new Scanner(System.in);
		int dateToAdjust = Integer.parseInt(myObj.nextLine());

		if (dateToAdjust == 0) {
			return;
		}

		Calendar calToAdjust = CalendarStorage.getCalendarEntry(staffToAdjust, dateToAdjust);

		if (calToAdjust == null) {
			System.out.println("Date is not valid");
			return;
		}

		staffToAdjust.adjustAvailability(calToAdjust, Calendar.rosteredStatus.NOT__SET.name(),
				AccountStorage.currentAccount);

	}

}
