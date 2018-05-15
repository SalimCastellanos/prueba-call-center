package co.com.almundo.callcenter.manager;

import java.util.concurrent.ExecutionException;

import co.com.almundo.callcenter.models.ResponseModel;

/**
 * Clase encargada de atender las llamadas entrantes al Call Center
 * 
 * 
 * @author salim.castellanos
 *
 */
public interface DispatcherManager {
	
	/**
	 * Método encargado de atender una llamada al Call Center
	 * 
	 * @return
	 * @throws InterruptedException
	 * @throws ExecutionException
	 */
	public ResponseModel dispatchCall() throws InterruptedException, ExecutionException;

}
