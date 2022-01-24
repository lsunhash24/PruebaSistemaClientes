package servicio;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import modelo.Cliente;

public class ExportadorTxt extends Exportador { // clase ExportadorTxt que hereda de la clase Exportador

	// sobrescribe metodo de la clase abstracta
	@Override
	public void exportar(String fileName, List<Cliente> lista) {
		try {
			
			BufferedWriter registro = new BufferedWriter(new FileWriter(fileName)); 	 // se instancia variable "registro" tipo
			      																         // BufferedWriter

		if (lista.isEmpty()) {
			System.out.println("Lista vacia.....no se puede exportar datos....");
		} else {
			int contador = 1;
			for (Cliente cliente : lista) { // se recorre lista a través de bucle for each
				// graba los productos en archivo temporal									
				registro.write("Cliente" + contador + " - Rut: " + cliente.getRunCliente() + " - Nombre: " + cliente.getNombreCliente() +
				" - Apellido: " + cliente.getApellidoCliente() + " - Años como cliente: " + cliente.getAniosCliente() + " - Categoria: " + cliente.getNombreCategoria() + "\n");    
				contador++;
			}
			System.out.println("Datos de productos exportados correctamente en formato txt");
			registro.close();

		} 
		}catch (IOException e) { // Mensaje en caso que no se pueda crear el archivo
		  System.out.println(e); 
		  		  
		}catch (NullPointerException e) { 
			System.out.println(e); 
						
		}
	}
}
