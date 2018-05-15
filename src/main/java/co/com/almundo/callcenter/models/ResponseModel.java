package co.com.almundo.callcenter.models;

public class ResponseModel {

	private Operator operator;

	private int callDurationInSeconds;
	
	private StatusCall status;

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

	public StatusCall getStatus() {
		return status;
	}

	public void setStatus(StatusCall status) {
		this.status = status;
	}
	
}
