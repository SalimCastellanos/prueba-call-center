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

	/*
	 * (non-Javadoc)
	 * @see co.com.almundo.callcenter.dao.OperatorDao#getOperators()
	 */
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
			
			Operator operador4 = new Operator();
			operador4.setName("Operador4");
			operador4.setCharge(Charges.OPERADOR);
			operador4.setAvailable(true);
			operators.add(operador4);
			
			Operator operador5 = new Operator();
			operador5.setName("Operador4");
			operador5.setCharge(Charges.OPERADOR);
			operador5.setAvailable(true);
			operators.add(operador5);
			
			Operator operador6 = new Operator();
			operador6.setName("Operador6");
			operador6.setCharge(Charges.OPERADOR);
			operador6.setAvailable(true);
			operators.add(operador6);

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
			
			Operator supervisor3 = new Operator();
			supervisor3.setName("Supervisor3");
			supervisor3.setCharge(Charges.SUPERVISOR);
			supervisor3.setAvailable(true);
			operators.add(supervisor3);
			
			Operator supervisor4 = new Operator();
			supervisor4.setName("Supervisor4");
			supervisor4.setCharge(Charges.SUPERVISOR);
			supervisor4.setAvailable(true);
			operators.add(supervisor4);

			Operator director1 = new Operator();
			director1.setName("Director1");
			director1.setCharge(Charges.DIRECTOR);
			director1.setAvailable(true);
			operators.add(director1);
		}

		return operators;
	}

}
