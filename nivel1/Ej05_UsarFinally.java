import java.util.Scanner;

// 5. Usar finally para mostrar mensaje final.
public class Ej05_UsarFinally {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese un dividendo: ");
        int a = sc.nextInt();
        System.out.print("Ingrese un divisor: ");
        int b = sc.nextInt();

        try {
            int resultado = a / b;
            System.out.println("Resultado: " + resultado);
        } catch (ArithmeticException e) {
            System.out.println("Error: división entre cero no permitida.");
        } finally {
            System.out.println("Fin del proceso de división.");
        }

        sc.close();
    }
}
