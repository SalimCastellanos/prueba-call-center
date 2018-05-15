package co.com.almundo.callcenter.services;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

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
import co.com.almundo.callcenter.models.StatusCall;
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
	 * Test para probar el correcto despliegue de la aplicacion y hacer llamadas al
	 * Call Center.
	 * 
	 * @throws InterruptedException
	 * @throws ExecutionException
	 */
	@Test
	public void dispatcherServiceTest() throws InterruptedException, ExecutionException {

		ExecutorService callPool = Executors.newFixedThreadPool(100);

		Future<StatusCall> answer;

		Callable<StatusCall> callRequest = new Callable<StatusCall>() {
			@Override
			public StatusCall call() {
				ResponseModel responseCall = target.path("dispatcher").request().get(ResponseModel.class);
				return responseCall.getStatus();
			}
		};

		Future<StatusCall> call1 = callPool.submit(callRequest);
		Future<StatusCall> call2 = callPool.submit(callRequest);
		Future<StatusCall> call3 = callPool.submit(callRequest);
		Future<StatusCall> call4 = callPool.submit(callRequest);
		Future<StatusCall> call5 = callPool.submit(callRequest);
		Future<StatusCall> call6 = callPool.submit(callRequest);
		Future<StatusCall> call7 = callPool.submit(callRequest);
		Future<StatusCall> call8 = callPool.submit(callRequest);
		Future<StatusCall> call9 = callPool.submit(callRequest);
		Future<StatusCall> call10 = callPool.submit(callRequest);

		while (!call1.isDone() && !call2.isDone() && !call3.isDone() && !call4.isDone() && !call5.isDone()
				&& !call6.isDone() && !call7.isDone() && !call8.isDone() && !call9.isDone() && !call10.isDone()) {
			Thread.sleep(100);
		}

		assertEquals(StatusCall.FINALIZA_OK, (StatusCall) call1.get());
		assertEquals(StatusCall.FINALIZA_OK, (StatusCall) call2.get());
		assertEquals(StatusCall.FINALIZA_OK, (StatusCall) call3.get());
		assertEquals(StatusCall.FINALIZA_OK, (StatusCall) call4.get());
		assertEquals(StatusCall.FINALIZA_OK, (StatusCall) call5.get());
		assertEquals(StatusCall.FINALIZA_OK, (StatusCall) call6.get());
		assertEquals(StatusCall.FINALIZA_OK, (StatusCall) call7.get());
		assertEquals(StatusCall.FINALIZA_OK, (StatusCall) call8.get());
		assertEquals(StatusCall.FINALIZA_OK, (StatusCall) call9.get());
		assertEquals(StatusCall.FINALIZA_OK, (StatusCall) call10.get());
	}

	/**
	 * Test para probar el correcto despliegue de la aplicacion y hacer llamadas al
	 * Call Center.
	 * 
	 * @throws ExecutionException
	 * @throws InterruptedException
	 */
	// @Test
	// public void dispatcherManagerTest() throws InterruptedException,
	// ExecutionException {
	// for (int i = 0; i < 10; i++) {
	// ResponseModel responseCall = callCenter.dispatchCall();
	// assertEquals(true, responseCall.getOperator().isAvailable());
	// }
	// }
}
