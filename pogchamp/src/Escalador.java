public class Escalador extends Ciclista{
    float aceleracionPromedio;

    float gradoRampaLimite;
    public Escalador(int identificador, String nombre, int tiempoAcumulado, float aceleracionPromedio, float gradoRampaLimite) {
        super(identificador, nombre, tiempoAcumulado);
        this.aceleracionPromedio = aceleracionPromedio;
        this.gradoRampaLimite = gradoRampaLimite;
    }

    public float getAceleracionPromedio() {
        return aceleracionPromedio;
    }

    public void setAceleracionPromedio(float aceleracionPromedio) {
        this.aceleracionPromedio = aceleracionPromedio;
    }

    public float getGradoRampaLimite() {
        return gradoRampaLimite;
    }

    public void setGradoRampaLimite(float gradoRampaLimite) {
        this.gradoRampaLimite = gradoRampaLimite;
    }

    @Override
    String imprimirTipo() {
        return "Es un Escalador";
    }
}
