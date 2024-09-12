import java.util.HashMap;
import java.util.Map;

class Habitacion extends ElementoDelJuego {
    private String descripcion;
    private Map<String, Habitacion> salidas;
    private Item item;

    public Habitacion(String nombre, String descripcion) {
        super(nombre);
        this.descripcion = descripcion;
        this.salidas = new HashMap<>();
    }

    public void agregarSalida(String direccion, Habitacion habitacion) {
        salidas.put(direccion, habitacion);
    }

    public Habitacion obtenerSalida(String direccion) {
        return salidas.get(direccion);
    }

    public void ponerItem(Item item) {
        this.item = item;
    }

    public Item obtenerItem() {
        return item;
    }

    @Override
    public String describir() {
        StringBuilder descripcionCompleta = new StringBuilder();
        descripcionCompleta.append("Estás en ").append(nombre).append(". ").append(descripcion).append("\n");

        if (item != null) {
            descripcionCompleta.append("Puedes ver un ").append(item.getNombre()).append(" aquí.\n");
        }

        if (!salidas.isEmpty()) {
            descripcionCompleta.append("Salidas disponibles: ");
            for (String direccion : salidas.keySet()) {
                descripcionCompleta.append(direccion).append(" ");
            }
            descripcionCompleta.append("\n");
        }

        return descripcionCompleta.toString();
    }
}