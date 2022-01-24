package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.logging.Logger;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import modelo.CategoriaEnum;
import modelo.Cliente;
import servicio.ClienteServicio;

@DisplayName("Test clase ClienteServicio") 
public class ClienteServicioTest {
	
	private ClienteServicio clienteServicio;
	private static Logger logger = Logger.getLogger("test.ClienteServicioTest");
	
	
	@BeforeEach
	void setup() { // metodo que se ejecuta antes de cada test que instancia clienteServicio 
		
		clienteServicio = new ClienteServicio();
	}
	
	@Test // test que prueba el metodo agregar cliente
	public void agregarClienteTest() {
		logger.info("Info test agregar cliente");
		// se instancia un cliente con constructor con parametros
		Cliente cliente = new Cliente("1111111-1","Juan","Perez","2",CategoriaEnum.ACTIVO);
		// se ejecuta el metodo de agregar cliente
		clienteServicio.agregarCliente(cliente);
		// se verifica que la lista contenga al cliente agregado
		assertNotNull(clienteServicio.getListaClientes().contains(cliente));
				
	}
	@Test
	public void agregarClienteNullTest() {
		logger.info("Info test agregar cliente null");
		// se instancia un cliente nulo
		Cliente cliente = null;
		// se ejecuta el metodo para agregar cliente
		clienteServicio.agregarCliente(cliente);
		
		// se compara que el tamaño de la lista sea 0 porque el cliente creado es nulo
		assertEquals(clienteServicio.getListaClientes().size(),0);
		
			
	}
	
}
