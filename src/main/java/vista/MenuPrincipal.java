package vista;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import modelo.CategoriaEnum;
import modelo.Cliente;
import servicio.ArchivoServicio;
import servicio.ClienteServicio;
import servicio.Exportador;
import servicio.ExportadorCsv;
import servicio.ExportadorTxt;
import utilidades.Utilidad;

public class MenuPrincipal { // clase menu
	// instancia de la clase scanner
	protected Scanner leer = new Scanner(System.in);
	
	// instancia de clienteServicio
	ClienteServicio clienteServicio = new ClienteServicio();
	
	// instancia de lista de clientes
	List<Cliente> lista = clienteServicio.getListaClientes();
	
	// instancias de ArchiServicio
	
	Exportador exportarTxt = new ExportadorTxt(); // se aplica polimorfismo
	Exportador exportarCsv = new ExportadorCsv(); // se aplica polimorfismo
	ArchivoServicio importar = new ArchivoServicio();
	
	
	public final void iniciarMenu() {

		boolean salirMenu = false;
		

		while (!salirMenu) {

			System.out.println(" ***********************");
			System.out.println(" *   MENU PRINCIPAL    *");
			System.out.println(" ***********************");
			System.out.println(" * 1. Listar Clientes  *");
			System.out.println(" * 2. Agregar Clientes *");
			System.out.println(" * 3. Editar Cliente   *");
			System.out.println(" * 4. Cargar Datos     *");
			System.out.println(" * 5. Exportar Datos   *");
			System.out.println(" * 6. Salir            *");
			System.out.println(" ***********************");

			System.out.println("Ingrese opcion: ");

			String opcion = leer.nextLine();

			switch (opcion) { // switch/case para menu principal
			case "1":
				clienteServicio.listarCliente();
				break;
			case "2":
				System.out.println("-------- Crear Cliente -----------");
				System.out.println();
				System.out.println("Ingrese RUT del cliente: ");
				String rut = leer.nextLine();
				System.out.println("Ingrese nombre del cliente: ");
				String nombre = leer.nextLine();
				System.out.println("Ingrese apellido del cliente: ");
				String apellido = leer.nextLine();
				System.out.println("Ingrese anos como cliente: ");
				String anios = leer.nextLine();

				CategoriaEnum categoria = CategoriaEnum.ACTIVO;

				Cliente cliente = new Cliente(rut, nombre, apellido, anios, categoria);
				clienteServicio.agregarCliente(cliente);
				Utilidad.continuar();
				Utilidad.limpiarPantalla();
				break;
				
			case "3":
				
				System.out.println(" -------------- Editar Cliente -------------");
				System.out.println();
				System.out.println("Ingrese RUT del cliente: ");
				String rut2 = leer.nextLine();
				
				clienteServicio.editarCliente(rut2);
				Utilidad.continuar();
				Utilidad.limpiarPantalla();
				break;
				
			case "4":				
				System.out.println(" -------- Cargar Datos ---------");
				System.out.println();
				System.out.println("Ingrese la ruta en donde se encuentra el archivo DBClientes.csv");
				String ruta = leer.nextLine();
				
				File fileName = new File(ruta + "/DBClientes.csv");
				
				importar.cargarDatos(fileName.getAbsolutePath(), lista);
				Utilidad.continuar();
				Utilidad.limpiarPantalla();
				break;
				
			case "5":
				
				boolean error = false;
				
				System.out.println("------- Exportar Datos ---------");
				System.out.println("Seleccione el formato a exportar:");
				System.out.println("1.- Formato txt");
				System.out.println("2.- Formato csv");
				System.out.println();
				System.out.println("Ingrese una opcion para exportar:");
				System.out.println("----------------------------------");
				
				try {
				 
					String opcion3 = leer.nextLine();
					
					switch (opcion3) {
				
					case "1":
								
						System.out.println("Ingrese la ruta en donde desea exportar el archivo clientes.txt: ");
						String ruta2 = leer.nextLine();
									
						File fileName1 = new File(ruta2 + "/clientes.txt");	      				// Se declara e iniciliza variable tipo
				     																	        // File para el archivo
				
						if (fileName1.exists() == false) { 										// Si archivo no existe, se crea archivo
							fileName1.createNewFile();
							System.out.println("Archivo txt creado");
						}	
						exportarTxt.exportar (fileName1.getAbsolutePath(), lista);
				
						break;
				
					case "2":
							
						System.out.println("Ingrese la ruta en donde desea exportar el archivo clientes.csv: ");
						ruta = leer.nextLine();
											
						File fileName2 = new File(ruta + "/clientes.csv");	      			   	// Se declara e iniciliza variable tipo
					            															    // File para el archivo
					
						if (fileName2.exists() == false) { 										// Si archivo no existe, se crea archivo
							fileName2.createNewFile();
							System.out.println("Archivo csv creado");
						}
						exportarCsv.exportar(fileName2.getAbsolutePath(), lista);
						break;
					
					default:
						System.out.println("Ingrese una opcion valida");
					}	
						
				} catch (FileNotFoundException e) {
					System.out.println(e); // Mensaje en caso que no se encuentre archivo
					error = true;
				
				} catch (IOException e) {
					e.printStackTrace();
					error = true;
					
				} finally { // se ejecuta independiente de lo que ocurra en try-catch

					if (error == false) {
						System.out.println("Método exportar se ejecutó satisfactoriamente");

					} else {
							System.out.println("Ocurrió un error al ejecutar el programa");
					}
				}
				Utilidad.continuar();
				Utilidad.limpiarPantalla();
				
				break;
				
			case "6":
				salirMenu = true;
				Utilidad.limpiarPantalla();
				System.out.println("Hasta la proxima");
				break;
			default:
				System.out.println("Ingrese una opcion valida");
				}
			 }
	 	  }
		}
	  
	