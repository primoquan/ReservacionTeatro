//Universidad Da Vinci de Guatemala
//Estructura de Datos
//Ingeniero Brandon Chitay
//Proyecto Gestor de boletos
//Luis Quan
//201927151

import src.*;
import java.util.Scanner;

//Esta es nuestra clase principal donde vamos a mostrar el menu y llamaremos a lo metodos para la gestion de boletos
public class Main {
    public static void main(String[] args) {
        GestorBoletos gestor = new GestorBoletos();
        MetodosMenu metodosmenu = new MetodosMenu(gestor);
        mostrarMenu(metodosmenu);
    }

    //Aqui mostramos el menu
    private static void mostrarMenu(MetodosMenu metodosmenu) {
        Scanner scanner = new Scanner(System.in);
        int opcion;
        do {
            System.out.println("Menú de Gestión de Boletos");
            System.out.println("1. Registrar reservación");
            System.out.println("2. Cancelar reservación");
            System.out.println("3. Verificar si un asiento está ocupado");
            System.out.println("4. Mostrar reservaciones");
            System.out.println("5. Asignar automáticamente el mejor asiento");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            //Vamos a la opcion seleccionada y llamamos al metodo
            switch (opcion) {
                case 1:
                    metodosmenu.registrarReservacion();
                    break;
                case 2:
                    metodosmenu.cancelarReservacion();
                    break;
                case 3:
                    metodosmenu.verificarAsiento();
                    break;
                case 4:
                    metodosmenu.mostrarReservaciones();
                    break;
                case 5:
                    metodosmenu.asignarMejorAsiento();
                    break;
                case 6:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
                    break;
            }
        } while (opcion != 6);

        scanner.close();
    }
}