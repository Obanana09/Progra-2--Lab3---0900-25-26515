import java.util.Scanner;

// 23. Controlar error en entrada de usuario.
public class Ej23_ControlarErrorEntradaUsuario {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese su edad (número entero): ");

        try {
            String entrada = sc.nextLine();
            int edad = Integer.parseInt(entrada);

            if (edad < 0 || edad > 120) {
                throw new IllegalArgumentException("La edad debe estar entre 0 y 120.");
            }

            System.out.println("Edad registrada: " + edad);
        } catch (NumberFormatException e) {
            System.out.println("Error: debe ingresar un número entero válido.");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        sc.close();
    }
}
