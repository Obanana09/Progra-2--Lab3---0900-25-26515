import java.util.Scanner;

// 19. Validar número mayor a 100.
public class Ej19_ValidarNumeroMayor100 {

    public static void validarMayorA100(int numero) {
        if (numero <= 100) {
            throw new IllegalArgumentException("El número debe ser mayor a 100.");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese un número mayor a 100: ");
        int numero = sc.nextInt();

        try {
            validarMayorA100(numero);
            System.out.println("Número válido: " + numero);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        sc.close();
    }
}
