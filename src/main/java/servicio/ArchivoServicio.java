package servicio;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import modelo.CategoriaEnum;
import modelo.Cliente;


public class ArchivoServicio {
	
		
	public void cargarDatos (String fileName, List<Cliente> listaClientes) {
		
		try {
			
			BufferedReader temporal = new BufferedReader(new FileReader(fileName));	// se instancia la variable temporal tipo BufferedReader

			String registro = temporal.readLine();                 // se crea una variable tipo string para almacenar el registro del archivo

			
			while (registro != null) { 		 // ciclo que se ejecuta hasta que el registro sea igual a nulo
				
				String lista[];				 // se inicializa una lista tipo string para almacenar los campos del cliente
				lista = registro.split(","); // se delimita el registro separados por comas a través del método split
				// se asigna a cada campo del registro los valores por medio de la lista estática
				String rutCliente = lista[0];
				String nombreCliente = lista[1];
				String apellidoCliente = lista[2];
				String aniosCliente =lista[3].substring(0, 2);
				CategoriaEnum categoriaCliente = CategoriaEnum.valueOf(lista[4].toUpperCase());
				// se agrega el objeto cliente a la lista dinámica
				listaClientes.add(new Cliente(rutCliente, nombreCliente, apellidoCliente, aniosCliente, categoriaCliente));
				
				registro = temporal.readLine(); // se lee el siguiente registro del archivo

			}
			
			temporal.close();
			
			System.out.println();
			System.out.println("Datos cargados correctamente en la lista....");

		} catch (IOException e) {

			System.out.println("Ocurrio un error al importar datos, ruta no coincide...");

		
		}
		
	}
		
}	
