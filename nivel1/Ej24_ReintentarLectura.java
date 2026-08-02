import java.util.Scanner;

// 24. Reintentar lectura si ocurre error.
public class Ej24_ReintentarLectura {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numero = 0;
        boolean valido = false;
        int intentos = 0;
        final int MAX_INTENTOS = 3;

        while (!valido && intentos < MAX_INTENTOS) {
            System.out.print("Ingrese un número entero: ");
            String entrada = sc.nextLine();

            try {
                numero = Integer.parseInt(entrada);
                valido = true;
            } catch (NumberFormatException e) {
                intentos++;
                System.out.println("Error: entrada inválida. Intento " + intentos + " de " + MAX_INTENTOS + ".");
            }
        }

        if (valido) {
            System.out.println("Número ingresado correctamente: " + numero);
        } else {
            System.out.println("Se agotaron los intentos. No se pudo leer un número válido.");
        }

        sc.close();
    }
}
