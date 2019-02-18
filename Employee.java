import java.util.List;
import java.util.Map;

import com.google.gson.annotations.SerializedName;

public class Employee {

	@SerializedName("empID")
	private int employeeID;
	private String name;
	@SerializedName("permanent")
	private boolean isPermanent;
	private Address address;
	private List<Integer> phoneNumbers;
	private String role;
	private List<String> cities;
	private Map<String, String> properties;

	public int getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isPermanent() {
		return isPermanent;
	}

	public void setPermanent(boolean isPermanent) {
		this.isPermanent = isPermanent;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public List<Integer> getPhoneNumbers() {
		return phoneNumbers;
	}

	public void setPhoneNumbers(List<Integer> phoneNumbers) {
		this.phoneNumbers = phoneNumbers;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public List<String> getCities() {
		return cities;
	}

	public void setCities(List<String> cities) {
		this.cities = cities;
	}

	public Map<String, String> getProperties() {
		return properties;
	}

	public void setProperties(Map<String, String> properties) {
		this.properties = properties;
	}

	@Override
	public String toString() {
		return "Employee [employeeID=" + employeeID + ", name=" + name + ", isPermanent=" + isPermanent + "\n address="
				+ address + "\n phoneNumbers=" + phoneNumbers + ", role=" + role + ", cities=" + cities
				+ ", properties=" + properties + "]";
	}

}
