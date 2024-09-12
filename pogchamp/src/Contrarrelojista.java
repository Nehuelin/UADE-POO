public class Contrarrelojista extends Ciclista{
    int velocidadMaxima;
    public Contrarrelojista(int identificador, String nombre, int tiempoAcumulado, int velocidadMaxima) {
        super(identificador, nombre, tiempoAcumulado);
        this.velocidadMaxima = velocidadMaxima;
    }
    public int getVelocidadMaxima() {
        return velocidadMaxima;
    }

    public void setVelocidadMaxima(int velocidadMaxima) {
        this.velocidadMaxima = velocidadMaxima;
    }
    @Override
    String imprimirTipo() {
        return "Es un Contrarrelojista";
    }
}
