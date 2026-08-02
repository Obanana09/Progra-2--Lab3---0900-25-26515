import java.util.Scanner;

// 18. Validar división segura con método.
public class Ej18_DivisionSegura {

    public static double dividirSeguro(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("No se puede dividir entre cero.");
        }
        return a / b;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese el dividendo: ");
        double a = sc.nextDouble();
        System.out.print("Ingrese el divisor: ");
        double b = sc.nextDouble();

        try {
            double resultado = dividirSeguro(a, b);
            System.out.println("Resultado: " + resultado);
        } catch (ArithmeticException e) {
            System.out.println("Error: " + e.getMessage());
        }

        sc.close();
    }
}
