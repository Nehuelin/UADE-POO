abstract class ElementoDelJuego {
    protected String nombre;

    public ElementoDelJuego(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public abstract String describir();
}