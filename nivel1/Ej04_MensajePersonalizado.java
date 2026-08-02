import java.util.Scanner;

// 4. Mostrar mensaje personalizado en excepción.
public class Ej04_MensajePersonalizado {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese un divisor: ");
        int divisor = sc.nextInt();

        try {
            int resultado = 100 / divisor;
            System.out.println("Resultado: " + resultado);
        } catch (ArithmeticException e) {
            System.out.println("Mensaje personalizado: no puedes dividir 100 entre cero, intenta con otro valor.");
        }

        sc.close();
    }
}
