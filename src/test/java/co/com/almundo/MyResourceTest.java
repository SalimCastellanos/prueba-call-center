package co.com.almundo;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

import org.glassfish.grizzly.http.server.HttpServer;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class MyResourceTest {

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
     * Test para probar el correcto despliegue de la aplicacion.
     */
    @Test
    public void testGetIt() {
        String responseMsg = target.path("mytestresource").request().get(String.class);
        assertEquals("Call Center Almundo.com!", responseMsg);
    }
}
