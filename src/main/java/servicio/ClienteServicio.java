package servicio;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import modelo.CategoriaEnum;
import modelo.Cliente;
import utilidades.Utilidad;

public class ClienteServicio {

	List<Cliente> listaClientes = new ArrayList<Cliente>(); // se aplica polimorfismo
	
	public void listarCliente() { // metodo listar clientes
		
		if (listaClientes.isEmpty()) {
			System.out.println("No existen clientes para listar");
			Utilidad.continuar();
			Utilidad.limpiarPantalla();
		} else {

			listaClientes.stream().forEach(cli -> {  // uso metodo stream para iterar la lista

				System.out.println(" -------- Datos del Cliente ------------");
				System.out.println();
				System.out.println("RUT del Cliente :      " + cli.getRunCliente());
				System.out.println("Nombre del Cliente:    " + cli.getNombreCliente());
				System.out.println("Apellido del Cliente:  " + cli.getApellidoCliente());
				System.out.println("Años como clientes:    " + cli.getAniosCliente());
				System.out.println("Categoria del Cliente: " + cli.getNombreCategoria());
				System.out.println("----------------------------------------");
			});
			Utilidad.continuar();
			Utilidad.limpiarPantalla();
		}
	}	

	public void agregarCliente(Cliente cliente) { // metodo para agregar cliente
		
		if (cliente != null) {

			listaClientes.add(cliente);
			System.out.println("Cliente agregado");

		}

	}

	public void editarCliente(String rut) { // metodo para editar cliente 
		
		Scanner leer2 = new Scanner(System.in);
		
		// uso de metodo stream para filtrar rut cliente de la lista
		Cliente cliente = listaClientes.stream().filter(c -> c.getRunCliente().equalsIgnoreCase(rut)).findAny().orElse(null);
		
		if (cliente == null) {
			System.out.println("Cliente no existe");
		} else {
				
		System.out.println("Seleccione que desea hacer:");
		System.out.println("1.- Cambiar el estado del Cliente");
		System.out.println("2.- Editar los datos ingresados del Cliente");
		System.out.println();
		System.out.println("Ingrese opcion: ");
		String opcion = leer2.nextLine();
		
			switch (opcion) {
			
			case "1":
				
				System.out.println(" ----- Actualizando estado del Cliente -----");
				System.out.println("El estado actual es: " + cliente.getNombreCategoria());
				System.out.println("1.- Si desea cambiar el estado del Cliente");
				System.out.println("2.- Si desea mantener el estado del Cliente "+ cliente.getNombreCategoria());
				System.out.println();
				System.out.println("Ingrese ocion: ");
				String opcion2 = leer2.nextLine();
				 
				switch (opcion2) {
				
				case "1":
					if (cliente.getNombreCategoria().equals(CategoriaEnum.ACTIVO)) {
						cliente.setNombreCategoria(CategoriaEnum.INACTIVO);
						System.out.println("Cambio de estado satisfactorio");
						System.out.println("El estado actual es: " + cliente.getNombreCategoria());
					}else {
						cliente.setNombreCategoria(CategoriaEnum.ACTIVO );
						System.out.println("Cambio de estado satisfactorio");
						System.out.println("El estado actual es: " + cliente.getNombreCategoria());
					}
				break;
				case "2":
					System.out.println("Cliente mantiene estado");						
				break;
				}
			break;
			case "2":
				
			System.out.println("------------- Actualizando datos del Cliente ---------------");	
			System.out.println();	
			System.out.println("1.- El RUT del Cliente es :      " + cliente.getRunCliente());
			System.out.println("2.- El nombre del Cliente es :   " + cliente.getNombreCliente());
			System.out.println("3.- El apellido del Cliente es:  " + cliente.getApellidoCliente());
			System.out.println("4.- Los años como cliente son:   " + cliente.getAniosCliente());
			System.out.println();
			System.out.println("Ingrese opcion a modificar: ");
			String opcion3 = leer2.nextLine();

				switch (opcion3) {
			
				case "1":
					System.out.println("Ingrese nuevo RUT del Cliente: ");
					String rut2 = leer2.nextLine();
					cliente.setRunCliente(rut2);
					System.out.println("Dato cambiado con exito");
					break;
				case "2":
					System.out.println("Ingrese nuevo nombre del Cliente: ");
					String nombre = leer2.nextLine();
					cliente.setNombreCliente(nombre);
					System.out.println("Dato cambiado con exito");
					break;
				case "3":
					System.out.println("Ingrese nuevo apellido del Cliente: ");
					String apellido = leer2.nextLine();
					cliente.setApellidoCliente(apellido);
					System.out.println("Dato cambiado con exito");
					break;
				case "4":
					System.out.println("Ingrese nuevo años como Cliente: ");
					String anios = leer2.nextLine();
					cliente.setAniosCliente(anios);
					System.out.println("Dato cambiado con exito");
					break;	
				default :
					System.out.println("Opcion no valida....");
					break;
			
			
				}
			
			}
		
		}	

	}
	// getters an setters
	public List<Cliente> getListaClientes() {
		return listaClientes;
	}

	public void setListaClientes(List<Cliente> listaClientes) {
		this.listaClientes = listaClientes;
	}

}
