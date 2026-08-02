import java.util.Scanner;

// 22. Validar longitud de texto con excepción.
public class Ej22_ValidarLongitudTexto {

    public static void validarLongitud(String texto, int longitudMaxima) {
        if (texto.length() > longitudMaxima) {
            throw new IllegalArgumentException(
                "El texto excede la longitud máxima de " + longitudMaxima + " caracteres.");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese un texto (máximo 20 caracteres): ");
        String texto = sc.nextLine();

        try {
            validarLongitud(texto, 20);
            System.out.println("Texto válido.");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        sc.close();
    }
}
