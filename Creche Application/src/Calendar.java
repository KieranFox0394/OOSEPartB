import java.util.ArrayList;

public class Calendar {

	private int staffId;
	private int date;
	private boolean availability;
	private boolean isRostered;

	public static ArrayList<Calendar> createCalendarMonth(int month,int staffId) { 
		ArrayList<Calendar> returnCalendar = new ArrayList<>();
		for(int day = 1; day <=30; day++)
		{
			Calendar newCalendar = new Calendar();
			newCalendar.setStaffId(staffId);
			newCalendar.setDate((month * 30) + day);
			returnCalendar.add(newCalendar);
		}
		return returnCalendar;
	}

	public int getStaffId() {
		return staffId;
	}

	public void setStaffId(int staffId) {
		this.staffId = staffId;
	}

	public int getDate() {
		return date;
	}

	public void setDate(int date) {
		this.date = date;
	}

	public boolean isAvailability() {
		return availability;
	}

	public void setAvailability(boolean availability) {
		this.availability = availability;
	}

	public boolean isRostered() {
		return isRostered;
	}

	public void setRostered(boolean isRostered) {
		this.isRostered = isRostered;
	}

}