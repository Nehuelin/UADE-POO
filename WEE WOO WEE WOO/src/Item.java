class Item extends ElementoDelJuego {
    public Item(String nombre) {
        super(nombre);
    }

    @Override
    public String describir() {
        return "Has encontrado un " + nombre + ".";
    }
}