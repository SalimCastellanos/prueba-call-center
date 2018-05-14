package co.com.almundo.callcenter.services;

import java.util.concurrent.ExecutionException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.com.almundo.callcenter.manager.DispatcherManager;
import co.com.almundo.callcenter.models.ResponseModel;
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
	public ResponseModel getIt() {

		ResponseModel responseCall = new ResponseModel();

		try {
			responseCall = dispatcher.dispatchCall();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}

		return responseCall;
	}

}
