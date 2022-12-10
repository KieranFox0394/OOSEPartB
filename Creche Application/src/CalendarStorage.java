import java.util.ArrayList;

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
	
	public static ArrayList<Calendar> getStaffRota(Account account, int startDate, int endDate){
		//check if it is a staff account
		//check if it is admin/owner OR the staff member themselves
		
		return null;
	}

}
