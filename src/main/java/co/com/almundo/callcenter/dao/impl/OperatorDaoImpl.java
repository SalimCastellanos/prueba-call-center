package co.com.almundo.callcenter.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import co.com.almundo.callcenter.dao.OperatorDao;
import co.com.almundo.callcenter.models.Charges;
import co.com.almundo.callcenter.models.Operator;

@Component
public class OperatorDaoImpl implements OperatorDao {

	private static ArrayList<Operator> operators = null;

	@Override
	public List<Operator> getOperators() {

		if (operators == null) {
			operators = new ArrayList<>();

			Operator operador1 = new Operator();
			operador1.setName("Operador1");
			operador1.setCharge(Charges.OPERADOR);
			operador1.setAvailable(true);
			operators.add(operador1);

			Operator operador2 = new Operator();
			operador2.setName("Operador2");
			operador2.setCharge(Charges.OPERADOR);
			operador2.setAvailable(true);
			operators.add(operador2);

			Operator operador3 = new Operator();
			operador3.setName("Operador3");
			operador3.setCharge(Charges.OPERADOR);
			operador3.setAvailable(true);
			operators.add(operador3);

			Operator supervisor1 = new Operator();
			supervisor1.setName("Supervisor1");
			supervisor1.setCharge(Charges.SUPERVISOR);
			supervisor1.setAvailable(true);
			operators.add(supervisor1);

			Operator supervisor2 = new Operator();
			supervisor2.setName("Supervisor2");
			supervisor2.setCharge(Charges.SUPERVISOR);
			supervisor2.setAvailable(true);
			operators.add(supervisor2);

			Operator director1 = new Operator();
			director1.setName("Director1");
			director1.setCharge(Charges.DIRECTOR);
			director1.setAvailable(true);
			operators.add(director1);
		}

		return operators;
	}

}
