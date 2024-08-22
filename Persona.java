public class Persona {
    private String nombre;

    private int edad;

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public void cumplirAnios(){
        this.edad++;
    }

    public String saludar(){
        return "Hola soy " + this.nombre;
    }

    public String getNombre(){
        return  this.nombre;
    }
    public int getEdad(){
        return this.edad;
    }
}
