import java.util.Scanner;

// 2. Validar entrada numérica con try-catch.
public class Ej02_ValidarEntradaNumerica {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese un número entero: ");
        String entrada = sc.nextLine();

        try {
            int numero = Integer.parseInt(entrada);
            System.out.println("El número ingresado es válido: " + numero);
        } catch (NumberFormatException e) {
            System.out.println("Error: la entrada no es un número entero válido.");
        }

        sc.close();
    }
}
