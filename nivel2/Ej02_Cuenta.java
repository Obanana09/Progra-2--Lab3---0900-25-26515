import java.util.Scanner;

// 6-10. Clase Cuenta con saldo privado, método depositar, método retirar con
// validación, prevención de saldo negativo y método para mostrar saldo.
public class Ej02_Cuenta {

    static class Cuenta {
        private double saldo;

        public Cuenta(double saldoInicial) {
            if (saldoInicial < 0) {
                throw new IllegalArgumentException("El saldo inicial no puede ser negativo.");
            }
            this.saldo = saldoInicial;
        }

        public void depositar(double monto) {
            if (monto <= 0) {
                throw new IllegalArgumentException("El monto a depositar debe ser positivo.");
            }
            saldo += monto;
        }

        public void retirar(double monto) {
            if (monto <= 0) {
                throw new IllegalArgumentException("El monto a retirar debe ser positivo.");
            }
            if (monto > saldo) {
                throw new IllegalArgumentException("Saldo insuficiente para retirar Q" + monto + ".");
            }
            saldo -= monto;
        }

        public void mostrarSaldo() {
            System.out.println("Saldo actual: Q" + saldo);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Cuenta cuenta = new Cuenta(100.0);
        cuenta.mostrarSaldo();

        System.out.print("Ingrese un monto a depositar: ");
        double deposito = Double.parseDouble(sc.nextLine());
        try {
            cuenta.depositar(deposito);
            cuenta.mostrarSaldo();
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.print("Ingrese un monto a retirar: ");
        double retiro = Double.parseDouble(sc.nextLine());
        try {
            cuenta.retirar(retiro);
            cuenta.mostrarSaldo();
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        sc.close();
    }
}
