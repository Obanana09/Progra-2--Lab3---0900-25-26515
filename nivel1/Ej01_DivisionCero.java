import java.util.Scanner;

// 1. Capturar excepción al dividir entre cero.
public class Ej01_DivisionCero {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese el dividendo: ");
        int a = sc.nextInt();
        System.out.print("Ingrese el divisor: ");
        int b = sc.nextInt();

        try {
            int resultado = a / b;
            System.out.println("Resultado: " + resultado);
        } catch (ArithmeticException e) {
            System.out.println("Error: no se puede dividir entre cero.");
        }

        sc.close();
    }
}
