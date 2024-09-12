public class Equipo {
    String nombre;

    int identificacion;

    Ciclista[] ciclistas = new Ciclista[100];
    int i;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(int identificacion) {
        this.identificacion = identificacion;
    }

    protected String imprimirDatos(){
        return "Nombre: "+ this.nombre + "\nID: "+this.identificacion;
    }

    protected void agregarCiclista(Ciclista ciclista){
        this.ciclistas[i] = ciclista;
        this.i++;
    }

    protected int tiempoAcumulado(Ciclista[] ciclistas){
        int total = 0;
        int j = 0;
        boolean fin = false;
        while(!fin){
            total += ciclistas[j].tiempoAcumulado;
            if (ciclistas[j] == null){
                fin = true;
            }
            j++;
        }

        return total;
    }

    protected String[] listarNombres(Ciclista[] ciclistas){
        String[] lista = new String[100];
        int j = 0;
        boolean fin = false;
        while(!fin){
            lista[j] = ciclistas[j].nombre;
            if (ciclistas[j] == null){
                fin = true;
            }
            j++;
        }

        return lista;
    }

    protected String datosCiclista(int id){
        boolean fin = false;
        int j = 0;
        while(!fin){
            if (ciclistas[j] == null || ciclistas[j].identificador == id){
                fin = true;
            } else {
                j++;
            }
        }
        Ciclista ciclista = ciclistas[j];
        if (ciclista == null){
            return "No se encontro ciclista con id "+id;
        }
        else {
            return  "Nombre: "+ciclista.nombre + "\nTiempo acumulado: "+ciclista.tiempoAcumulado;
        }
    }
}
