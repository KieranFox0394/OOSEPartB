package creche.impl;
public class Attendance {

	private int childId;
	private int date;
	private String alternateCollection;
	private boolean collected;

	public int getChildId() {
		return childId;
	}

	public void setChildId(int childId) {
		this.childId = childId;
	}

	public int getDate() {
		return date;
	}

	public void setDate(int date) {
		this.date = date;
	}

	public String getAlternateCollection() {
		return alternateCollection;
	}

	public void setAlternateCollection(String alternateCollection) {
		this.alternateCollection = alternateCollection;
	}

	public boolean isCollected() {
		return collected;
	}

	public void setCollected(boolean collected) {
		this.collected = collected;
	}

}