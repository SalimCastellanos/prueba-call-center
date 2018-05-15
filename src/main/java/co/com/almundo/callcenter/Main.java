package co.com.almundo.callcenter;

import java.io.IOException;
import java.net.URI;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.grizzly.http.server.NetworkListener;
import org.glassfish.grizzly.http.server.StaticHttpHandler;
import org.glassfish.grizzly.nio.transport.TCPNIOTransport;
import org.glassfish.grizzly.strategies.WorkerThreadIOStrategy;
import org.glassfish.grizzly.threadpool.GrizzlyExecutorService;
import org.glassfish.grizzly.threadpool.ThreadPoolConfig;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Main class.
 *
 */
public class Main {
	// URL base de la solución de Call-Center
	public static final String BASE_URI = "http://localhost:8080/callcenter/";
	
	private static final int MAX_POOL_SIZE = 10;
	private static final int CORE_POOL_SIZE =10;
	private static final int SELECTOR_POOL_SIZE = 100;

	/**
	 * Se arranca servidor de Grizzly HTTP utilizando el estandar JAX-RS
	 * 
	 * @return Grizzly HTTP server.
	 */
	public static HttpServer startServer() {
		// Se crear el ResourceConfig y se le indica el paquete a escanear
		final ResourceConfig rc = new ResourceConfig();

		rc.property("contextConfig", new AnnotationConfigApplicationContext(AppConfig.class));
		rc.packages("co.com.almundo.callcenter");
		
		HttpServer httpServer = GrizzlyHttpServerFactory.createHttpServer(URI.create(BASE_URI), rc);
		
		TCPNIOTransport transport = httpServer.getListeners().iterator().next().getTransport();
		int corePoolSize, maxPoolSize, selectorRunnerCount;
		
		corePoolSize = CORE_POOL_SIZE;
		maxPoolSize = MAX_POOL_SIZE;
		selectorRunnerCount = SELECTOR_POOL_SIZE;
		
		ThreadPoolConfig config = transport.getWorkerThreadPoolConfig().setPoolName("worker-thread-call-center")
				.setCorePoolSize(corePoolSize).setMaxPoolSize(maxPoolSize).setQueueLimit(-1);
		transport.configureBlocking(false);
		transport.setSelectorRunnersCount(selectorRunnerCount);
		transport.setWorkerThreadPoolConfig(config);
		transport.setIOStrategy(WorkerThreadIOStrategy.getInstance());
		transport.setTcpNoDelay(true);
		
		NetworkListener listener = httpServer.getListeners().iterator().next();
		GrizzlyExecutorService threadPool = (GrizzlyExecutorService) listener.getTransport().getWorkerThreadPool();
		threadPool.reconfigure(config);
		
		httpServer.getServerConfiguration()
		.addHttpHandler(new StaticHttpHandler(BASE_URI), "/");
		
		// Se crea y arranca la instancia de grizzly http server
		return httpServer;
	}

	/**
	 * Main method.
	 * 
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		final HttpServer server = startServer();
		
		System.out.println(String.format("Jersey app iniciada con WADL disponible en "
				+ "%sapplication.wadl\nDe enter para detener el servicio...", BASE_URI));
		System.in.read();
		server.stop();
	}
}
