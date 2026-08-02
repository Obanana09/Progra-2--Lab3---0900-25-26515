import java.util.Scanner;

// 7. Crear método que lance excepción si número es negativo.
public class Ej07_MetodoLanzaExcepcionNegativo {

    public static void validarNoNegativo(int numero) {
        if (numero < 0) {
            throw new IllegalArgumentException("El número " + numero + " es negativo.");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese un número: ");
        int numero = sc.nextInt();

        try {
            validarNoNegativo(numero);
            System.out.println("El número es válido.");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        sc.close();
    }
}
