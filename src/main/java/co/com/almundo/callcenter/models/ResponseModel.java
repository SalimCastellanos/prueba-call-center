package co.com.almundo.callcenter.models;

public class ResponseModel {

	private String operatorName;
	private Charges operatorCharge;

	private int callDurationInSeconds;

	public String getOperatorName() {
		return operatorName;
	}

	public void setOperatorName(String operatorName) {
		this.operatorName = operatorName;
	}

	public Charges getOperatorCharge() {
		return operatorCharge;
	}

	public void setOperatorCharge(Charges operatorCharge) {
		this.operatorCharge = operatorCharge;
	}

	public int getCallDurationInSeconds() {
		return callDurationInSeconds;
	}

	public void setCallDurationInSeconds(int callDurationInSeconds) {
		this.callDurationInSeconds = callDurationInSeconds;
	}

}
