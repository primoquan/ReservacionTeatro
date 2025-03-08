//Universidad Da Vinci de Guatemala
//Estructura de Datos
//Ingeniero Brandon Chitay
//Proyecto Gestor de boletos
//Luis Quan
//201927151

package src;


import java.util.Scanner;


public class MetodosMenu {
    private GestorBoletos gestor;
    private Scanner scanner;

    public MetodosMenu(GestorBoletos gestor) {
        this.gestor = gestor;
        this.scanner = new Scanner(System.in);
    }

    //Registramos nueva reservacion
    public void registrarReservacion() {
        System.out.print("Ingrese el nombre del cliente: ");
        String nombre = scanner.nextLine();
        int numeroAsiento;
        boolean asientoOcupado;
        do {
            System.out.print("Ingrese el número de asiento: ");
            numeroAsiento = scanner.nextInt();
            scanner.nextLine();
            asientoOcupado = gestor.asientoOcupado(numeroAsiento);
            if (asientoOcupado) {
                System.out.println("El asiento " + numeroAsiento + " ya está ocupado. Intente con otro.");
            }
        } while (asientoOcupado);
        gestor.registrarReservacion(nombre, numeroAsiento);
        System.out.println("Reservación registrada con éxito.");
    }

    //Cancelamos reservacion existente
    public void cancelarReservacion() {
        System.out.print("Ingrese el número de asiento a cancelar: ");
        int asientoCancelar = scanner.nextInt();
        if (gestor.cancelarReservacion(asientoCancelar)) {
            System.out.println("Reservación cancelada con éxito.");
        } else {
            System.out.println("El asiento no estaba reservado.");
        }
    }

    //Verificamos si el asiento esta ocupado
    public void verificarAsiento() {
        System.out.print("Ingrese el número de asiento a verificar: ");
        int asientoVerificar = scanner.nextInt();
        if (gestor.asientoOcupado(asientoVerificar)) {
            System.out.println("El asiento está ocupado.");
        } else {
            System.out.println("El asiento está disponible.");
        }
    }

    //Mostramos todas las reservaciones
    public void mostrarReservaciones() {
        gestor.mostrarReservaciones();
    }

    //Con este metodo asignamos el mejor asiento disponible
    public void asignarMejorAsiento() {
        System.out.print("Ingrese el nombre del cliente: ");
        String nombre = scanner.nextLine();
        int mejorAsiento = gestor.asignarMejorAsiento(nombre);
        if (mejorAsiento != -1) {
            System.out.println("Asiento asignado automáticamente: " + mejorAsiento);
        } else {
            System.out.println("No hay asientos disponibles.");
        }
    }
}