package co.com.almundo.callcenter.services;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.ExecutionException;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

import org.glassfish.grizzly.http.server.HttpServer;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import co.com.almundo.callcenter.Main;
import co.com.almundo.callcenter.manager.DispatcherManager;
import co.com.almundo.callcenter.models.ResponseModel;
import co.com.almundo.callcenter.util.Context;

public class DispatcherServiceTest {
	
	DispatcherManager callCenter = (DispatcherManager) Context.getBean(DispatcherManager.class);;

    private HttpServer server;
    private WebTarget target;

    @Before
    public void setUp() throws Exception {
        // Se inicicia el servidor
        server = Main.startServer();
        
        // Se crea cliente para pruebast
        Client c = ClientBuilder.newClient();

        target = c.target(Main.BASE_URI);
    }

    @After
    public void tearDown() throws Exception {
        server.stop();
    }

    /**
     * Test para probar el correcto despliegue de la aplicacion y hacer llamadas al Call Center.
     */
    @Test
    public void dispatcherServiceTest() {
    	ResponseModel responseCall = target.path("dispatcher").request().get(ResponseModel.class);
        assertEquals(true, responseCall.getOperator().isAvailable());
    }
    
    /**
     * Test para probar el correcto despliegue de la aplicacion y hacer llamadas al Call Center.
     * @throws ExecutionException 
     * @throws InterruptedException 
     */
    @Test
    public void dispatcherManagerTest() throws InterruptedException, ExecutionException {
    	ResponseModel responseCall = callCenter.dispatchCall();
        assertEquals(true, responseCall.getOperator().isAvailable());
    }
}
