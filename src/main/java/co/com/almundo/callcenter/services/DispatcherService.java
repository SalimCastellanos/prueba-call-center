package co.com.almundo.callcenter.services;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import co.com.almundo.callcenter.models.Charges;
import co.com.almundo.callcenter.models.ResponseModel;

/**
 * Recurso escargado de exponer los servicios del Call Center
 * 
 * @author salim.castellanos
 *
 */
@Path("dispatcher")
public class DispatcherService {
	
	/**
	 * Método encargado de recibir una llamada
	 * 
	 * @return
	 */
    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public ResponseModel getIt() {
    	
    	ResponseModel response = new ResponseModel();
    	
    	response.setOperatorName("Salim Castellanos");
    	response.setOperatorCharge(Charges.DIRECTOR);
    	response.setCallDurationInSeconds(21);

    	
        return response;
    }

}
