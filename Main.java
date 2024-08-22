public class Main {
    public static void main(String[] args) {
        Persona pablo = new Persona();
        pablo.setNombre("Pablo Hernandez");
        System.out.println("Pablo tiene " + pablo.getEdad() + " años de edad.");

        for (int i = 0; i < 25; i++) {
            pablo.cumplirAnios();
        }

        System.out.println("Pablo tiene " + pablo.getEdad() + " años de edad.");

        System.out.println(pablo.saludar());

    }
}
