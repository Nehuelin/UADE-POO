import java.util.Scanner;
// Clase principal para ejecutar el juego
public class Juego {
    private Habitacion sala;
    private Habitacion cocina;
    private Item llave;
    private Habitacion ubicacionActual;

    public Juego() {
        // Crear habitaciones
        sala = new Habitacion("Sala", "Una habitación grande con una ventana cerrada con llave.");
        cocina = new Habitacion("Cocina", "Una cocina pequeña con muchos utensilios.");

        // Crear ítems
        llave = new Item("Llave dorada");

        // Configurar salidas entre habitaciones
        sala.agregarSalida("sur", cocina);
        cocina.agregarSalida("norte", sala);

        // Colocar la llave en la cocina
        cocina.ponerItem(llave);

        // Iniciar en la sala
        ubicacionActual = sala;
    }

    public void mostrarEstado() {
        System.out.println(ubicacionActual.describir());
    }

    public void ir(String direccion) {
        Habitacion nuevaUbicacion = ubicacionActual.obtenerSalida(direccion);
        if (nuevaUbicacion != null) {
            ubicacionActual = nuevaUbicacion;
            System.out.println("Te has movido hacia " + direccion + ".");
        } else {
            System.out.println("No puedes ir en esa dirección.");
        }
    }

    public void recogerItem(String nombreItem) {
        Item item = ubicacionActual.obtenerItem();
        if (item != null && item.getNombre().equalsIgnoreCase(nombreItem)) {
            System.out.println("Has recogido " + item.getNombre() + ".");
            ubicacionActual.ponerItem(null); // Eliminar el item de la habitación
        } else {
            System.out.println("No hay un " + nombreItem + " aquí.");
        }
    }

    public void usarItem(String nombreItem) {
        if (nombreItem.equalsIgnoreCase("Llave dorada") && ubicacionActual.getNombre().equalsIgnoreCase("Sala")) {
            System.out.println("Usas la llave dorada para abrir la ventana. Ahora puedes salir.");
        } else {
            System.out.println("No puedes usar " + nombreItem + " aquí.");
        }
    }

    public static void main(String[] args) {
        Juego juego = new Juego();
        Scanner scanner = new Scanner(System.in);
        String comando;

        System.out.println("¡Bienvenido al juego!");

        while (true) {
            juego.mostrarEstado();
            System.out.println("¿Qué deseas hacer? (comandos: ir [direccion], recoger [item], usar [item], salir)");
            comando = scanner.nextLine();

            if (comando.startsWith("ir ")) {
                juego.ir(comando.substring(3));
            } else if (comando.startsWith("recoger ")) {
                juego.recogerItem(comando.substring(8));
            } else if (comando.startsWith("usar ")) {
                juego.usarItem(comando.substring(4));
            } else if (comando.equalsIgnoreCase("salir")) {
                System.out.println("¡Gracias por jugar!");
                break;
            } else {
                System.out.println("Comando no reconocido.");
            }
        }

        scanner.close();
    }
}
