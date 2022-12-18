package test;
import creche.impl.*;
import creche.demo.*;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class test_staff_minder_adjust_availability {
	Staff staff_minder;
	Account user_minder;
	Calendar cal;
	@Before
	public void setUp() throws Exception {
		staff_minder = new Staff();
		staff_minder.setStaffId(1);
		staff_minder.setEmployeeRole(Staff.staffRole.MINDER.name()); //staff of type minder
		StaffStorage.createStorage();
		StaffStorage.staffData.add(staff_minder);
		
		user_minder = new Account(Account.accountType.STAFF.name(), 1); //user of type staff
		AccountStorage.createStorage();
		AccountStorage.accountData.add(user_minder);
	
		
	}

	@Test
	public void test_availability_change() {
		cal = new Calendar();
		cal.setDate(1);
		cal.setStaffId(1);
		CalendarStorage.createStorage();
		CalendarStorage.calendarData.add(cal);
		
	    String prevAvailability = cal.getAvailability();
		String expectedAvailability = Calendar.availabilityStatus.AVAILABLE.name();
		staff_minder.adjustAvailability(cal, Calendar.availabilityStatus.AVAILABLE.name(), user_minder);
		
		assertNotEquals(cal.getAvailability(), prevAvailability);
		assertEquals(cal.getAvailability(),expectedAvailability);	
	}
	
	
}
