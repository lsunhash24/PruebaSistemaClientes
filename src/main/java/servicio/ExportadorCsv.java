package servicio;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import modelo.Cliente;

public class ExportadorCsv extends Exportador { // clase ExportadorCsv que hereda de la clase Exportador

	// sobreescribe metodo de la clase abstracta
	@Override
	public void exportar(String fileName, List<Cliente> lista) {
		
		boolean error = false;

			try {
				
				BufferedWriter registro = new BufferedWriter(new FileWriter(fileName)); 	 // se instancia variable "registro" tipo
																				            // BufferedWriter

			if (lista.isEmpty()) {
				System.out.println("Lista vacia.....no se puede exportar datos....");
			} else {

				for (Cliente cliente : lista) { // se recorre lista a través de bucle for each
					
					// graba los productos en archivo temporal
				
					registro.write(cliente.getRunCliente() +  "," + cliente.getNombreCliente() + "," + cliente.getApellidoCliente() + "," + cliente.getAniosCliente() + "," + cliente.getNombreCategoria() + "\n");    
				}
				System.out.println("Datos de productos exportados correctamente en formato csv");
				registro.close();

			} 
			}catch (IOException e) { // Mensaje en caso que no se pueda crear el archivo
			  System.out.println(e); 
			  error = true;
			  
			}catch (NullPointerException e) { 
				System.out.println(e); 
				error = true;
				
			  } finally { // se ejecuta independiente de lo que ocurra en try-catch
			  
			  if (error == false) {
			  		  
			  } else { System.out.println("Ocurrió un error al exportar datos el programa"); }
			 
			}
		}
		
	}


