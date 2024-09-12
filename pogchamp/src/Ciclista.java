abstract class Ciclista {
    int identificador;
    String nombre;
    int tiempoAcumulado = 0;

    public Ciclista(int identificador, String nombre, int tiempoAcumulado) {
        this.identificador = identificador;
        this.nombre = nombre;
        this.tiempoAcumulado = tiempoAcumulado;
    }

    public int getIdentificador() {
        return identificador;
    }

    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTiempoAcumulado() {
        return tiempoAcumulado;
    }

    public void setTiempoAcumulado(int tiempoAcumulado) {
        this.tiempoAcumulado = tiempoAcumulado;
    }

    abstract String imprimirTipo();
}
