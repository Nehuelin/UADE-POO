public class CuentaBancaria {
    private String nombre;
    private String apellido;
    private int numeroCuenta;
    private String tipoDeCuenta;
    private int saldo = 0;
    private double interesMensual = 1.5; // en %
    private boolean cuentaActiva;
    public CuentaBancaria(String nombre, String apellido, int numeroCuenta, String tipoDeCuenta, int saldo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.numeroCuenta = numeroCuenta;
        this.tipoDeCuenta = tipoDeCuenta;
        this.saldo = saldo;
        if (this.saldo > 0){
            this.cuentaActiva = true;
        } else {
            this.cuentaActiva = false;
        }
    }

    public String toString() {
        return "CuentaBancaria{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", numeroCuenta=" + numeroCuenta +
                ", tipoDeCuenta='" + tipoDeCuenta + '\'' +
                ", saldo=" + saldo +
                '}';
    }

    public int getSaldo() {
        return saldo;
    }

    public void consignar(int valor){
        if(!cuentaActiva){
            System.out.println("La cuenta no esta activa");
        } else {
            this.saldo += valor;
        }
    }

    public int retirar(int valor){
        if (valor <= this.saldo){
            this.saldo -= valor;
            if (this.saldo == 0){
                cuentaActiva = false;
            }
            return valor;
        } else {
            System.out.println("El valor excede el saldo actual");
            return 0;
        }
    }

    public double getSaldoWithInterests(){
        return (this.saldo * this.interesMensual);
    }

    public boolean esMayorA(CuentaBancaria B){
        if (this.saldo > B.getSaldo()){
            return true;
        } else {
            return false;
        }
    }

    public void transferirA(CuentaBancaria B, int valor){
        int transferencia = retirar(valor);
        if (transferencia == 0){
            return;
        } else {
            B.consignar(transferencia);
        }
    }



}
