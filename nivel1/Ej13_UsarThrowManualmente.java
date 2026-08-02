import java.util.Scanner;

// 13. Usar throw manualmente.
public class Ej13_UsarThrowManualmente {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese un número del 1 al 10: ");
        int numero = sc.nextInt();

        try {
            if (numero < 1 || numero > 10) {
                throw new IllegalArgumentException("El número debe estar entre 1 y 10.");
            }
            System.out.println("Número aceptado: " + numero);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        sc.close();
    }
}
