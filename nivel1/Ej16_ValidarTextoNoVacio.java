import java.util.Scanner;

// 16. Validar que texto no esté vacío.
public class Ej16_ValidarTextoNoVacio {

    public static void validarNoVacio(String texto) {
        if (texto == null || texto.trim().isEmpty()) {
            throw new IllegalArgumentException("El texto no puede estar vacío.");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese un texto: ");
        String texto = sc.nextLine();

        try {
            validarNoVacio(texto);
            System.out.println("Texto válido: " + texto);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        sc.close();
    }
}
