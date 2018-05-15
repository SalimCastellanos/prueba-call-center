package co.com.almundo.callcenter.dao;

import java.util.List;

import co.com.almundo.callcenter.models.Operator;

/**
 * Clase encargada de acceder a los datos de los operadores del Call Center
 * 
 * @author salim.castellanos
 *
 */
public interface OperatorDao {

	/**
	 * Función encargada de devolver los posibles operadores que pueden atender una llamada
	 * 
	 * @return List<Operator>
	 */
	public List<Operator> getOperators();

}
