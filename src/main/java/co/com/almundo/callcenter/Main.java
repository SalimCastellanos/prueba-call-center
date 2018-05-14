package co.com.almundo.callcenter;

import java.io.IOException;
import java.net.URI;

import org.glassfish.grizzly.http.server.HttpServer;
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

		// Se crea y arranca la instancia de grizzly http server
		return GrizzlyHttpServerFactory.createHttpServer(URI.create(BASE_URI), rc);
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
