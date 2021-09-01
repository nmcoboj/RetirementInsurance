package test;
import java.util.Scanner;

public class Menu {

    public Menu() {
    }
    
    public int MenuPrincipal() {
        int entrada;
        Scanner opcion = new Scanner(System.in);   
        do{ 
           System.out.println(" ");
           System.out.println("Ingresa el numero de la accion que quieres relizar:");
           System.out.println("1. Registrar Jubilados.");
           System.out.println("2. Listar Jubilados.");
           System.out.println("3. Salir del programa.");
           entrada =opcion.nextInt();
        }while(entrada>3 || entrada <1 );

        return entrada;
    }
     
}
