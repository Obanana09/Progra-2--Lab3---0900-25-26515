import java.util.Scanner;

// 21. Crear método que valide email simple.
public class Ej21_ValidarEmailSimple {

    public static void validarEmail(String email) {
        if (!email.contains("@") || !email.contains(".")) {
            throw new IllegalArgumentException("El email \"" + email + "\" no tiene un formato válido.");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese un email: ");
        String email = sc.nextLine();

        try {
            validarEmail(email);
            System.out.println("Email válido: " + email);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        sc.close();
    }
}
