import java.util.Scanner;

// 6. Pedir número y validar que sea positivo (con excepción).
public class Ej06_ValidarNumeroPositivo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese un número positivo: ");
        int numero = sc.nextInt();

        try {
            if (numero < 0) {
                throw new IllegalArgumentException("El número no puede ser negativo.");
            }
            System.out.println("Número válido: " + numero);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        sc.close();
    }
}
