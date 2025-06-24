import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListadoPersonasAPP {
    public static void main(String[] args) {
        Scanner consola = new Scanner(System.in);
        //Definimos la lista fuera del ciclo while.
        List<Persona> personas = new ArrayList<>();
        //Empieza el menu.
        var salir = false;
        while (!salir) {
            mostrarMenu();
            try {
                salir = ejecutarOperacion(consola, personas);
            } catch (Exception e) {
                System.out.println("Ocurrio un error:" + e.getMessage());
            }
            System.out.println(" ");
        }
    }

    private static void mostrarMenu() {
        //Muestra las opciones.
        System.out.print("""
                **** Listado Personas App ****
                1. Agregar
                2. Listar
                3. Salir
                """);
        System.out.println("Seleccione la  opcion: ");
    }

    private static boolean ejecutarOperacion(Scanner consola, List<Persona> personas) {
        var opcion = Integer.parseInt(consola.nextLine());
        var salir = false;
        //Revisar la opcion proporcionada
        switch (opcion) {
            case 1 -> {//Agregar persona a la lista
                System.out.println("Introduce el nombre: ");
                var nombre = consola.nextLine();
                System.out.println("Introduce el telefono: ");
                var tel = consola.nextLine();
                System.out.println("Introduce el email: ");
                var email = consola.nextLine();
                //Crear el objeto persona.
                var persona = new Persona(nombre, tel, email);
                //Agregar a la lista.
                personas.add(persona);
                System.out.println("La lista tiene: " + personas.size() + " elementos.");
            } //fin caso 1
            case 2 -> {//listar las personas.
                System.out.println("Listado de personas: ");
                //Mejora usando lambda y metodo de referencia.
                //personas.forEach((persona) -> System.out.println(persona));
                personas.forEach(System.out::println);
            }//fin caso 2
            case 3 ->{//Salir del ciclo
                System.out.println("Hasta pronto...");
                salir = true;
            }//fin caso 3
            default -> System.out.println("Opcion erronea: " + opcion);
        }//fin de switch
        return salir;
    }//fin ejecutarOperacion
}//fin class