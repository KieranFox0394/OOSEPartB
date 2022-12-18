package test;
import creche.impl.*;
import creche.demo.*;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class test_staff_admin_adjust_availability {
	Staff staff_admin;
	Account user_admin;
	Calendar cal;
	@Before
	public void setUp() throws Exception {
		staff_admin = new Staff();
		staff_admin.setStaffId(1);
		staff_admin.setEmployeeRole(Staff.staffRole.ADMIN.name()); //staff of type admin
		StaffStorage.createStorage();
		StaffStorage.staffData.add(staff_admin);
		
		user_admin = new Account(Account.accountType.STAFF.name(), 1); //user of type staff
		AccountStorage.createStorage();
		AccountStorage.accountData.add(user_admin);
	
		
	}

	@Test
	public void test_availability_change() {
		cal = new Calendar();
		cal.setDate(1);
		cal.setStaffId(1);
		CalendarStorage.createStorage();
		CalendarStorage.calendarData.add(cal);
		cal.setAvailability(Calendar.availabilityStatus.NOT__SET.name());
		
	    String prevAvailability = cal.getAvailability();
		String expectedAvailability = Calendar.availabilityStatus.NOT__SET.name();
		staff_admin.adjustAvailability(cal, Calendar.availabilityStatus.AVAILABLE.name(),user_admin);
		
		assertEquals(cal.getAvailability(), prevAvailability);
		assertEquals(cal.getAvailability(),expectedAvailability);	
	}
	
	
}
