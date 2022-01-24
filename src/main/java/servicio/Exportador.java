package servicio;

import java.util.List;

import modelo.Cliente;

public abstract class Exportador { // clase abstracta exportador con metodo exportar
	
	public abstract void exportar(String fileName, List<Cliente> listaClientes);

	
	
}
