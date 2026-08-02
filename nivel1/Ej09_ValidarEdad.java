import java.util.Scanner;

// 9. Validar edad (no negativa).
public class Ej09_ValidarEdad {

    public static void validarEdad(int edad) {
        if (edad < 0) {
            throw new IllegalArgumentException("La edad no puede ser negativa.");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese su edad: ");
        int edad = sc.nextInt();

        try {
            validarEdad(edad);
            System.out.println("Edad válida: " + edad);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        sc.close();
    }
}
