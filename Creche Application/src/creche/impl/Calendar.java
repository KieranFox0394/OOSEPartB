package creche.impl;
import java.util.ArrayList;

public class Calendar {
	public enum rosteredStatus {
		ROSTERED, NOTROSTERED, NOT__SET
	};
	public enum availabilityStatus {
		AVAILABLE, NOTAVAILABLE, NOT__SET
	};

	private int staffId;
	private int date;
	private String availability;
	private String rostered;

	public static ArrayList<Calendar> createCalendarMonth(int month,int staffId) { 
		ArrayList<Calendar> returnCalendar = new ArrayList<>();
		for(int day = 1; day <=30; day++)
		{
			Calendar newCalendar = new Calendar();
			newCalendar.setStaffId(staffId);
			newCalendar.setDate((month * 30) + day);
			newCalendar.setAvailability(Calendar.availabilityStatus.NOT__SET.name());
			newCalendar.setRostered(Calendar.rosteredStatus.NOT__SET.name());
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

	public String getAvailability() {
		return availability;
	}

	public void setAvailability(String availability) {
		this.availability = availability;
	}

	public String getRostered() {
		return rostered;
	}

	public void setRostered(String rostered) {
		this.rostered = rostered;
	}

}