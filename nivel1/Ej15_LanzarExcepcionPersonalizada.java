import java.util.Scanner;

// 15. Lanzar excepción personalizada.
public class Ej15_LanzarExcepcionPersonalizada {

    static class SaldoInsuficienteException extends Exception {
        public SaldoInsuficienteException(String mensaje) {
            super(mensaje);
        }
    }

    public static void retirar(double saldo, double monto) throws SaldoInsuficienteException {
        if (monto > saldo) {
            throw new SaldoInsuficienteException("Saldo insuficiente para retirar Q" + monto);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double saldo = 500.0;

        System.out.print("Ingrese el monto a retirar: ");
        double monto = sc.nextDouble();

        try {
            retirar(saldo, monto);
            System.out.println("Retiro exitoso de Q" + monto);
        } catch (SaldoInsuficienteException e) {
            System.out.println("Error: " + e.getMessage());
        }

        sc.close();
    }
}
