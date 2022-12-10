import java.util.ArrayList;

public class Staff {
	public enum staffRole {MINDER,ADMIN,OWNER};
	
	private String name;
	private String dateOfBirth;
	private int staffId;
	private String iban;
	private double rateOfPay;
	private int contractEndDate;
	private String employeeRole;

	public boolean adjustAvailability(Calendar calendarToAdjust, boolean newAvailability, Account user) {
		//We expect in a Calendar instance and will adjust the record as per the 
		//passed in value. We will simply replace the value in the database.
		//This could be improved by implementing as a HashMap
		
		int indexToAdjust = CalendarStorage.calendarData.indexOf(calendarToAdjust);
				
		if(indexToAdjust == -1) {
			return false; //no record found
		}
		else {
			Calendar newCalendar = new Calendar();
			newCalendar = CalendarStorage.calendarData.get(indexToAdjust);
			newCalendar.setAvailability(newAvailability);
			CalendarStorage.calendarData.set(indexToAdjust, newCalendar);
			return true;
		}
		
		}

	public boolean adjustRostered(Calendar calendarToAdjust, boolean newRostered, Account user) {
		//We expect in a Calendar instance and will adjust the record as per the 
		//passed in value. We will simply replace the value in the database.
		//This could be improved by implementing as a HashMap
				
		int indexToAdjust = CalendarStorage.calendarData.indexOf(calendarToAdjust);
				
		if(indexToAdjust == -1) {
			return false; //no record found
		}
		else {
			Calendar newCalendar = new Calendar();
			newCalendar = CalendarStorage.calendarData.get(indexToAdjust);
			newCalendar.setAvailability(newRostered);
			CalendarStorage.calendarData.set(indexToAdjust, newCalendar);
			return true;
		}
	}

	public boolean removeAvailability(Calendar calendarToAdjust, Account user) {
		//We expect in a Calendar instance and will adjust the record as per the 
		//passed in value. We will simply replace the value in the database.
		//This could be improved by implementing as a HashMap
		
		int indexToAdjust = CalendarStorage.calendarData.indexOf(calendarToAdjust);
				
		if(indexToAdjust == -1) {
			return false; //no record found
		}
		else {
			Calendar newCalendar = new Calendar();
			newCalendar = CalendarStorage.calendarData.get(indexToAdjust);
			newCalendar.setAvailability(false);
			CalendarStorage.calendarData.set(indexToAdjust, newCalendar);
			return true;
		}
	}

	public boolean removeRostered(Calendar calendarToAdjust, Account user) {
		//We expect in a Calendar instance and will adjust the record as per the 
		//passed in value. We will simply replace the value in the database.
		//This could be improved by implementing as a HashMap
				
		int indexToAdjust = CalendarStorage.calendarData.indexOf(calendarToAdjust);
				
		if(indexToAdjust == -1) {
			return false; //no record found
		}
		else {
			Calendar newCalendar = new Calendar();
			newCalendar = CalendarStorage.calendarData.get(indexToAdjust);
			newCalendar.setAvailability(false);
			CalendarStorage.calendarData.set(indexToAdjust, newCalendar);
			return true;
		}
	}
	
	public ArrayList<Calendar> getRota(Staff staffToRetrieve, Account user) {
		//Allowed by only staff members.  Not parents.
		//If it is a minder, they can only check their own rota
		
		//We need to get back all of the Calendar records for the passed in
		//Staff
		
		if(user.getAccountType() != Account.accountType.STAFF.name()) //only staff are permitted 
		{
			return null;
		}
		
		if(user.getUserId() == staffToRetrieve.getStaffId() || // the user is looking up their own rota
		   getStaffFromAccount(user).getEmployeeRole().equals(Staff.staffRole.ADMIN.name()) || //they are an admin
		   getStaffFromAccount(user).getEmployeeRole().equals( Staff.staffRole.OWNER.name()))  //they are an owner
			 {
				ArrayList<Calendar> returnCalendarList = new ArrayList<Calendar>();
				for(Calendar calendarToCheck : CalendarStorage.calendarData)
				{
					if(calendarToCheck.getStaffId() == staffToRetrieve.getStaffId())
					{
						returnCalendarList.add(calendarToCheck);
					}
				}
				return returnCalendarList;	
			 }
		else {
			return null;
		}	
	}
	
	public Staff getStaffFromAccount(Account account)
	{
		for(Staff staffToCheck : StaffStorage.staffData)
		{
			if(account.getUserId() == staffToCheck.getStaffId())
			{
				return staffToCheck;
			}
		}
		return null;
	}
	
	public boolean adjustPay(Staff staffToAdjust, Staff user) {
		// TODO - implement Staff.adjustPay
		throw new UnsupportedOperationException();
	}

	public boolean acceptChildFromWaitingList(Child childToAdjust, Account user) {
		// TODO - implement Staff.acceptChildFromWaitingList
		throw new UnsupportedOperationException();
	}

	public boolean addChildAttendanceRecord(Child childToAdjust,Attendance attendanceRecordToAdjust, Account user) {
		// TODO - implement Staff.addChildAttendanceRecord
		throw new UnsupportedOperationException();
	}

	public boolean addChildCollectionRecord(Child childToAdjust,Attendance attendanceRecordToAdjust, Account user ) {
		// TODO - implement Staff.addChildCollectionRecord
		throw new UnsupportedOperationException();
	}

	public boolean addTimeAndAttendanceRecord(TimeAndAttendanceSystem TimeAttendToAdjust, Account user) {
		// TODO - implement Staff.addTimeAndAttendanceRecord
		throw new UnsupportedOperationException();
	}

	public boolean adjustTimeAndAttendanceRecord(TimeAndAttendanceSystem TimeAttendToAdjust, Account user) {
		// TODO - implement Staff.adjustTimeAndAttendanceRecord
		throw new UnsupportedOperationException();
	}

	
	public boolean createPayment(Staff staffToAdjust, Account user) {
		// TODO - implement Staff.createPayment
		throw new UnsupportedOperationException();
	}

	public Parents getParentDetails(Parents parentToRetrieve, Account user) {
		// TODO - implement Staff.getParentDetails
		throw new UnsupportedOperationException();
	}

	public ArrayList<DesignatedGuardian> getGuardianDetails(DesignatedGuardian guardianToRetrieve, Account user) {
		// TODO - implement Staff.getGuardianDetails
		throw new UnsupportedOperationException();
	}


	public ArrayList<Fees> getPaymentHistory(Parents parentsToRetrieve, Account user) {
		// TODO - implement Staff.getPaymentHistory
		throw new UnsupportedOperationException();
	}

	public void adjustContractEndDate(Staff staffToAdjust, Account user) {
		// TODO - implement Staff.adjustContractEndDate
		throw new UnsupportedOperationException();
	}

	public void adjustChildFeeAmount(Fees feesToRetrieve, Account user) {
		// TODO - implement Staff.adjustChildFeeAmount
		throw new UnsupportedOperationException();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public int getStaffId() {
		return staffId;
	}

	public void setStaffId(int staffId) {
		this.staffId = staffId;
	}

	public String getIban() {
		return iban;
	}

	public void setIban(String iban) {
		this.iban = iban;
	}

	public double getRateOfPay() {
		return rateOfPay;
	}

	public void setRateOfPay(double rateOfPay) {
		this.rateOfPay = rateOfPay;
	}

	public int getContractEndDate() {
		return contractEndDate;
	}

	public void setContractEndDate(int contractEndDate) {
		this.contractEndDate = contractEndDate;
	}

	public String getEmployeeRole() {
		return employeeRole;
	}

	public void setEmployeeRole(String employeeRole) {
		this.employeeRole = employeeRole;
	}

}