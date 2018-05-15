package co.com.almundo.callcenter.models;

public enum Charges {

	OPERADOR(1), SUPERVISOR(2), DIRECTOR(3);
	private int value;

	private Charges(int value) {
		this.value = value;
	}

}
