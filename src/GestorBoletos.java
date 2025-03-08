package src;

import java.util.TreeMap;
import java.util.Queue;
import java.util.LinkedList;

// Clase que gestiona las reservaciones de boletos para un teatro.
public class GestorBoletos {
    private TreeMap<Integer, String> asientos;
    private Queue<Integer> colaReservaciones;

    public GestorBoletos() {
        asientos = new TreeMap<>();
        colaReservaciones = new LinkedList<>();
    }

    //Aqui vamos a registrar las reservaciones de los boletos y vamos a mostrar si ya esta ocupado el asiento
    public boolean registrarReservacion(String nombre, int numeroAsiento) {
        if (asientos.containsKey(numeroAsiento)) {
            return false;
        }
        asientos.put(numeroAsiento, nombre);
        colaReservaciones.offer(numeroAsiento);
        return true;
    }

    //con este vamos cancelar las reservaciones existentes y vamos a dejar un asiento libre
    public boolean cancelarReservacion(int numeroAsiento) {
        if (asientos.remove(numeroAsiento) != null) {
            colaReservaciones.remove(numeroAsiento);
            return true;
        }
        return false;
    }

    //con este vamos a verificar si el asiento ya esta ocupado
    public boolean asientoOcupado(int numeroAsiento) {
        return asientos.containsKey(numeroAsiento);
    }

    //Mostramos todas las reservaciones con asiento y nombre de la persona que lo reservo
    public void mostrarReservaciones() {
        if (colaReservaciones.isEmpty()) {
            System.out.println("No hay reservaciones registradas.");
        } else {
            for (Integer asiento : colaReservaciones) {
                System.out.println("Asiento: " + asiento + ", Nombre: " + asientos.get(asiento));
            }
        }
    }

    //Este metodo va asignar el mejor asiento si tenemos 100 asientos siendo el 1 el mejor y el 100 el peor
    public int asignarMejorAsiento(String nombre) {
        for (int i = 1; i <= 100; i++) {
            if (!asientos.containsKey(i)) {
                registrarReservacion(nombre, i);
                return i;
            }
        }
        return -1;
    }
}