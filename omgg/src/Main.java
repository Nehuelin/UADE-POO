public class Main {
    public static void main(String[] args) {
        CuentaBancaria cuenta = new CuentaBancaria("Nehuel", "Marcos", 1, "Corriente", 1000);
        CuentaBancaria cuenta2 = new CuentaBancaria("fulano", "ricardo", 2, "no se", 3000);
        cuenta.consignar(2000);
        cuenta.retirar(1000);
        System.out.println(cuenta.getSaldo());
        System.out.println(cuenta.esMayorA(cuenta2));
        cuenta.transferirA(cuenta2, 1000);
        System.out.println(cuenta2.getSaldo());

    }
}