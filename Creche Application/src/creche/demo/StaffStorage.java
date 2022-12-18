package creche.demo;
import java.util.ArrayList;
import creche.impl.*;

public class StaffStorage {
	public static ArrayList<Staff> staffData;
	public static Staff currentStaff;
	
	public static void createStorage()
	{
		staffData = new ArrayList<Staff>();
	}

	public static void createSampleData() {
		for (int staffCount = 1; staffCount <= CrecheApplication.adminCount; staffCount++) {
			Staff newStaff = new Staff();
			newStaff.setStaffId(staffCount);
			newStaff.setName("admin " + staffCount);
			newStaff.setDateOfBirth("1990010" + staffCount);
			newStaff.setRateOfPay(20000 + (5000 * staffCount));
			newStaff.setIban("IE1234567891234567890" + staffCount);
			newStaff.setEmployeeRole(Staff.staffRole.ADMIN.name());
			StaffStorage.staffData.add(newStaff);
		}
		
		for (int staffCount = 1; staffCount <= CrecheApplication.minderCount; staffCount++) {
			Staff newStaff = new Staff();
			newStaff.setStaffId(staffCount + CrecheApplication.adminCount);
			newStaff.setName("minder " + staffCount);
			newStaff.setDateOfBirth("1990010" + staffCount);
			newStaff.setRateOfPay(20000 + (5000 * staffCount));
			newStaff.setIban("IE1234567891234567890" + staffCount);
			newStaff.setEmployeeRole(Staff.staffRole.MINDER.name());
			StaffStorage.staffData.add(newStaff);
		}
		
		for (int staffCount = 1; staffCount <= CrecheApplication.ownerCount; staffCount++) {
			Staff newStaff = new Staff();
			newStaff.setStaffId(staffCount + CrecheApplication.adminCount + CrecheApplication.minderCount);
			newStaff.setName("owner " + staffCount);
			newStaff.setDateOfBirth("1990010" + staffCount);
			newStaff.setRateOfPay(20000 + (5000 * staffCount));
			newStaff.setIban("IE1234567891234567890" + staffCount);
			newStaff.setEmployeeRole(Staff.staffRole.OWNER.name());
			StaffStorage.staffData.add(newStaff);
		}
		
	}
	
	public static Staff getStaffFromAccount(Account account) {
		for (Staff staffToCheck : StaffStorage.staffData) {
			if (account.getUserId() == staffToCheck.getStaffId()) {
				return staffToCheck;
			}
		}
		return null;
	}

	public static Staff getStaffFromID(int minderID) {
		for(Staff staff : StaffStorage.staffData)
		{
			if(minderID == staff.getStaffId())
			{
				return staff;
			}
		}
		return null;
	}
}
