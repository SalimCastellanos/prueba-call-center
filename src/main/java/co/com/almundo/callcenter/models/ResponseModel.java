package co.com.almundo.callcenter.models;

public class ResponseModel {

	private Operator operator;

	private int callDurationInSeconds;

	public Operator getOperator() {
		return operator;
	}

	public void setOperator(Operator operator) {
		this.operator = operator;
	}

	public int getCallDurationInSeconds() {
		return callDurationInSeconds;
	}

	public void setCallDurationInSeconds(int callDurationInSeconds) {
		this.callDurationInSeconds = callDurationInSeconds;
	}

}
