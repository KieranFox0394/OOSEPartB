package test;
import creche.impl.*;
import creche.demo.*;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class test_staff_minder_adjust_rostered {
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
	public void test_rostered_change() {
		cal = new Calendar();
		cal.setDate(1);
		cal.setStaffId(1);
		CalendarStorage.createStorage();
		CalendarStorage.calendarData.add(cal);
		cal.setRostered(Calendar.rosteredStatus.NOT__SET.name());
		
	    String prevRostered = cal.getRostered();
		String expectedRostered = Calendar.rosteredStatus.NOT__SET.name();
		staff_minder.adjustRostered(cal, Calendar.rosteredStatus.NOTROSTERED.name(), user_minder);
		
		assertEquals(cal.getRostered(), prevRostered);
		assertEquals(cal.getRostered(), expectedRostered);	
	}
	
	
}
