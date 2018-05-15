package co.com.almundo.callcenter.models;

public class Operator {

	private String name;
	private Charges charge;
	
	private boolean available;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Charges getCharge() {
		return charge;
	}

	public void setCharge(Charges charge) {
		this.charge = charge;
	}

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}
	
}
