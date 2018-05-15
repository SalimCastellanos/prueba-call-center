package co.com.almundo.callcenter.services;

import java.util.concurrent.ExecutionException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import co.com.almundo.callcenter.manager.DispatcherManager;
import co.com.almundo.callcenter.models.ResponseModel;
import co.com.almundo.callcenter.models.StatusCall;
import co.com.almundo.callcenter.util.Context;

/**
 * Recurso escargado de exponer los servicios del Call Center
 * 
 * @author salim.castellanos
 *
 */
@Path("dispatcher")
public class DispatcherService {

	DispatcherManager dispatcher = (DispatcherManager) Context.getBean(DispatcherManager.class);

	/**
	 * Método encargado de recibir una llamada
	 * 
	 * @return
	 * @throws ExecutionException
	 * @throws InterruptedException
	 */
	@GET
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseModel call() {
		ResponseModel response = new ResponseModel();
		try {
			response = dispatcher.dispatchCall();
		} catch (InterruptedException | ExecutionException e) {
			response.setStatus(StatusCall.FINALIZADA_FALLAS);
			e.printStackTrace();
		}
		return response;
	}

}
