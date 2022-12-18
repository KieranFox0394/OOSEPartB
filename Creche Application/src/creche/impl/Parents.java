package creche.impl;
import java.util.ArrayList;

public class Parents {
	private String name;
	private String address;
	private int contactDetails;
	private int parentId;

	public boolean registerChild(Child childToAdjust, Account user) {
		// TODO - implement Parents.registerChild
		throw new UnsupportedOperationException();
	}

	public boolean addChildToWaitingList(Child childToAdjust, Account user) {
		// TODO - implement Parents.addChildToWaitingList
		throw new UnsupportedOperationException();
	}

	public boolean removeChildFromWaitingList(Child childToAdjust, Account user) {
		// TODO - implement Parents.removeChildFromWaitingList
		throw new UnsupportedOperationException();
	}

	public ArrayList<Child> viewChildWaitingListStatus(Parents parentToRetrieve, Account user) {
		// TODO - implement Parents.viewChildWaitingListStatus
		throw new UnsupportedOperationException();
	}

	public boolean payChildFees(Parents parentToRetrieve, Account user) {
		// TODO - implement Parents.payChildFees
		throw new UnsupportedOperationException();
	}

	public ArrayList<Fees> viewPaymentHistory(Parents parentToRetrieve, Account user) {
		// TODO - implement Parents.viewPaymentHistory
		throw new UnsupportedOperationException();
	}

	public void addDesignatedGuardian(Child childToRetrieve, Account user) {
		// TODO - implement Parents.addDesignatedGuardian
		throw new UnsupportedOperationException();
	}

	public void adjustDesignatedGuardian(Child childToRetrieve, DesignatedGuardian designatedGuardianToRetrieve, Account user) {
		// TODO - implement Parents.adjustDesignatedGuardian
		throw new UnsupportedOperationException();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getContactDetails() {
		return contactDetails;
	}

	public void setContactDetails(int contactDetails) {
		this.contactDetails = contactDetails;
	}

	public int getParentId() {
		return parentId;
	}

	public void setParentId(int parentId) {
		this.parentId = parentId;
	}

}