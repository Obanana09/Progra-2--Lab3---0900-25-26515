import java.util.Scanner;

// 10. Validar contraseña mínima (usar excepción).
public class Ej10_ValidarContrasenaMinima {

    public static void validarContrasena(String contrasena) {
        if (contrasena.length() < 8) {
            throw new IllegalArgumentException("La contraseña debe tener al menos 8 caracteres.");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese una contraseña: ");
        String contrasena = sc.nextLine();

        try {
            validarContrasena(contrasena);
            System.out.println("Contraseña válida.");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        sc.close();
    }
}
