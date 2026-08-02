import java.util.Scanner;

// 8. Manejar excepción en método.
public class Ej08_ManejarExcepcionEnMetodo {

    public static int dividir(int a, int b) {
        try {
            return a / b;
        } catch (ArithmeticException e) {
            System.out.println("Error dentro del método: no se puede dividir entre cero.");
            return 0;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese el dividendo: ");
        int a = sc.nextInt();
        System.out.print("Ingrese el divisor: ");
        int b = sc.nextInt();

        int resultado = dividir(a, b);
        System.out.println("Resultado: " + resultado);

        sc.close();
    }
}
