package utilidades;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Utilidad { // clase Utilidades

	public static void limpiarPantalla() { // metodo para limpiar pantalla

		for (int i = 0; i < 25; i++) {

			System.out.println("");
		}
	}

	public static void continuar() { // metodo para pausar 

		int opcion2 = 0;

		try {
			Scanner leer2 = new Scanner(System.in);

			while (opcion2 != 1) {

				System.out.println("Ingrese 1 para continuar.....");
				opcion2 = leer2.nextInt();
				leer2.nextLine();

			}
			

		} catch (InputMismatchException e) {
			System.out.println("La opcion a ingresar debe ser un numero !");

		}
		
	}
	
}
