package creche.demo;
import java.util.ArrayList;
import creche.impl.*;

public class CalendarStorage {
	public static ArrayList<Calendar> calendarData;

	
	public static void createStorage()
	{
		calendarData = new ArrayList<Calendar>();
	}


	public static void createSampleData() {
		for (Staff staff : StaffStorage.staffData) {
			ArrayList<Calendar> newCalendar = new ArrayList<Calendar>();
			newCalendar = Calendar.createCalendarMonth(0, staff.getStaffId());
			for(Calendar cal : newCalendar)
			{
				CalendarStorage.calendarData.add(cal);
			}
		}		
	}


	public static Calendar getCalendarEntry(Staff staffToFind, int dateToFind) {
		for(Calendar cal : CalendarStorage.calendarData)
		{
			if(cal.getStaffId() == staffToFind.getStaffId() && cal.getDate() == dateToFind)
			{
				return cal;
			}
		}
		return null;
	}
	
	

}
